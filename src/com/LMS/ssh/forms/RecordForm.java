package com.LMS.ssh.forms;

public class RecordForm {
	private String recordId;
	private String userId;
	private String bookId;
	private String beginTime;
	private String endTime;
	private int type; // 0借书     1预约
	private int flag; // 0过期    1有效
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getRecordId() {
		return this.recordId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookId() {
		return this.bookId;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getBeginTime() {
		return this.beginTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getEndTime() {
		return this.endTime;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
	public void setFlag(int flag){
		this.flag = flag;
	}
	public int getFlag() {
		return this.flag;
	}
}
