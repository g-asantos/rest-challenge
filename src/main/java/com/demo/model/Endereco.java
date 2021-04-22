package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "endereços")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String cep;
	
	private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String localidade;
	
	private String uf;
	
	private String ibge;
	
	private String gia;
	
	private String ddd;
	
	private String siafi;
	
	@ManyToOne
    @JoinColumn(name="user_id")
	private Usuario user;
	


	public Endereco(Endereco adress, Usuario user) {
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
		this.user = user;
	}
	
	public Endereco() {
		
	}



	public Long getId() {
		return id;
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




	public Usuario getUser() {
		return user;
	}

	
	public void setUser(Usuario user) {
		this.user = user;
	}


}


