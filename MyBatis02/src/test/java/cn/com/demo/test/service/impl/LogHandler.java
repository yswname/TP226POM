package cn.com.demo.test.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import cn.com.demo.test.service.ILogService;

public class LogHandler implements InvocationHandler {
	private Object target;
    private ILogService logService;
    public LogHandler(ILogService log,Object target) {
    	this.logService = log;
    	this.target = target;
    }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object obj = null;
		
		this.logService.log();
		// 当前嗲用的目标方法
		obj = method.invoke(target, args);
		return obj;
	}

}
