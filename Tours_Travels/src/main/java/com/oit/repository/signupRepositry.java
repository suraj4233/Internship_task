package com.oit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oit.entity.signUp;
@Repository
public interface signupRepositry extends JpaRepository<signUp, Integer> {

}
