package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bean.LoginDto;
import com.example.bean.Users;
import com.example.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepo userRepo;
	
	
	  @Autowired 
	  PasswordEncoder passwordEncoder;
	 
	
	@Override
	public String saveUser(Users u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return userRepo.saveUser(u);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginDto user = userRepo.getByName(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found");
		}
		return User.withUsername(user.getUserName())
				.password(user.getPassword()).authorities("user").build();
	}

}
