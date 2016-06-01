package com.LMS.ssh.action;

import org.hibernate.HibernateException;

import com.LMS.ssh.forms.UserForm;
import com.LMS.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private UserForm user;

	private UserManager userManager;
	

	public UserForm getUser() {
		return user;
	}

	public void setUser(UserForm user) {
		this.user = user;
		this.user.setFlag(1);
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public String execute() throws HibernateException, InterruptedException {
		if(userManager.loginUser(user) == true) {
			ActionContext.getContext().getSession().put("name", user.getUserId());
			ActionContext.getContext().put("name",user.getUserId());
			return SUCCESS;
		} else {
			return ERROR;
		}

	}
}
