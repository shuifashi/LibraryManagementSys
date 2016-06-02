package com.LMS.ssh.service;
import java.util.List;

import org.hibernate.HibernateException;

import com.LMS.ssh.beans.Book;
import com.LMS.ssh.forms.BookForm;
public interface BookManager {
	public void addBook(BookForm BookForm) throws HibernateException, InterruptedException;
	public List<Object> findBook(BookForm bookForm) throws HibernateException, InterruptedException;
}
