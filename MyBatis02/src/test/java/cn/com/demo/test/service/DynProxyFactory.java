package cn.com.demo.test.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import cn.com.demo.test.service.impl.LogHandler;
import cn.com.demo.test.service.impl.LogServiceImpl;

// 创建指定对象的代理对象
public class DynProxyFactory {
	public static Object createProxy(Object target) {
		Object obj = null;
		
		ILogService logService = new LogServiceImpl();
		Class[] inters = target.getClass().getInterfaces();
		InvocationHandler h = new LogHandler(logService, target);
		obj = Proxy.newProxyInstance(DynProxyFactory.class.getClassLoader(), inters, h);
		
		return obj;
	}

}
