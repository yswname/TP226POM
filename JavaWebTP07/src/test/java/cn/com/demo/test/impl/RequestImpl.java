package cn.com.demo.test.impl;

import cn.com.demo.test.IRequest;

public class RequestImpl implements IRequest {

	@Override
	public String getParameter(String name) {
		return name+"abc";// 123nameabc
	}

}
