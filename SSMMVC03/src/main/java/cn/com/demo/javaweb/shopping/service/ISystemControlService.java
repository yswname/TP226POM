package cn.com.demo.javaweb.shopping.service;

import cn.com.demo.javaweb.shopping.entity.SpUser;

public interface ISystemControlService {
	// 返回null或throw异常，表示验证失败
    public SpUser verify(String userName, String password);
}
