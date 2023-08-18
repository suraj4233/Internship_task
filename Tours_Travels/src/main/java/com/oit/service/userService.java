package com.oit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oit.entity.user;
import com.oit.repository.userRepositry;

@Service
public class userService {
	
	@Autowired
	private userRepositry repo;
	
	public void addUser(user u)
	{
		repo.save(u);
	}

}
