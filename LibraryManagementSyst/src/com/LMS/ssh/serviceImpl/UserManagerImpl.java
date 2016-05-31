package com.LMS.ssh.serviceImpl;
import mail.mailSender;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;

import com.LMS.ssh.beans.User;
import com.LMS.ssh.dao.BaseDao;
import com.LMS.ssh.forms.UserForm;
import com.LMS.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionContext;

public class UserManagerImpl implements UserManager {

	private BaseDao dao;

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}
	public void sendEmail() {
    	mailSender mail = new mailSender("727032989@qq.com","123","test");
    	mail.run();
    }
	@Override
	public void regUser(UserForm userForm) throws HibernateException, InterruptedException {
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		dao.saveObject(user);
		String name = dao.getObject(user.getUsername());
		System.out.println(name);
		ActionContext.getContext().put("name",name);
		ActionContext.getContext().getSession().put("name", name);
		//sendEmail();
	}

}
