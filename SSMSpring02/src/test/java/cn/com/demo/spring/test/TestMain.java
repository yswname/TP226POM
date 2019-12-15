package cn.com.demo.spring.test;

import cn.com.demo.spring.service.impl.UserServiceImpl;

import cn.com.demo.spring.service.ServiceFactory;

public class TestMain {

	public static void main(String[] args) {
		UserServiceImpl userService = ServiceFactory.createUserService();
		userService.service01();
	}

}
