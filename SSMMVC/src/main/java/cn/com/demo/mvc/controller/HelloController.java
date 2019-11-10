package cn.com.demo.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller // 是一个控制器类，SpringMVC自动扫描
@RequestMapping("/demo")
public class HelloController {
	@RequestMapping("/hello") // /demo/hello
    public ModelAndView hello() {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("abc");
    	mv.addObject("msg", "Hello World");
    	return mv;
    }
	
	public ModelAndView hello(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
    	mv.setViewName("abc");
    	mv.addObject("msg", "Hello World");
    	return mv;
	}
	// <input type='text' name='userName/age'// url?username=zhangsan&age=12
	public ModelAndView hello(@RequestParam(value="username") String userName, int age) {
		ModelAndView mv = new ModelAndView();
    	mv.setViewName("abc");
    	mv.addObject("msg", "Hello World");
    	return mv;
	}
	// restful   http://localhost:8080/shopping/demo/zhangsan/12
	@RequestMapping("/{userName}/{age}")
	public ModelAndView hello(@PathVariable("userName") String userName,@PathVariable("age") int age,int a) {
		ModelAndView mv = new ModelAndView();
    	mv.setViewName("abc");
    	mv.addObject("msg", "Hello World");
    	return mv;
	}
	// 
//	public ModelAndView hello(User user) {
//		ModelAndView mv = new ModelAndView();
//    	mv.setViewName("abc");
//    	mv.addObject("msg", "Hello World");
//    	return mv;
//	}
}
