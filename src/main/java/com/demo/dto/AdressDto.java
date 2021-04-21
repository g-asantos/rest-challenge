package com.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.demo.model.Adress;


public class AdressDto {
	
	
	@NotEmpty @NotBlank
	private String city;
	
	@NotEmpty @NotBlank
	private String state;
	
	@NotEmpty @NotBlank
	private String district;
	
	@NotNull
	private Integer adress_number;
	
	private Integer complement;
	
	@NotEmpty @NotBlank
	private String cep;
	
	@NotNull
	private Long user_id;

	public AdressDto(Adress adress) {
		this.city = adress.getCity();
		this.state = adress.getState();
		this.district = adress.getDistrict();
		this.adress_number = adress.getAdress_number();
		this.complement = adress.getComplement();
		this.cep = adress.getCep();
		this.user_id = adress.getUser().getId();
	}
	

	public AdressDto() {
		
	}
	
	public Long getUser_id() {
		return user_id;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getDistrict() {
		return district;
	}

	public Integer getAdress_number() {
		return adress_number;
	}

	public Integer getComplement() {
		return complement;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	
}
