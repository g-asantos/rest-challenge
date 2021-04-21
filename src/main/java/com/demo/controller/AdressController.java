package com.demo.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.demo.dto.AdressDto;
import com.demo.model.Adress;
import com.demo.model.User;
import com.demo.repository.AdressRepository;
import com.demo.repository.UserRepository;

@RestController
@RequestMapping("/enderecos")
public class AdressController {
	
	
	@Autowired
	private AdressRepository adressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<AdressDto> register(@RequestBody @Valid AdressDto adressDto,
	UriComponentsBuilder uriBuilder){
		
		Optional<User> user = userRepository.findById(adressDto.getUser_id());
		
		if(user.isPresent()) {
			Adress adress = new Adress(adressDto.getCity(), adressDto.getState(), adressDto.getDistrict(),
					adressDto.getAdress_number(), adressDto.getComplement(), user.get(), adressDto.getCep());
			
			
			adressRepository.save(adress);
			
			user.get().addToEnderecos(adress);
			
			userRepository.save(user.get());
			
			URI uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(adress.getId()).toUri();
			
			return ResponseEntity.created(uri).body(new AdressDto(adress));
		}
		
		
		 return ResponseEntity.notFound().build();
	}
}
