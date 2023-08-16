package com.oit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "travel_signup")
public class signUp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Username;
	private String email;
	private String password;
	private String cpassword;
	public signUp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public signUp(int id, String username, String email, String password, String cpassword) {
		super();
		this.id = id;
		Username = username;
		this.email = email;
		this.password = password;
		this.cpassword = cpassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	@Override
	public String toString() {
		return "signUp [id=" + id + ", Username=" + Username + ", email=" + email + ", password=" + password
				+ ", cpassword=" + cpassword + "]";
	}
	
	

}
