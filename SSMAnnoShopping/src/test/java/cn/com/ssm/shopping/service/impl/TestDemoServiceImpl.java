package cn.com.ssm.shopping.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.ssm.shopping.config.SpringConfig;
import cn.com.ssm.shopping.entity.SpUser;
import cn.com.ssm.shopping.service.IDemoService;
import junit.framework.Assert;

public class TestDemoServiceImpl {
	private IDemoService demoService;

	@Before
	public void init() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		demoService = ctx.getBean(IDemoService.class);
	}

	@Test
	public void testFindById() {
		// 1 准备测试输入数据 1
		// 2 预估期望值 userName=zhangsan01 and password=11
		// 3 执行测试方法，得到实际值
		// 4 断言实际值等于期望值
		int urId = 1;
		String expUserName = "zhangsan01";
		String expPassword = "11";
		SpUser user = demoService.findById(urId);
		Assert.assertEquals(expUserName, user.getUrUserName());
		Assert.assertEquals(expPassword, user.getUrPassword());
	}
    @Test
	public void testRegisterUser() {
        SpUser user = new SpUser();
        user.setUrPassword("11");
        user.setUrUserName("ssm02");
        
        this.demoService.registerUser(user);
	}

}
