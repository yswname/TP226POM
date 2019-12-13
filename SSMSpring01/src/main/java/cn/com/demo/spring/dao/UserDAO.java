package cn.com.demo.spring.dao;

import cn.com.demo.spring.entity.User;

public class UserDAO {
	private String test;
	public UserDAO() {
		System.out.println("create");
	}
	public UserDAO(String t) {
		this.test = t;
	}
	
	public UserDAO(String t,int a) {
		this.test = t;
	}
	
	public UserDAO(String t,User a) {
		this.test = t;
	}
	public String getTest() {
		return this.test;
	}
    public User findById(int id) {
    	return new User();
    }
    
    public void init() {
    	System.out.println("init");
    }
    
    public void after() {
    	System.out.println("xxxxx");
    }
}
