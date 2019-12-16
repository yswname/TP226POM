package cn.com.demo.spring.service;

public interface IUserService {
    public void service01();
    public boolean verify(String userName, String password, int age);
    public boolean verify(String userName, String password);
}
