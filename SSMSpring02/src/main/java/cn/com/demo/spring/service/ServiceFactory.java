package cn.com.demo.spring.service;

import cn.com.demo.spring.service.impl.UserServiceImpl;
import cn.com.demo.spring.service.proxy.CglibDynProxyFactory;

public class ServiceFactory {
    public static UserServiceImpl createUserService() {
    	UserServiceImpl target =  new UserServiceImpl();
    	CglibDynProxyFactory factory = new CglibDynProxyFactory(target);
    	return (UserServiceImpl)factory.createProxyObject();
    }
}
