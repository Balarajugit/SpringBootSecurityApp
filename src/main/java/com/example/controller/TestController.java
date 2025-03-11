package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


public class TestController {
	
	@GetMapping("/logion")
	public String testLogin() {
		return "LoginPage";
	}
	
	@GetMapping("/reg")
	public String testRegister() {
		return "RegisterPage";
	}

}
