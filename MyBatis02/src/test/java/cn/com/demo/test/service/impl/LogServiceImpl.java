package cn.com.demo.test.service.impl;

import cn.com.demo.test.service.ILogService;

public class LogServiceImpl implements ILogService {

	@Override
	public void log() {
		System.out.println("**********log***********");
	}

}
