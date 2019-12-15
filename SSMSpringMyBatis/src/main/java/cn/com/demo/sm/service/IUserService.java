package cn.com.demo.sm.service;

import cn.com.demo.sm.entity.SpUser;

public interface IUserService {
    public SpUser searchUserById(int urId);
    public void addUser(SpUser user);
}
