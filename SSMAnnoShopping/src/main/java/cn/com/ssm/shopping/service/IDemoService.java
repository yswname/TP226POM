package cn.com.ssm.shopping.service;

import java.util.List;

import cn.com.ssm.shopping.entity.SpUser;

public interface IDemoService {
    List<SpUser> searchAllUsers(); 
    void registerUser(SpUser user);
    SpUser findById(int urId);
}
