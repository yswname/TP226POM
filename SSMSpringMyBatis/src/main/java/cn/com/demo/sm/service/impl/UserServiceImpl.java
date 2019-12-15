package cn.com.demo.sm.service.impl;

import cn.com.demo.sm.entity.SpUser;
import cn.com.demo.sm.mapper.SpUserMapper;
import cn.com.demo.sm.service.IUserService;

public class UserServiceImpl implements IUserService {
    private SpUserMapper userMapper;
    
    
	@Override
	public void addUser(SpUser user) {
		this.userMapper.insert(user);
		//throw new RuntimeException("xx");
	}


	@Override
	public SpUser searchUserById(int urId) {
		return this.userMapper.selectByPrimaryKey(urId);
	}
	
	
	public void setUserMapper(SpUserMapper userMapper) {
		this.userMapper = userMapper;
	}

}
