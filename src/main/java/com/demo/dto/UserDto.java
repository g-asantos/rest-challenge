package com.demo.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.demo.model.User;

public class UserDto {
	
	

	private String name;
	
	@NotEmpty @NotBlank
	private String email;
	
	@NotEmpty @NotBlank
	private String cpf;
	
	private LocalDateTime birth_date;

	
	
	public UserDto(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.cpf = user.getCpf();
		this.birth_date = user.getBirth_date();
	}
	
	public UserDto(){
		
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

	public LocalDateTime getBirth_date() {
		return birth_date;
	}
	
	
	
	
}
