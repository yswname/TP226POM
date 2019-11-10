package cn.com.demo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
