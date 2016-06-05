package com.LMS.ssh.action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;

import com.LMS.ssh.beans.Book;
import com.LMS.ssh.forms.BookForm;
import com.LMS.ssh.service.BookManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class bookInfoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private BookForm book;

	private BookManager BookManager;
	
	
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
		BookForm searchbook = new BookForm();
		BeanUtils.copyProperties(book,searchbook);
		Book result = (Book)BookManager.findBook(book);
		if(result != null) {
			ActionContext.getContext().put("bookInfo",result);
			System.out.println(book.getBookId());
			return SUCCESS;
		} else {
			return ERROR;
		}

	}
}
