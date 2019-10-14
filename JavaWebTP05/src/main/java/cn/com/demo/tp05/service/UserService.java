package cn.com.demo.tp05.service;

import java.util.List;

import cn.com.demo.tp05.dao.UserDAO;
import cn.com.demo.tp05.entity.UserEntity;

/**
 * 用户相关得业务逻辑
 * */
public class UserService {
	private UserDAO userDAO = new  UserDAO();
    public void registerUser(UserEntity user) {
    	userDAO.addUser(user);
    }
    
    public boolean verifyUser(String userName,String password) {
    	boolean bool = false;
    	UserEntity user = this.userDAO.findByUserName(userName);
    	if(user == null) {
    		throw new RuntimeException(userName + "不能存在");
    	}
    	bool = user.getUrPassword().equals(password);
    	return bool;
    }
    
    public List<UserEntity> search(){
    	List<UserEntity> userList = null;
    	userList = this.userDAO.findAll();
    	return userList;
    }
}
