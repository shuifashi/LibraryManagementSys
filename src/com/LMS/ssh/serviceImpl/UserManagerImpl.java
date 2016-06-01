package com.LMS.ssh.serviceImpl;
import mail.mailSender;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;

import com.LMS.ssh.beans.User;
import com.LMS.ssh.beans.registerMail;
import com.LMS.ssh.dao.UserDao;
import com.LMS.ssh.forms.UserForm;
import com.LMS.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionContext;

public class UserManagerImpl implements UserManager {

	private UserDao dao;

	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	public void sendEmail(User user) {
    	mailSender mail = new mailSender(user.getEmail(),"¹§Ï²"+user.getUsername()+"×¢²á³É¹¦!","¹§Ï²"+user.getUsername()+"×¢²á³É¹¦!");
    	mail.run();
    }
	@Override
	public void regUser(UserForm userForm) throws HibernateException, InterruptedException {
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		//registerMail email = new registerMail();
		//email.setUserId(user.getUserId());
		//email.setEmail(user.getEmail());
		//email.setUsername(user.getUsername());
		dao.saveObject(user);
		//dao.saveObject(email);
		//String name = dao.getObject(user.getUsername());
		//System.out.println(name);
		//ActionContext.getContext().put("name",name);
		//ActionContext.getContext().getSession().put("name", name);
		//sendEmail(user);
	}

}
