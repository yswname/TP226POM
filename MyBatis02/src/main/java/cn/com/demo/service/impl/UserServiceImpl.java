package cn.com.demo.service.impl;

import java.util.List;

import cn.com.demo.mybatis.dao.ISpIdCardDAO;
import cn.com.demo.mybatis.dao.ISpUserDAO;
import cn.com.demo.mybatis.dao.impl.SpIdCardDAOImpl;
import cn.com.demo.mybatis.dao.impl.SpUserDAOImpl;
import cn.com.demo.mybatis.entity.SpUser;
import cn.com.demo.service.IUserService;

public class UserServiceImpl implements IUserService {
    private ISpUserDAO userDAO = new SpUserDAOImpl();
    private ISpIdCardDAO idCardDAO = new SpIdCardDAOImpl();
	@Override
	public void addUser(SpUser user) {
		if(user == null) {
			throw new RuntimeException("用户不能为null");
		}else {
			this.userDAO.add(user);
			if(user.getIdCard() != null) {
				System.out.println(user.getUrId());
				user.getIdCard().setIcId(user.getUrId());
				this.idCardDAO.add(user.getIdCard());
			}
		}
	}

	@Override
	public List<SpUser> searchUsersByPage(int pageNo, int pageCount) {
		List<SpUser> userList = null;
		
		int start = (pageNo -1)*pageCount;
		userList = this.userDAO.findAllByPaging(start, pageCount);
		
		return userList;
	}

}
