package cn.com.demo.service;

import java.util.List;

import cn.com.demo.mybatis.entity.SpUser;

public interface IUserService {
	default void addUser(SpUser user) {
	};

	default List<SpUser> searchUsersByPage(int pageNo, int pageCount) {
		return null;
	}
	
	default List<SpUser> searchUsersByPage(int id,String userName, int pageNo, int pageCount){
		return null;
	}
}
