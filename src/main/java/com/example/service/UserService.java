package com.example.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.bean.Users;

public interface UserService extends UserDetailsService {
	
	public String saveUser(Users u);
	
	

}
