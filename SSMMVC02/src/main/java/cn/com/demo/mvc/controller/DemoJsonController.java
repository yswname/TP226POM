package cn.com.demo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.demo.mvc.entity.User;
@Controller
@RequestMapping("/json")
public class DemoJsonController {
	@RequestMapping("/json")
	@ResponseBody
	public User test5(@RequestBody User user) {
		System.out.println(user);
		user.setSex("sex"+user.getUrId());
		return user;
	}
}
