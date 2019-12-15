package cn.com.demo.spring.service.proxy;

import org.springframework.cglib.proxy.Enhancer;

import cn.com.demo.spring.service.ILogService;
import cn.com.demo.spring.service.impl.LogServiceImpl;

public class CglibDynProxyFactory {
	private Object target;
	public CglibDynProxyFactory(Object target) {
		this.target = target;
	}
	
	public Object createProxyObject() {
		Object obj = null;
		
		// LogService
		ILogService log = new LogServiceImpl();
		MyMethodInterceptor inter = new MyMethodInterceptor(log);
		
		Enhancer en = new Enhancer();
		en.setSuperclass(target.getClass());
		en.setCallback(inter);
		
		obj = en.create();
		
		return obj;
	}

}
