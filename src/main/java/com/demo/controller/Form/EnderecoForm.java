package com.demo.controller.Form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class EnderecoForm {
	
	@NotEmpty @NotBlank
	private String cep;
	
	@NotEmpty @NotBlank
	private String user_id;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
}
