package com.example.repo;

import com.example.bean.LoginDto;
import com.example.bean.Users;

public interface UserRepo {
	
	public String saveUser(Users u);
	
	public LoginDto getByName(String userName);
	

}
