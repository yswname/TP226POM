package cn.com.demo.spring.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public interface ILogService {
    public void log01();
    public void after();
    public void afterReturn();
    public void exception();
    public void around(ProceedingJoinPoint pjp);
    
    public void testArgs(JoinPoint jp);
    public void testArgs2(String aUserName,String aPassword, int aAge);
    public void testArgs3(String aUserName,String aPassword);
}
