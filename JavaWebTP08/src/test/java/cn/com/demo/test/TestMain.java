package cn.com.demo.test;

import java.util.ServiceLoader;

import javax.servlet.ServletContainerInitializer;

public class TestMain {

	public static void main(String[] args) {
		// 获取到IHello的实现类对象 SPI
		ServletContainerInitializer test;

		ServiceLoader<IHello> hellos = ServiceLoader.load(IHello.class);
		for(IHello h:hellos) {
			System.out.println(h);
			h.hello();
		}
		//IHello hello = null;
		// 调用hello方法
		//hello.hello();
	}

}
