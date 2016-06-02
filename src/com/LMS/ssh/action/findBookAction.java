package com.LMS.ssh.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;

import com.LMS.ssh.beans.Book;
import com.LMS.ssh.forms.BookForm;
import com.LMS.ssh.forms.BookForm;
import com.LMS.ssh.service.BookManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class findBookAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private BookForm book;

	private BookManager BookManager;
	
	private List stuList=new ArrayList();
	
	public List getStuList() {
		 return stuList;
	}
	
	public void setStuList(List stuList) {
		 this.stuList = stuList;
	}
	public BookForm getBook() {
		return book;
	}

	public void setBook(BookForm Book) {
		this.book = Book;
	}

	public void setBookManager(BookManager BookManager) {
		this.BookManager = BookManager;
	}

	public String execute() throws HibernateException, InterruptedException {
		List<Object> resultbook = BookManager.findBook(book);
		if(resultbook.size() != 0) {
			stuList = resultbook;
			ActionContext.getContext().put("book1",resultbook);
			BeanUtils.copyProperties(resultbook.get(0), book);
			System.out.println(book.getBookId());
			return SUCCESS;
		} else {
			return ERROR;
		}

	}
}
