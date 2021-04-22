package com.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.demo.model.Endereco;


public class EnderecoDto {
	
	@NotEmpty @NotBlank
	private String cep;
	
	@NotEmpty @NotBlank
	private String logradouro;
	
	@NotEmpty @NotBlank
	private String complemento;
	
	@NotEmpty @NotBlank
	private String bairro;
	
	@NotEmpty @NotBlank
	private String localidade;
	
	@NotEmpty @NotBlank
	private String uf;
	
	@NotEmpty @NotBlank
	private String ibge;
	
	@NotEmpty @NotBlank
	private String gia;
	
	@NotEmpty @NotBlank
	private String ddd;
	
	@NotEmpty @NotBlank
	private String siafi;
	
	@NotNull
	private Long user_id;

	

	public EnderecoDto(Endereco adress) {
		this.cep = adress.getCep();
		this.logradouro = adress.getLogradouro();
		this.complemento = adress.getComplemento();
		this.bairro = adress.getBairro();
		this.localidade = adress.getLocalidade();
		this.uf = adress.getUf();
		this.ibge = adress.getIbge();
		this.gia = adress.getGia();
		this.ddd = adress.getDdd();
		this.siafi = adress.getSiafi();
		this.user_id = adress.getUser().getId();
	}



	public EnderecoDto() {
		
	}



	public String getCep() {
		return cep;
	}



	public String getLogradouro() {
		return logradouro;
	}



	public String getComplemento() {
		return complemento;
	}



	public String getBairro() {
		return bairro;
	}



	public String getLocalidade() {
		return localidade;
	}



	public String getUf() {
		return uf;
	}



	public String getIbge() {
		return ibge;
	}



	public String getGia() {
		return gia;
	}



	public String getDdd() {
		return ddd;
	}



	public String getSiafi() {
		return siafi;
	}



	public Long getUser_id() {
		return user_id;
	}
	
	
	
	
}
