package cn.com.demo.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.demo.spring.service.IUserService;

public class TestAOPMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService userService = (IUserService)ctx.getBean("userService");
		userService.service01();
	}

}
