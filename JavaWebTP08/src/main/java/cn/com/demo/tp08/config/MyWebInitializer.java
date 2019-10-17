package cn.com.demo.tp08.config;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;

import cn.com.demo.tp08.filter.InitServletFilter;
import cn.com.demo.tp08.listener.MyServletContextListener;
import cn.com.demo.tp08.servlet.DemoServlet1;
import cn.com.demo.tp08.servlet.DemoServlet2;

@HandlesTypes(value = { IOthers.class })
public class MyWebInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		ctx.addFilter("DemoFilter", InitServletFilter.class);
		ServletRegistration reg = ctx.addServlet("DemoServlet1", DemoServlet1.class);
		reg.addMapping("/demoServlet1");
		reg = ctx.addServlet("DemoServlet2", DemoServlet2.class);
		reg.addMapping("/demoServlet2");

		ctx.addListener(MyServletContextListener.class);
		if (c != null)
			for (Class cls : c) {
				try {
					IOthers other = (IOthers) cls.newInstance();
					other.initDemoService();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}

}
