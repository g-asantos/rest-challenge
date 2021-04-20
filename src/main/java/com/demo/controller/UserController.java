package com.demo.controller;



import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dto.UserDto;
import com.demo.model.User;
import com.demo.repository.UserRepository;

@RestController
@RequestMapping("/usuarios")
public class UserController {

	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<UserDto> register(@RequestBody @Valid UserDto userDto,
	UriComponentsBuilder uriBuilder){
		User user = new User(userDto.getName(), userDto.getEmail(), userDto.getCpf(),
				userDto.getBirth_date());
		
		userRepository.save(user);
		
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new UserDto(user));
	}
}
