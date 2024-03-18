package com.example.sjef.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sjef.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
