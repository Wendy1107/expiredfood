package com.jw.expiredfood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jw.expiredfood.bean.Users;
import com.jw.expiredfood.dao.UsersDAO;

@Component
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDAO signInDao;
	
	@Override
	public String signin(Users user) {
		Users userInfo = signInDao.checkAccount(user.getAccount());
		if (userInfo != null) {
			return "該帳號已被註冊!";
		}
		if (!user.getPassword().equals(user.getConfirm_password())) {
			return "請確認密碼!";
		} 
		if (signInDao.addUser(user) == 1) {
			return "恭喜你註冊成功!";
		} else {
			return "註冊失敗!";
		}
	}
}
