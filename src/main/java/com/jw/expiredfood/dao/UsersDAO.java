package com.jw.expiredfood.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.jw.expiredfood.bean.Users;
import com.jw.expiredfood.rowMapper.UserRowMapper;

@Component
public class UsersDAO {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public Users qryUser(String account){
		String sql = ""; 
		sql += " SELECT user_id, account, password, email, mobile_phone, last_name, first_name ";
		sql += "      ,last_login_time, failed_login, created_time, updated_time ";
		sql += " FROM users WHERE 1=1 ";
		sql += "     AND account = :account ";
		Map<String, Object> map = new HashMap<>();
		map.put("account", account);
		
		List<Users> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());
		if (userList.size() > 0) {
			return userList.get(0);
		} else {
			return null;
		}
	}
	
	public int addUser(Users user) {
		String sql = "";
		sql += " INSERT INTO users( ";
		sql += "    account, password, email, mobile_phone, last_name, first_name ";
		sql += "    , verified, created_time, updated_time) ";
		sql += " VALUE(:account, :password, :email, :mobile_phone, :last_name, :first_name ";
		sql += "    , :verified, :created_time, :updated_time) ";
		
		Map<String, Object> map = new HashMap<>();
		Date now = new Date();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        map.put("account", user.getAccount());
        map.put("password", user.getPassword());
        map.put("email", user.getEmail());
        map.put("mobile_phone", user.getMobile_phone());
        map.put("last_name", user.getLast_name());
        map.put("first_name", user.getFirst_name());
        map.put("verified", "N");
        map.put("created_time", sdFormat.format(now));
        map.put("updated_time", sdFormat.format(now));
		
        int count = 0;
		count = namedParameterJdbcTemplate.update(sql, map);
		return count;
	}
	
	public int updateUser(Users user) {
		String sql = "";
		sql += " UPDATE users SET ";
		sql += "    password, mobile_phone, last_name, first_name ";
		sql += "    , updated_time) ";
		sql += " VALUE(:password, :mobile_phone, :last_name, :first_name ";
		sql += "    , :updated_time) ";
		sql += " WHERE 1=1 ";
		sql += "   AND user_id = :user_id ";
		sql += "   AND email = :email ";
		
		Map<String, Object> map = new HashMap<>();
		Date now = new Date();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        map.put("account", user.getAccount());
        map.put("password", user.getPassword());
        map.put("mobile_phone", user.getMobile_phone());
        map.put("last_name", user.getLast_name());
        map.put("first_name", user.getFirst_name());
        map.put("updated_time", sdFormat.format(now));
        map.put("user_id", user.getUser_id());
        map.put("email", user.getEmail());
		
        int count = 0;
		count = namedParameterJdbcTemplate.update(sql, map);
		return count;
	}
	
}
