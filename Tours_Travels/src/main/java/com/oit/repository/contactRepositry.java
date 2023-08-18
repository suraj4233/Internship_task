package com.oit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oit.entity.contact;
@Repository
public interface contactRepositry extends JpaRepository<contact, Integer> {

}
