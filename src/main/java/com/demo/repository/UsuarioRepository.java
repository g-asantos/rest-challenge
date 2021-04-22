package com.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}
