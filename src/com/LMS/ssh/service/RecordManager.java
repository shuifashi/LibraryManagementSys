package com.LMS.ssh.service;

import java.text.ParseException;
import java.util.List;

import org.hibernate.HibernateException;

import com.LMS.ssh.forms.RecordForm;

public interface RecordManager {
	public String Reserve(RecordForm recordForm) throws HibernateException, InterruptedException, ParseException;
	public String Borrow(RecordForm recordForm) throws HibernateException, InterruptedException;
	public String delReserve(RecordForm recordFor) throws HibernateException, InterruptedException;
	public String delBorrow(RecordForm recordForm) throws HibernateException, InterruptedException;
	public List<Object> findRecordbyUserId(RecordForm recordForm) throws HibernateException, InterruptedException;
}
