package com.oit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.oit.entity.booking;
import com.oit.entity.contact;
import com.oit.entity.signUp;
import com.oit.entity.user;
import com.oit.service.bookingService;
import com.oit.service.contactService;
import com.oit.service.signupService;
import com.oit.service.userService;

@Controller
public class userController {
	
	@Autowired
	private userService service;
	
	@Autowired
	private signupService signsService;
	
	@Autowired
	private bookingService bookservice;
	
	@Autowired
	private contactService contService;
	
	
		
	@GetMapping("/")
	public String home()
	{
		return "index";		
	}
	
	@GetMapping("loginpage")
	public String adduser() {		
		return "login";
	}
		
	@PostMapping("/loginSave")
	public String userRegister(@ModelAttribute user u)
	{	
		service.addUser(u);
		return "cars";
	}
	
	@PostMapping("/signupSave")
	public String userSignup(@ModelAttribute signUp s)
	{
		
		signsService.signupUser(s);
		return "cars";
	}
	
	@GetMapping("/fleets")
	public String cars()
	{
		return "book";
	}
	
	@PostMapping("/book")
	public String bookComplete(@ModelAttribute booking b)
	{
		bookservice.travalbook(b);
		return "redirect:/";	
	}
	
	@GetMapping("/register")
	public String signup()
	{
		return "signup";	
	}
	
	@PostMapping("/contact")
	public String contactSave(@ModelAttribute contact c)
	{
		contService.contactSave(c);
		return "redirect:/";	
	}
	
	
}
