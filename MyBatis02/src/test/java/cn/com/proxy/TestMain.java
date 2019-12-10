package cn.com.proxy;

import java.util.List;

import cn.com.demo.test.service.IUserService;
import cn.com.demo.test.service.ServiceFactory;

public class TestMain {

	public static void main(String[] args) {
		IUserService userService = ServiceFactory.createUserService();
		//userService.userService();
		
		List list = ServiceFactory.createList();
		list.add(1);
		
		list.get(0);
	}

}
