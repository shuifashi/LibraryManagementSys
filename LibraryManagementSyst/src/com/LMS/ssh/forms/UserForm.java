package com.LMS.ssh.forms;

public class UserForm {


	private int userId;
	private String username;
	private String password;
	private String email;
	private int flag; //0允许借书，1不允许借书

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
