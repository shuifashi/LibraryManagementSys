package com.LMS.ssh.service;
import org.hibernate.HibernateException;

import com.LMS.ssh.beans.Book;
import com.LMS.ssh.forms.BookForm;
public interface BookManager {
	public void addBook(BookForm BookForm) throws HibernateException, InterruptedException;
	public Book findBook(BookForm bookForm) throws HibernateException, InterruptedException;
}
