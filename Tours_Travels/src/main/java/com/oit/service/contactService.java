package com.oit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oit.entity.contact;
import com.oit.repository.contactRepositry;

@Service
public class contactService {
	
	
	@Autowired
	private contactRepositry contactRepo;
	
	public void contactSave(contact c) {
		contactRepo.save(c);
	}

}
