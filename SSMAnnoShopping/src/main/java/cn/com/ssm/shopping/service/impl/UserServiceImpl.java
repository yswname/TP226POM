package cn.com.ssm.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ssm.shopping.entity.SpUser;
import cn.com.ssm.shopping.mapper.SpUserMapper;
import cn.com.ssm.shopping.service.IUserService;
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
    private SpUserMapper userDAO;// = new SpUserDAOImpl();
	@Override
	public SpUser searchUser(String userName) {
		SpUser user = null;
		
		user = this.userDAO.findByUserName(userName);
		
		return user;
	}

}
