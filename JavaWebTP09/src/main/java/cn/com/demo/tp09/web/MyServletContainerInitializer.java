package cn.com.demo.tp09.web;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;

public class MyServletContainerInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		SessionCookieConfig conf = ctx.getSessionCookieConfig();
		conf.setMaxAge(60*1000);
		
	}

}
