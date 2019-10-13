package cn.com.demo.tp04.service;

public class LoginService {
    public boolean verifyPassword(String userName,String password) {
    	boolean bool = false;
    	
    	// 根据用户名，从数据库中获取密码
    	String dbPassword = "123456";
    	bool = dbPassword.equals(password);
    	
    	return bool;
    }
}
