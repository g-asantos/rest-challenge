package com.demo.dto;

import com.demo.model.Adress;

public class AdressDto {

	private String city;
	
	private String state;
	
	private String district;
	
	private Integer adress_number;
	
	private Integer complement;
	
	

	public AdressDto(Adress adress) {
		this.city = adress.getCity();
		this.state = adress.getState();
		this.district = adress.getDistrict();
		this.adress_number = adress.getAdress_number();
		this.complement = adress.getComplement();
	}
	
	public AdressDto() {
		
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
	
	
	
}
