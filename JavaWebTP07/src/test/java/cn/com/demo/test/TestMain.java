package cn.com.demo.test;

import cn.com.demo.test.impl.RequestImpl;
import cn.com.demo.test.impl.RequestWrapper;

public class TestMain {

	public static void main(String[] args) {
		// ServletRequest
		IRequest request = new RequestImpl();
		
		request = new RequestWrapper(request);

		// chain.doFilter
		test(request);
	}
	// service方法
	public static void test(IRequest request) {
		System.out.println(request.getParameter("zhangsan"));
	}

}
