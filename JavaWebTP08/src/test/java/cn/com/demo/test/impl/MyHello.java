package cn.com.demo.test.impl;

import cn.com.demo.test.IHello;

public class MyHello implements IHello {

	@Override
	public void hello() {
		System.out.println("Hello ,how are you!");
	}

}
