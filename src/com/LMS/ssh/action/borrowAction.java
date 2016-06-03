package com.LMS.ssh.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;

import com.LMS.ssh.beans.*;
import com.LMS.ssh.forms.*;
import com.LMS.ssh.service.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class borrowAction extends ActionSupport {
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
	
	public String execute() throws HibernateException, InterruptedException {
		status = this.RecordManager.Borrow(record);
		if(status.equals("Success")) {
			ActionContext.getContext().put("status","Success!");
			return SUCCESS;
		} else {
			ActionContext.getContext().put("status",this.status);
			return ERROR;
		}
	}
}
