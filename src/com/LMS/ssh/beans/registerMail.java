package com.LMS.ssh.beans;

public class registerMail {
	private String userId;
	private String username;
	private String email;
	
	public registerMail(String userid, String username, String email) {
		this.userId = userid;
		this.username = username;
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
