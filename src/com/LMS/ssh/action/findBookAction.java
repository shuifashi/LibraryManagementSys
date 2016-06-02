package com.LMS.ssh.action;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import java.util.Date; 

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
	
	private List bookList=new ArrayList();
	
	public List getBookList() {
		 return bookList;
	}
	
	public void setBookList(List bookList) {
		 this.bookList = bookList;
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

	public String execute() throws HibernateException, InterruptedException, ParseException {
		List<Object> resultbook = BookManager.findBook(book); 
	    
	    String s="2016-06-02 23:12:21";   
	    SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");   
	    java.util.Date du = sp.parse(s);
	    Calendar calendar=Calendar.getInstance();
	    calendar.setTime(du);	
	    calendar.add(Calendar.DAY_OF_MONTH,30);
	    java.util.Date endday = calendar.getTime();
	    System.out.println(du.toString());
	    System.out.println(sp.format(du));
	    System.out.println(sp.format(endday));
		if(resultbook.size() != 0) {
			bookList = resultbook;
			ActionContext.getContext().put("book1",resultbook);
			BeanUtils.copyProperties(resultbook.get(0), book);
			System.out.println(book.getBookId());
			return SUCCESS;
		} else {
			return ERROR;
		}

	}
}
