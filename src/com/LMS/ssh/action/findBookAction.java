package com.LMS.ssh.action;
import org.hibernate.HibernateException;

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
		Book resultbook = BookManager.findBook(book);
		if(resultbook != null) {
			ActionContext.getContext().put("name",resultbook);
			System.out.println(resultbook.getBookId());
			return SUCCESS;
		} else {
			return ERROR;
		}

	}
}
