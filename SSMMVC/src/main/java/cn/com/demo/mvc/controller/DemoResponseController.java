package cn.com.demo.mvc.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.mvc.entity.User;

@Controller
@RequestMapping("/res")
@SessionAttributes("userName")
public class DemoResponseController {
	@RequestMapping("/test1")
    public void test1(HttpServletResponse res) {
    	
    }
	
	public ModelAndView test2() {
		ModelAndView mv = new ModelAndView("test2");// viewName
		mv.addObject("name", "zhangsan");
		return mv;
	}
	@RequestMapping("/test3")
	public String test3(Model model) {
		model.addAttribute("userName", "张三");
		return "test3";// viewName
	}
	@RequestMapping("/test4")
	public void test4(Model model) {
		model.addAttribute("userName", "张三");
	}
	@RequestMapping("/test5")
	@ResponseBody
	public String test4() {
		return "Hello how are you";
	}
	@RequestMapping("/test6")
	@ResponseBody
	public User test5(@RequestBody User user,HttpSession session) {
		System.out.println(user);
		user.setSex("sex"+user.getUrId());
		return user;
	}
}
