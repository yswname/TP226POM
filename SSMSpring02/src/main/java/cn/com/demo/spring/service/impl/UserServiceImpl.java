package cn.com.demo.spring.service.impl;

import cn.com.demo.spring.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Override
	public boolean verify(String userName, String password) {
		System.out.println("******* verify2 ");
		return false;
	}

	@Override
	public boolean verify(String userName, String password, int age) {
		System.out.println("******* verify1 ");
		return true;
	}

	@Override
	public void service01() {
		System.out.println("******* service 01");
		String str = null;
		str.toCharArray();
		
		System.out.println("over");
	}

}
