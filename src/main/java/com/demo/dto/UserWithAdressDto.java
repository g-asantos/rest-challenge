package com.demo.dto;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.demo.model.Adress;
import com.demo.model.User;

public class UserWithAdressDto {
	private Long id;

	@NotEmpty @NotBlank
	private String name;
	
	@NotEmpty @NotBlank
	private String email;
	
	@NotEmpty @NotBlank
	private String cpf;
	
	@NotEmpty @NotBlank
	private String birth_date;
	
	private List<AdressDto> enderecos;

	public UserWithAdressDto(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.cpf = user.getCpf();
		this.birth_date = user.getBirth_date().toString();
		this.id = user.getId();
		this.enderecos = converter(user.getEnderecos());
	}
	
	public UserWithAdressDto(){
		
	}
	
	
	public static List<AdressDto> converter(List<Adress> adress) {
		return adress.stream().map(AdressDto::new).collect(Collectors.toList());
	}
	
	public List<AdressDto> getEnderecos() {
		return enderecos;
	}

	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getBirth_date() {
		return birth_date;
	}
	
	
	public Long getId() {
		return id;
	}
}
