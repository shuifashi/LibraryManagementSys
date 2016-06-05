package com.LMS.ssh.beans;

public class reserveMail {
	String recordId;
	String email;
	String userName;
	String bookName;
	String endTime;
	int flag;
	public reserveMail(String recordId, String email, String userName, 
			String bookName, String endTime, int flag) {
		this.recordId = recordId;
		this.email = email;
		this.userName = userName;
		this.bookName = bookName;
		this.endTime = endTime;
		this.flag = flag; // 0预约等待 1预约成功
	}
	public reserveMail() {
		// TODO Auto-generated constructor stub
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getRecordId() {
		return this.recordId;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookName() {
		return this.bookName;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getEndTime() {
		return this.endTime;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getFlag() {
		return this.flag;
	}
}

