package com.demo.dto;



import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.demo.model.Endereco;
import com.demo.model.Usuario;
import com.demo.service.DateConverterService;

public class UsuarioDto {
	
	private Long id;

	@NotEmpty @NotBlank
	private String name;
	
	@NotEmpty @NotBlank
	private String email;
	
	@NotEmpty @NotBlank
	private String cpf;
	
	@NotEmpty @NotBlank
	private String birth_date;
	
	private List<Endereco> enderecos;

	public UsuarioDto(Usuario user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.cpf = user.getCpf();
		this.birth_date = user.getBirth_date().format(new DateConverterService().formatter).toString();
		this.id = user.getId();
		this.enderecos = user.getEnderecos();
	}
	
	
	public UsuarioDto(){
		
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
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	
}
