package com.jw.expiredfood.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoginDAO {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public int testGetInfo(String user_id) {
		String sql = "SELECT * FROM USERS where user_id = :user_id";
		
		Map<String, Object> map = new HashMap<>();
        map.put("user_id", user_id);
		
        int count = 0;
		count = namedParameterJdbcTemplate.update(sql, map);
		return count;
	}

}
