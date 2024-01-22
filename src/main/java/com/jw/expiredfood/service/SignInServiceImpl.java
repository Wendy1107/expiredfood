package com.jw.expiredfood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jw.expiredfood.bean.Users;
import com.jw.expiredfood.dao.SignInDAO;

@Component
public class SignInServiceImpl implements SignInService {

	@Autowired
	SignInDAO signInDao;
	
	@Override
	public String signin(Users user) {
		Users userInfo = signInDao.checkAccount(user.getAccount());
		if (userInfo != null) {
			return "該帳號已被註冊!";
		}
		if (signInDao.addUser(user) == 1) {
			return "恭喜你註冊成功!";
		} else {
			return "註冊失敗!";
		}
	}
}
