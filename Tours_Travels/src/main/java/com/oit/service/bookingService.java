package com.oit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oit.entity.booking;
import com.oit.repository.bookingRepositry;

@Service
public class bookingService {
	
	@Autowired
	private bookingRepositry bookrepo;
	
	public void travalbook(booking b) {
		bookrepo.save(b);		
	}
	

}
