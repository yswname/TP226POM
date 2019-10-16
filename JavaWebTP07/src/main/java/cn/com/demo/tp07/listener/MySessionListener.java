package cn.com.demo.tp07.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("************create Session****************");
		// 从上下文中获取旧数据
		ServletContext ctx = se.getSession().getServletContext();
		int count = 0;
		Object countObj = ctx.getAttribute("ONLINE_COUNT");
		if(countObj != null) {
			count = (Integer)countObj;
		}
		// ++
		count++;
		// 替换旧数据
		ctx.setAttribute("ONLINE_COUNT", count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext ctx = se.getSession().getServletContext();
		int count = 0;
		Object countObj = ctx.getAttribute("ONLINE_COUNT");
		if(countObj != null) {
			count = (Integer)countObj;
		}
		// ++
		count--;
		if(count < 0) {
			count = 0;
		}
		// 替换旧数据
		ctx.setAttribute("ONLINE_COUNT", count);
	}

}
