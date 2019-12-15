package cn.com.demo.sm.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.demo.sm.entity.SpUser;
import cn.com.demo.sm.service.IUserService;

public class TestUserServiceImpl {
	private IUserService userService;
	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		userService = (IUserService)ctx.getBean("userService");
	}
	@Test
    public void testSearchUserById() {
    	SpUser user = userService.searchUserById(1);
    	System.out.println(user.getUrUserName());
    	Assert.assertNotNull(user);
    }
	@Test
	public void testAddUser() {
		SpUser user = new SpUser();
		user.setUrPassword("114");
		user.setUrUserName("sm04");
		this.userService.addUser(user);
	}
}
