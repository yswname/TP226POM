package cn.com.demo.service.impl;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.com.demo.mybatis.entity.SpIdCard;
import cn.com.demo.mybatis.entity.SpUser;
import cn.com.demo.service.IUserService;

public class TestUserServiceImpl {
    private IUserService userService = null;
    
    @Before
    public void init() {
    	this.userService = new UserServiceImpl();
    }
    @Test
    public void testSave() {
    	SpUser user = null;
    	SpIdCard card = null;
    	for(int i=1;i<10;i++) {
    		// 当前对象
    		user = new SpUser();
    		user.setUrPassword("123");
    		user.setUrUserName("t"+i);
    		// 关联对象
    		card = new SpIdCard();
    		card.setIcCode("code"+i);
    		card.setIcName("name"+i);
    		// 设置对象的相互关系
    		card.setUser(user);
    		user.setIdCard(card);
    		
    		this.userService.addUser(user);
    	}
    }
    @Test
    public void testSearchUsersByPage() {
    	List<SpUser> userList = this.userService.searchUsersByPage(2, 3);
    	for(SpUser user:userList) {
    		System.out.println(user);
    	}
    }
    
    @After
    public void end() {
    	this.userService = null;
    }
}
