package cn.com.demo.spring.service;

public class ServiceFactory {
    private static ServiceFactory factory = new ServiceFactory();
    private ServiceFactory() {}
    
    public static ServiceFactory getInstance() {
    	return factory;
    }
    
    public UserService createUserService() {
    	return new UserService();
    }
}
