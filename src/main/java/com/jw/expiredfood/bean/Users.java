package com.jw.expiredfood.bean;

import java.util.Date;

public class Users {
	
	private int user_id = 0;
	/** 使用者帳號 */
	private String account = "";
	/** 使用者密碼 */
	private String password = "";
	/** 確認密碼 */
	private String confirm_password = "";
	/** Email */
	private String email = "";
	/** 手機 */
	private String mobile_phone = "";
	/** 姓 */
	private String last_name = "";
	/** 名 */
	private String first_name = "";
	/** 最後登入時間 */
	private Date last_login_time;
	/** 登入失敗次數 */
	private int failed_login = 0;
	/** 建立時間 */
	private Date created_time;
	/** 更新時間 */
	private Date updated_time;
	/** 驗證 */
	private Date verified;
	/** 暫存密碼 */
	private Date temp_password;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile_phone() {
		return mobile_phone;
	}
	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	public int getFailed_login() {
		return failed_login;
	}
	public void setFailed_login(int failed_login) {
		this.failed_login = failed_login;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	public Date getUpdated_time() {
		return updated_time;
	}
	public void setUpdated_time(Date updated_time) {
		this.updated_time = updated_time;
	}
	public Date getVerified() {
		return verified;
	}
	public void setVerified(Date verified) {
		this.verified = verified;
	}
	public Date getTemp_password() {
		return temp_password;
	}
	public void setTemp_password(Date temp_password) {
		this.temp_password = temp_password;
	}
	
}
