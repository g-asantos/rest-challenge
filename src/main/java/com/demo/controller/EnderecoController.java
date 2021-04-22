package com.demo.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.demo.controller.Form.EnderecoForm;
import com.demo.dto.EnderecoDto;
import com.demo.model.Endereco;
import com.demo.model.Usuario;
import com.demo.repository.EnderecoRepository;
import com.demo.repository.UsuarioRepository;
import com.demo.service.CepService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	
	@Autowired
	private EnderecoRepository adressRepository;
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private CepService cepService;
	
	

	@GetMapping("/{cep}")
	   public Endereco getCep(String cep) {
			
	        Endereco adress = cepService.buscaEnderecoPorCep(cep);
	        return adress != null ? adress : null; 
	   }
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<EnderecoDto> register(@RequestBody @Valid EnderecoForm adressForm,
	UriComponentsBuilder uriBuilder){
		
		Optional<Usuario> user = userRepository.findById(Long.parseLong(adressForm.getUser_id()));
		
		if(user.isPresent()) {
			
			
			Endereco adress = new Endereco(getCep(adressForm.getCep()), user.get());
			
			adressRepository.save(adress);
			
			user.get().addToEnderecos(adress);
			
			userRepository.save(user.get());
			
			URI uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(adress.getId()).toUri();
			
			return ResponseEntity.created(uri).body(new EnderecoDto(adress));
		}
		
		
		 return ResponseEntity.notFound().build();
	}
}
