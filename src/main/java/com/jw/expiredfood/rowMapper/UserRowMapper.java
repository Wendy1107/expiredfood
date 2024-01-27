package com.jw.expiredfood.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jw.expiredfood.bean.Users;

public class UserRowMapper implements RowMapper<Users>{

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users users = new Users();
		users.setAccount(rs.getString("account"));
		users.setPassword(rs.getString("password"));
		users.setConfirm_password("confirm_password");
		users.setEmail(rs.getString("email"));
		users.setMobile_phone(rs.getString("mobile_phone"));
		users.setLast_name(rs.getString("last_name"));
		users.setFirst_name(rs.getString("first_name"));
		users.setLast_login_time(rs.getDate("last_login_time"));
		users.setFailed_login(rs.getInt("failed_login"));
		users.setCreated_time(rs.getDate("created_time"));
		users.setUpdated_time(rs.getDate("updated_time"));
		return users;
	}

}
