package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Adress;

public interface AdressRepository extends JpaRepository<Adress, Long> {

}
