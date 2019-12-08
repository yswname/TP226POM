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
    /**
     * 同时考虑持久化关系对象
     * */
	@Override
	public void addUser(SpUser user) {
		if(user == null) {
			throw new RuntimeException("用户不能为null");
		}else {
			// 持久化用户对象
			this.userDAO.add(user);
			if(user.getIdCard() != null) {
				//System.out.println(user.getUrId());
				user.getIdCard().setIcId(user.getUrId());
				// 持久化关联的身份证对象
				this.idCardDAO.add(user.getIdCard());
			}
		}
	}

	@Override
	public List<SpUser> searchUsersByPage(int pageNo, int pageCount) {
		List<SpUser> userList = null;
		// 数据库中的记录，从0开始
		int start = (pageNo -1)*pageCount;
		userList = this.userDAO.findAllByPaging(start, pageCount);
		
		return userList;
	}

	@Override
	public List<SpUser> searchUsersByPage(int id, String userName, int pageNo, int pageCount) {
		List<SpUser> userList = null;
		// 数据库中的记录，从0开始
		int start = (pageNo -1)*pageCount;
		userList = this.userDAO.findByPaging(id,userName,start, pageCount);
		
		return userList;
	}

}
