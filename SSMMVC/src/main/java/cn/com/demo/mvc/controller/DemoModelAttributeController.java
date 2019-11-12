package cn.com.demo.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/attr")
@SessionAttributes({"userName"})
public class DemoModelAttributeController {
	@RequestMapping("/test1")
    public String test1(@ModelAttribute("name") String name,String userName) {
		System.out.println(name);
		name="abc"+name;
    	return "test3";
    }
	@RequestMapping("/test2")
	@ModelAttribute("name")
	public String test2(String name) {
		System.out.println("2222222222222");
		return "test3";
	}
	
	public void loginOut(SessionStatus status) {
		status.setComplete();
		HttpSession session = null;
		session.invalidate();
	}
	
//	@ModelAttribute("userName")
//	public String test3(String name) {
//		System.out.println("aaaaaaaaaaaaaaa");
//		return "lisi";
//	}
}
