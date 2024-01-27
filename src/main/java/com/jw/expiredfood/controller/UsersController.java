package com.jw.expiredfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jw.expiredfood.bean.Users;
import com.jw.expiredfood.service.UsersService;

@CrossOrigin
@RestController
public class UsersController {

	@Autowired
	UsersService usersService;

	/**
	 * 註冊功能
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/register")
	public String register(@RequestBody Users user) {

		return usersService.register(user);
	}

	/**
	 * email驗證功能
	 * 
	 * @param email
	 * @param first_name
	 * @param last_name
	 * @return
	 */
	@PostMapping("/verify")
	public String verifyMail(@RequestBody Users user) {

		return usersService.verify(user);
	}
	
	/**
	 * 驗證帳號是否重覆
	 * 
	 * @param account
	 * @return
	 */
	@GetMapping("/checkDuplicate")
	public boolean checkAccountDuplicate(@RequestParam String account) {
		System.out.println(account);
		return usersService.checkAccountDuplicate(account);
	}
	@GetMapping("/user_confirm")
	public String userConfirm(@RequestParam String p) {
		System.out.println("收到了"+p);
		return "驗證成功!";
	}
	
}
