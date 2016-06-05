package com.LMS.ssh.beans;

public class User {

	private String UserId;
	private String username;
	private String password;
	private String email;
	private int flag; //1允许借书和预约，0不允许借书和预约

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		this.UserId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String Email) {
		this.email = Email;
	}
	
	public int getFlag() {
		return flag;
	}
	
	public void setFlag(int Flag) {
		this.flag = Flag;
	}
}
