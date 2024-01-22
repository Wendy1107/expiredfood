package com.jw.expiredfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jw.expiredfood.bean.Users;
import com.jw.expiredfood.service.SignInService;

@CrossOrigin
@RestController
public class UsersLoginController {
	
	@Autowired
	SignInService signInService;
	
	@PostMapping("/signin")
	public String signin(@RequestBody Users user) {
		
		return signInService.signin(user);
	}
	
}
