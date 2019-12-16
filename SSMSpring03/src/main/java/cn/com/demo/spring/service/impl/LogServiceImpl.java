package cn.com.demo.spring.service.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import cn.com.demo.spring.service.ILogService;

@Service
@Aspect
public class LogServiceImpl implements ILogService {
	
	
	@Override
	@After("cn.com.demo.spring.service.pointcut.MyPointCut.verfiy(aUserName,aPassword)")
	public void testArgs3(String aUserName, String aPassword) {
		System.out.println("log...." + aUserName + "," + aPassword);
	}

	@Override
	public void testArgs2(String aUserName, String aPassword, int aAge) {
		System.out.println("log...." + aUserName + "," + aPassword+"," + aAge);
	}

	@Override
	public void testArgs(JoinPoint jp) {
		Object[] args = jp.getArgs();// 目标的参数
		Object target = jp.getTarget();// 目标对象
		String name = jp.getSignature().getName();
		System.out.println(target + "," +name);
		if(args != null) {
			for(Object arg:args)
			System.out.print(arg+",");
		}
		System.out.println();
	}

	//@Before("cn.com.demo.spring.service.pointcut.MyPointCut.pointcut1()")
	@Override
	public void log01() {
		System.out.println("log01 ....");
	}

	@Override
	public void after() {
		System.out.println("after ....");
	}

	@Override
	public void afterReturn() {
		System.out.println("afterReturn ....");
	}

	@Override
	public void exception() {
		System.out.println("exception ....");
	}

	@Override
	public void around(ProceedingJoinPoint pjp) {
		System.out.println("around ....  begin");
		try {
			// 传递调用
			Object obj = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("around ....  end");
	}

}
