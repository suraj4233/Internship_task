package com.oit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oit.entity.user;
@Repository
public interface userRepositry extends JpaRepository<user, Integer> {

}
