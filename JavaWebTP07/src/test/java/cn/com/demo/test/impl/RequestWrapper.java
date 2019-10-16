package cn.com.demo.test.impl;

import cn.com.demo.test.IRequest;

public class RequestWrapper implements IRequest {
	private IRequest request;
    public RequestWrapper(IRequest request) {
    	this.request = request;
    }
	@Override
	public String getParameter(String name) {
		return "123" + this.request.getParameter(name);
	}

}
