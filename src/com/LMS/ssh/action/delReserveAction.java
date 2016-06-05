package com.LMS.ssh.action;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;

import com.LMS.ssh.beans.Book;
import com.LMS.ssh.beans.Record;
import com.LMS.ssh.forms.BookForm;
import com.LMS.ssh.forms.RecordForm;
import com.LMS.ssh.forms.UserForm;
import com.LMS.ssh.service.BookManager;
import com.LMS.ssh.service.RecordManager;
import com.LMS.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class delReserveAction extends ActionSupport{
	private RecordForm record;
	private RecordManager RecordManager;
	private BookManager BookManager;
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
	public void setBookManager(BookManager BookManager) {
		this.BookManager = BookManager;
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
		if(record.getBookId() == null || record.getBookId().equals("")) {
			status = "«Î ‰»ÎbookId!";
			ActionContext.getContext().put("status",this.status);
			return ERROR;
		} else if(record.getUserId() == null || record.getUserId().equals("")){
			status = "«Î ‰»ÎUserId!";
			ActionContext.getContext().put("status",this.status);
			return ERROR;
		}
		RecordForm record1 = new RecordForm();
		BeanUtils.copyProperties(record,record1);
		status = this.RecordManager.delReserve(record1);
		if(status.equals("Success")) {
			ActionContext.getContext().put("status","Success!");
			List<Object> resultRecord = this.RecordManager.findRecordbyUserId(record);
			if(resultRecord != null && resultRecord.size() != 0) {
				Map<String, Book> bookmap = new HashMap();
				for(Object o : resultRecord) {
					Record searchRecord = (Record)o;
					BookForm bookform = new BookForm();
					bookform.setBookId(searchRecord.getBookId());
					System.out.println(searchRecord.getBookId());
					Book bookInfo = (Book)this.BookManager.findBook(bookform);
					bookmap.put(searchRecord.getBookId(),bookInfo);
					System.out.println(searchRecord.getBookId());
					System.out.println(bookInfo.getBookName());
				}
				ActionContext.getContext().getSession().put("Recordlist",resultRecord);
				ActionContext.getContext().getSession().put("bookmap",bookmap);
			}
			return SUCCESS;
		} else {
			ActionContext.getContext().put("status",this.status);
			return ERROR;
		}
	}
}
