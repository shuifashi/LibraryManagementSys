package com.LMS.ssh.dao;

import java.util.List;

import org.hibernate.HibernateException;

public interface BaseDao {
	public void saveObject(Object obj) throws HibernateException;
	public String getObject(String name) throws HibernateException;
}
