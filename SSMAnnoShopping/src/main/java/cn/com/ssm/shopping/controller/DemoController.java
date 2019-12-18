package cn.com.ssm.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.ssm.shopping.entity.SpUser;
import cn.com.ssm.shopping.service.IDemoService;

@Controller
@RequestMapping("/demo")
public class DemoController {
	@Autowired
	private IDemoService demoService;
    @RequestMapping(value="/register.mvc", method=RequestMethod.GET)
	public String regPage() {
		return "register";
	}
    @RequestMapping(value="/register.mvc", method=RequestMethod.POST)
	public String register(SpUser user) {
		String result = null;
		try {
			demoService.registerUser(user);
			result = "forward:/demo/searchUsers.mvc";
		} catch (Exception e) {
			e.printStackTrace();
			result = "redirect:/demo/register.mvc";
		}
		return result;
	}
    @RequestMapping("/searchUsers.mvc")
    public String searchUserList(Model model) {
    	List<SpUser> userList = this.demoService.searchAllUsers();
    	model.addAttribute("userList", userList);
    	return "userList";
    }
}
