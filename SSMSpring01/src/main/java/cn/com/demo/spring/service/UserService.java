package cn.com.demo.spring.service;

import cn.com.demo.spring.dao.UserDAO;

public class UserService {
	private UserDAO userDAO;
	public UserService() {}
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
    public boolean verify(String userName,String password) {
    	userDAO.findById(2);
    	return true;
    }
	public void setUserDAO(UserDAO userDAO) {
		System.out.println("setUserDAO");
		this.userDAO = userDAO;
	}

}
