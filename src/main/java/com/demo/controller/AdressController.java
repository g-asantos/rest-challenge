package com.demo.controller;

import java.net.URI;

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
import com.demo.repository.AdressRepository;

@RestController
@RequestMapping("/enderecos")
public class AdressController {
	
	
	@Autowired
	private AdressRepository adressRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<AdressDto> register(@RequestBody @Valid AdressDto adressDto,
	UriComponentsBuilder uriBuilder){
		Adress adress = new Adress(adressDto.getCity(), adressDto.getState(), adressDto.getDistrict(),
				adressDto.getAdress_number(), adressDto.getComplement());
		
		adressRepository.save(adress);
		
		URI uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(adress.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new AdressDto(adress));
	}
}
