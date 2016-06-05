package com.LMS.ssh.action;

import org.hibernate.HibernateException;

import com.LMS.ssh.forms.UserForm;
import com.LMS.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class adminLoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private UserForm user;

	public UserForm getUser() {
		return user;
	}

	public void setUser(UserForm user) {
		this.user = user;
		this.user.setFlag(1);
	}


	public String execute() throws HibernateException, InterruptedException {
		if(user.getUserId().equals("admin")&&user.getPassword().equals("123456")) {
			ActionContext.getContext().getSession().put("userId", "amin");
			ActionContext.getContext().getSession().put("userName", "π‹¿Ì‘±");
			return SUCCESS;
		} else {
			ActionContext.getContext().put("error","UserId or Password is incorrect!");
			return ERROR;
		}

	}
}
