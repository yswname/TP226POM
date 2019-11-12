package cn.com.demo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoUrlNameController {
	@RequestMapping("/test1")
    public void test1() {
    	System.out.println("test1");
    }
	@RequestMapping("/test2/*.do")
    public void test2() {
    	System.out.println("test2");
    }
	@RequestMapping(name="/test2/*",method= {RequestMethod.GET,RequestMethod.POST})
    public void test3() {
    	System.out.println("test3");
    }
	@RequestMapping(name="/test2/**",params= {"userName!=zhangsan"},consumes= {},produces= {},headers= {})
    public void test4() {
    	System.out.println("test4");
    }
	@RequestMapping("/test2/abc*")
    public void test5() {
    	System.out.println("test5");
    }
}
