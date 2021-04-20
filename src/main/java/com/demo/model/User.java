package com.demo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = {"email", "cpf"}))
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	private String name;
	
	private String email;
	
	private String cpf;
	
	
	private LocalDateTime birth_date;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private List<Adress> enderecos = new ArrayList<>();
	
	
	
	
	public User(String name, String email, String cpf, LocalDateTime birth_date) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birth_date = birth_date;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDateTime getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(LocalDateTime birth_date) {
		this.birth_date = birth_date;
	}

	public List<Adress> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Adress> enderecos) {
		this.enderecos = enderecos;
	}
	
	
	
	
}
