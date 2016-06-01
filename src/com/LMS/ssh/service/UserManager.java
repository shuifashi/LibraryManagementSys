package com.LMS.ssh.service;

import org.hibernate.HibernateException;

import com.LMS.ssh.forms.UserForm;

public interface UserManager {

	public void regUser(UserForm user) throws HibernateException, InterruptedException;

}
