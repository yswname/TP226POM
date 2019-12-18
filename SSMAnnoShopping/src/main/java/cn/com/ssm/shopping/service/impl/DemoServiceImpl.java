package cn.com.ssm.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ssm.shopping.entity.SpUser;
import cn.com.ssm.shopping.mapper.SpUserMapper;
import cn.com.ssm.shopping.service.IDemoService;
@Service
@Transactional
public class DemoServiceImpl implements IDemoService {
	@Autowired
    private SpUserMapper userMapper;
	@Override
	public List<SpUser> searchAllUsers() {
		return this.userMapper.findAllUsers();
	}

	@Override
	public SpUser findById(int urId) {
		return this.userMapper.selectByPrimaryKey(urId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void registerUser(SpUser user) {
		this.userMapper.insert(user);
		String str = null;
		//str.toCharArray();
	}

}
