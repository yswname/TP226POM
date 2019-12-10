package cn.com.demo.test.service;

import java.util.ArrayList;
import java.util.List;

import cn.com.demo.test.service.impl.LogServiceImpl;
import cn.com.demo.test.service.impl.UserServiceImpl;

public class ServiceFactory {
	public static List createList() {
		List list = new ArrayList();
		return (List)DynProxyFactory.createProxy(list);
	}
    public static IUserService createUserService() {
    	//return new UserServiceImpl();
    	IUserService userService = new UserServiceImpl();
//    	ILogService log = new LogServiceImpl();
//    	return new UserServiceImplProxy(log, userService);
    	
    	return (IUserService)DynProxyFactory.createProxy(userService);
    }
    
    public static ILogService createLogService() {
    	return new LogServiceImpl();
    }
}
