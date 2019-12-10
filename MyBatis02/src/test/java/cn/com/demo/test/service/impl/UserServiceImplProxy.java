package cn.com.demo.test.service.impl;

import cn.com.demo.test.service.ILogService;
import cn.com.demo.test.service.IUserService;
/**
 * 静态代理
 * */
public class UserServiceImplProxy implements IUserService {
    private ILogService logService;
    private IUserService userService;
    public UserServiceImplProxy(ILogService log, IUserService userService) {
    	this.logService = log;
    	this.userService = userService;
    }
	@Override
	public void userService() {
		this.logService.log();
		this.userService.userService();
	}

}
