package cn.com.demo.javaweb.shopping.service.impl;

import cn.com.demo.javaweb.shopping.dao.ISpUserDAO;
import cn.com.demo.javaweb.shopping.dao.impl.SpUserDAOImpl;
import cn.com.demo.javaweb.shopping.entity.SpUser;
import cn.com.demo.javaweb.shopping.service.IUserService;

public class UserServiceImpl implements IUserService {
    private ISpUserDAO userDAO = new SpUserDAOImpl();
	@Override
	public SpUser searchUser(String userName) {
		SpUser user = null;
		
		user = this.userDAO.findByUserName(userName);
		
		return user;
	}

}
