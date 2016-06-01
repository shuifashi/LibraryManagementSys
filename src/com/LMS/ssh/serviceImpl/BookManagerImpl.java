package com.LMS.ssh.serviceImpl;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;

import com.LMS.ssh.beans.Book;
import com.LMS.ssh.beans.User;
import com.LMS.ssh.dao.BaseDao;
import com.LMS.ssh.daoImpl.BookDaoImpl;
import com.LMS.ssh.forms.BookForm;
import com.LMS.ssh.service.BookManager;
import com.opensymphony.xwork2.ActionContext;
public class BookManagerImpl implements BookManager{
	private BookDaoImpl dao;

	public void setDao(BookDaoImpl dao) {
		this.dao = dao;
	}
	@Override
	public void addBook(BookForm BookForm) throws HibernateException, InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book findBook(BookForm bookForm) throws HibernateException, InterruptedException {
		Book book = new Book();
		BeanUtils.copyProperties(bookForm, book);
		System.out.println(book.getBookName());
		String queryString= "from Book as b where b.bookName='"+book.getBookName()+"'";
		Book result = (Book)dao.getObject(queryString);
		//User result2 = (User)dao.getObject(user);
		//System.out.println(result2.getUsername());
		return result;
	}

}
