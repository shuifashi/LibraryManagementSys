package com.LMS.ssh.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.LMS.ssh.beans.User;
import com.LMS.ssh.dao.BaseDao;

public class UserDao extends HibernateDaoSupport implements BaseDao {

	@Override
	public void saveObject(Object obj) throws HibernateException {
		getHibernateTemplate().save(obj);
	}

	@Override
	public String getObject(String name) throws HibernateException {
		// TODO Auto-generated method stub
		String hql= "from User as u where u.username=?";
		List<User> ls = getHibernateTemplate().find(hql,name);
		return ls.get(0).getUsername();
	}

}
