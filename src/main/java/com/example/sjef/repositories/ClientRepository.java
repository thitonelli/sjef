package com.example.sjef.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sjef.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
