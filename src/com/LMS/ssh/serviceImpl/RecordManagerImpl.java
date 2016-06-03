package com.LMS.ssh.serviceImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;

import com.LMS.ssh.beans.Book;
import com.LMS.ssh.beans.User;
import com.LMS.ssh.beans.Record;
import com.LMS.ssh.beans.registerMail;
import com.LMS.ssh.dao.BaseDao;
import com.LMS.ssh.daoImpl.RecordDaoImpl;
import com.LMS.ssh.daoImpl.UserDaoImpl;
import com.LMS.ssh.daoImpl.BookDaoImpl;
import com.LMS.ssh.forms.RecordForm;
import com.LMS.ssh.service.BookManager;
import com.LMS.ssh.service.RecordManager;
import com.opensymphony.xwork2.ActionContext;
public class RecordManagerImpl implements RecordManager{
	private BookDaoImpl bookDao;
	private RecordDaoImpl recordDao;
	private UserDaoImpl userDao;
	public void setBookDao(BookDaoImpl bookDao) {
		this.bookDao = bookDao;
	}
	public void setRecordDao(RecordDaoImpl recordDao) {
		this.recordDao = recordDao;
	}
	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
	@Override
	public List<Object> findRecord(RecordForm recordForm) throws HibernateException, InterruptedException {
		Record record = new Record();
		BeanUtils.copyProperties(recordForm, record);
		StringBuffer queryString = new StringBuffer("from Record as r where r.userId = '"+record.getUserId()+"'");
		List<Object> list = this.recordDao.getObjectList(new String(queryString));
		return list;
	}
	@Override
	public synchronized String Reserve(RecordForm recordForm) throws HibernateException, InterruptedException, ParseException {
		Record record = new Record();
		BeanUtils.copyProperties(recordForm, record);	
		String statement = new String("from Book as b where b.bookId = '"+record.getBookId()+"'");
		Book book = (Book)bookDao.getObject(statement);
		statement = new String("from User as u where u.userId = '"+record.getUserId()+"'");
		User user = (User)userDao.getObject(statement);
		if(user.getFlag() == 1 && book.getFlag() == 2) {
			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date beginDay = new Date();
		    record.setType(1);
		    record.setFlag(1);
		    record.setBeginTime(sp.format(beginDay));
		    this.recordDao.saveObject(record);
		    book.setFlag(3);
			this.bookDao.update(book);
			return "Success";
		} else {
			System.out.println(user.getFlag());
			if(user.getFlag() == 0)
				return "用户权限被暂停!";
			else if(book.getFlag() == 1)
				return "书籍尚未借出，请直接前往图书馆借书!";
			else if(book.getFlag() == 3)
				return "书籍已经被预约!";
			else
				return "fail!";
		}
	}
	@Override
	public synchronized String Borrow(RecordForm recordForm) throws HibernateException, InterruptedException {
		Record record = new Record();
		BeanUtils.copyProperties(recordForm, record);	
		if(this.bookDao != null && this.recordDao != null && this.userDao != null)
			System.out.println("yes!!");
		String statement = new String("from Book as b where b.bookId = '"+record.getBookId()+"'");
		Book book = (Book)bookDao.getObject(statement);
		if(book != null)
			System.out.println(book.getFlag());
		statement = new String("from User as u where u.userId = '"+record.getUserId()+"'");
		User user = (User)userDao.getObject(statement);
		if(user != null)
			System.out.println(user.getFlag());
		if(book.getFlag() == 1 && user.getFlag() == 1) {
			/*String s="2016-06-02 23:12:21";   
		    SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");   
		    java.util.Date du = sp.parse(s);
		    Calendar calendar=Calendar.getInstance();
		    calendar.setTime(du);	
		    calendar.add(Calendar.DAY_OF_MONTH,30);
		    java.util.Date endday = calendar.getTime();
		    System.out.println(du.toString());
		    System.out.println(sp.format(du));
		    System.out.println(sp.format(endday));*/
			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date beginDay = new Date();
			Calendar calendar=Calendar.getInstance();
		    calendar.setTime(beginDay);	
		    calendar.add(Calendar.DAY_OF_MONTH,30);
		    Date endDay = calendar.getTime();
		    record.setType(0);
		    record.setFlag(1);
		    record.setBeginTime(sp.format(beginDay));
		    record.setEndTime(sp.format(endDay));
		    this.recordDao.saveObject(record);
		    book.setFlag(2);
			this.bookDao.update(book);
			System.out.println("OK");
			return "Success";
		} else {
			if(book.getFlag() != 1)
				return "书籍已经被借出!";
			else
				return "用户权限被暂停!";
		}
	}
	@Override
	public synchronized String delReserve(RecordForm recordForm) throws HibernateException, InterruptedException {
		// TODO Auto-generated method stub
		Record re = new Record();
		BeanUtils.copyProperties(recordForm, re);	
		String statement = new String("from Record as r where r.recordId = '"+ re.getRecordId()+"'");
		Record record = (Record)this.recordDao.getObject(statement);
		System.out.println(record.getRecordId());
		statement = new String("from Book as b where b.bookId = '"+record.getBookId()+"'");
		Book book = (Book)bookDao.getObject(statement);
		if(book.getFlag() == 3 && record.getType() == 1) {
			statement = new String("from Record as r where r.recordId = '"+record.getRecordId()+"'");
			Record history = (Record)this.recordDao.getObject(statement);
			book.setFlag(2);
			this.bookDao.update(book);
			this.recordDao.delete(history);
			return "Success";
		}
		return "Fail";
	}
	@Override
	public synchronized String delBorrow(RecordForm recordForm) throws HibernateException, InterruptedException {
		Record re = new Record();
		BeanUtils.copyProperties(recordForm, re);	
		String statement = new String("from Record as r where r.recordId = '"+ re.getRecordId()+"'");
		Record record = (Record)this.recordDao.getObject(statement);
		System.out.println(record.getRecordId());
		statement = new String("from Book as b where b.bookId = '"+record.getBookId()+"'");
		Book book = (Book)bookDao.getObject(statement);
		if(book.getFlag() == 3 && record.getType() == 1) {
			statement = new String("from Record as r where r.recordId = '"+record.getRecordId()+"'");
			Record history = (Record)this.recordDao.getObject(statement);
			book.setFlag(2);
			this.bookDao.update(book);
			this.recordDao.delete(history);
			return "Success";
		}
		return "Fail";
	}
	
}
