package com.demo.controller;



import java.net.URI;
import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dto.UserDto;
import com.demo.dto.UserWithAdressDto;
import com.demo.model.User;
import com.demo.repository.UserRepository;
import com.demo.service.DateConverterService;

@RestController
@RequestMapping("/usuarios")
public class UserController {

	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<UserDto> register(@RequestBody @Valid UserDto userDto,
	UriComponentsBuilder uriBuilder){
		
		DateConverterService dateConverter = new DateConverterService();
		
		LocalDate convertedDate = dateConverter.formatStringDate(userDto.getBirth_date());
		
		User user = new User(userDto.getName(), userDto.getEmail(), userDto.getCpf(),
				convertedDate);
		
		userRepository.save(user);
		
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new UserDto(user));
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> getByIdWithAdress(@PathVariable
			Long id,
			UriComponentsBuilder uriBuilder){
		
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			
			return ResponseEntity.status(200).body(new UserWithAdressDto(user.get()));
		}
		

		 return ResponseEntity.status(404).body("Usuário não encontrado");
	}
}
