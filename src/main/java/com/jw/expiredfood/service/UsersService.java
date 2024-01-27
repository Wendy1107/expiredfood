package com.jw.expiredfood.service;

import java.util.Map;

import com.jw.expiredfood.bean.Users;

public interface UsersService {

	/**
	 * 註冊功能
	 * 
	 * @param user
	 * @return
	 */
	public String register(Users user);

	/**
	 * email驗證功能
	 * 
	 * @param params
	 * @return
	 */
	public String verify(Users user);
	
	/**
	 * 帳號是否重覆
	 * 
	 * @param account
	 * @return
	 */
	public boolean checkAccountDuplicate(String account);
}
