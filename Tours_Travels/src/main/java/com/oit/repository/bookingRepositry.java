package com.oit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oit.entity.booking;
@Repository
public interface bookingRepositry extends JpaRepository<booking, Integer> {

}
