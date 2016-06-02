package com.LMS.ssh.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.LMS.ssh.dao.BaseDao;

public class RecordDaoImpl extends HibernateDaoSupport implements BaseDao{

	@Override
	public void saveObject(Object obj) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getObject(String queryString) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject(Object object) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getObjectList(String queryString) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
