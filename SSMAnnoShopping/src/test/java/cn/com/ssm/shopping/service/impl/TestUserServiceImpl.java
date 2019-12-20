package cn.com.ssm.shopping.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.ssm.shopping.config.SpringConfig;
import cn.com.ssm.shopping.entity.SpUser;
import cn.com.ssm.shopping.service.IUserService;
import junit.framework.Assert;

public class TestUserServiceImpl {
	
    private IUserService userService;
    @Before
    public void init() {
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
    	this.userService = ctx.getBean(IUserService.class);
    }
    @Test
    public void testSearchUser() {
    	SpUser user = this.userService.searchUser("mybatis01");
    	System.out.println(user);
    	Assert.assertNotNull(user);
    }
}
