package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "endereços")
public class Adress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String city;
	
	private String state;
	
	private String district;
	
	private Integer adress_number;
	
	private Integer complement;
	

	public Adress(String city, String state, String district, Integer adress_number, Integer complement) {
		this.city = city;
		this.state = state;
		this.district = district;
		this.adress_number = adress_number;
		this.complement = complement;
	}

	public Long getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getAdress_number() {
		return adress_number;
	}

	public void setAdress_number(Integer adress_number) {
		this.adress_number = adress_number;
	}

	public Integer getComplement() {
		return complement;
	}

	public void setComplement(Integer complement) {
		this.complement = complement;
	}
	
	
	

}

