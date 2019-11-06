package cn.com.demo.javaweb.shopping.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.com.demo.javaweb.shopping.entity.SpUser;
//@WebListener
public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		SpUser user = new SpUser();
		user.setUrId(1);
		user.setUrPassword("123456");
		user.setUrUserName("zhangsan");
		session.setAttribute("LOGIN_USER", user);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

}
