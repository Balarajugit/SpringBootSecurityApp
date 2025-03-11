package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bean.LoginDto;
import com.example.bean.Users;
import com.example.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/login")
	public String loginPage() {
		return "LoginPage";
	}
	
	@GetMapping("/reg")
	public String regPage() {
		return "RegisterPage";
	}
	
	@PostMapping("/register")
	public String saveUser(@ModelAttribute("user") Users users,Model map) {
		String res = userService.saveUser(users);
		map.addAttribute("res", res);
		return "RegisterPage";
	}
	
	
	/*
	 * @PostMapping("/authenticate") public void
	 * authenticateUser(@ModelAttribute("login") LoginDto login) {
	 * userService.loadUserByUsername(login.getUserName()); }
	 */
	 
	
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/logout")
	public String logOutToHomePage() {
		return "LoginPage";
	}

}
