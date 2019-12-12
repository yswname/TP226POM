package cn.com.demo.ms.shopping.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
	@RequestMapping("/test01.mvc")
    public String test01() {
    	return "demo";
    }
}
