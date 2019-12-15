package cn.com.demo.spring.service.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import cn.com.demo.spring.service.ILogService;

public class MyMethodInterceptor implements MethodInterceptor {
    private ILogService logService;
    public MyMethodInterceptor(ILogService log) {
    	this.logService = log;
    }
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		Object result = null;
		logService.log01();
		// 调用目标的方法
		result = arg3.invokeSuper(arg0, arg2);
		return result;
	}

}
