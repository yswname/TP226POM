package cn.com.demo.spring.service.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MyPointCut {
	@Pointcut("execution(* cn.com.demo.spring.service..*.*(..))")
    public void pointcut1() {}
	
	@Pointcut("execution(* cn.com.demo.spring.service.impl.*.verify(..)) && args(userName,password)")
	public void verfiy(String userName, String password) {}
}
