package cn.com.ssm.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ssm.shopping.entity.SpUser;
import cn.com.ssm.shopping.service.ISystemControlService;
import cn.com.ssm.shopping.service.IUserService;
@Service
@Transactional
public class SystemControlServiceImpl implements ISystemControlService {
	@Autowired
    private IUserService userSerivce;// = new UserServiceImpl();
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
