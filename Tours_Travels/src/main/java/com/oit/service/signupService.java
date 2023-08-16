package com.oit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oit.entity.signUp;
import com.oit.entity.user;
import com.oit.repository.signupRepositry;

@Service
public class signupService {
	
	@Autowired 
	private signupRepositry signRepo;
	

	public void signupUser(signUp s)
	{
		signRepo.save(s);
	}

}
