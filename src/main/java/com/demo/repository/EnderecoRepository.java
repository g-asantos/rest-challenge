package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
