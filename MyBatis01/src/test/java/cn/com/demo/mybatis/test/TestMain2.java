package cn.com.demo.mybatis.test;

import cn.com.demo.mybatis.entity.SpUser;

public class TestMain2 {

	public static void main(String[] args) {
		SpUser user = new SpUser();
		user.setUrUserName("ttttt");
		
		ThreadLocal<SpUser> tl = new ThreadLocal<SpUser>();
		// 主线程设置
		tl.set(user);
		
		new Thread() {
			public void run() {
				SpUser uu = new SpUser();
				uu.setUrUserName("aaaaaaa");
				tl.set(uu);
				SpUser u2 = tl.get();
				System.out.println("!!!!!!!!!!!" + u2);
			}
		}.start();
		
		// 主线程获取打印
		SpUser u = tl.get();
		System.out.println("*************"+u);
	}

}
