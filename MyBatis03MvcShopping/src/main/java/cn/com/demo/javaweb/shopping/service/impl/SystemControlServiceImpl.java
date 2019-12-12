package cn.com.demo.javaweb.shopping.service.impl;

import cn.com.demo.javaweb.shopping.entity.SpUser;
import cn.com.demo.javaweb.shopping.service.ISystemControlService;
import cn.com.demo.javaweb.shopping.service.IUserService;

public class SystemControlServiceImpl implements ISystemControlService {
    private IUserService userSerivce = new UserServiceImpl();
	@Override
	public SpUser verify(String userName, String password) {
		SpUser user = null;
		
		user = this.userSerivce.searchUser(userName);
		if(user == null) {
			throw new RuntimeException(userName +" 不存在");
		}else {
			if(!user.getUrPassword().equals(password)) {
				throw new RuntimeException("用户名和密码不匹配");
			}
		}
		
		return user;
	}

}
