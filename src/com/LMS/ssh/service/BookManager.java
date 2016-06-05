package com.LMS.ssh.service;
import java.util.List;

import org.hibernate.HibernateException;

import com.LMS.ssh.beans.Book;
import com.LMS.ssh.forms.BookForm;
public interface BookManager {
	public void addBook(BookForm BookForm) throws HibernateException, InterruptedException;
	public List<Object> normalfindBook(BookForm bookForm) throws HibernateException, InterruptedException;
	public List<Object> superfindBook(BookForm bookForm) throws HibernateException, InterruptedException;
	public Object findBook(BookForm book)throws HibernateException, InterruptedException;
}
