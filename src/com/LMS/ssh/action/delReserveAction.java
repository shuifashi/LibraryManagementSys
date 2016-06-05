package com.LMS.ssh.action;

import java.text.ParseException;

import org.hibernate.HibernateException;

import com.LMS.ssh.forms.RecordForm;
import com.LMS.ssh.forms.UserForm;
import com.LMS.ssh.service.RecordManager;
import com.LMS.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class delReserveAction extends ActionSupport{
	private RecordForm record;

	private RecordManager RecordManager;
	
	private String status;
	
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return this.status;
	}
	
	public RecordForm getRecord() {
		return record;
	}
	
	public void setRecord(RecordForm record) {
		this.record = record;
	}
	
	public void setRecordManager(RecordManager RecordManager) {
		this.RecordManager = RecordManager;
	}
	
	public String execute() throws HibernateException, InterruptedException, ParseException {
		/*if(record.getBookId() == null || record.getBookId().equals("")) {
			status = "«Î ‰»ÎbookId!";
			ActionContext.getContext().put("status",this.status);
			return ERROR;
		} else if(record.getUserId() == null || record.getUserId().equals("")){
			status = "«Î ‰»ÎUserId!";
			ActionContext.getContext().put("status",this.status);
			return ERROR;
		}*/
		if(record.getRecordId() == null || record.getRecordId().equals("")){
			status = "«Î ‰»ÎRecordId!";
			ActionContext.getContext().put("status",this.status);
			return ERROR;
		}
		status = this.RecordManager.delReserve(record);
		if(status.equals("Success")) {
			ActionContext.getContext().put("status","Success!");
			return SUCCESS;
		} else {
			ActionContext.getContext().put("status",this.status);
			return ERROR;
		}
	}
}
