package cn.com.demo.javaweb.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.com.demo.javaweb.shopping.entity.SpUser;
import cn.com.demo.javaweb.shopping.service.ISystemControlService;
import cn.com.demo.javaweb.shopping.service.impl.SystemControlServiceImpl;

@Controller
@SessionAttributes("LOGIN_USER")
public class LoginController {
	@RequestMapping(value = "/login")
	public String loginPage() {
		System.out.println("**********");
		return "myLogin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String userName, String password, Model model) {
		String result = "myLogin";
System.out.println("AAAAAAAAAA");
		// 创建service
		ISystemControlService controlService = new SystemControlServiceImpl();
		try {
			// 调用
			SpUser user = controlService.verify(userName, password);
			// 根据结果，决定result
			if(user == null) {
				model.addAttribute("errorMsg", "登录失败：" + userName+ " 不存在");
			}else {
				if(user.getUrPassword().equals(password)) {
					model.addAttribute("LOGIN_USER", user);
					model.addAttribute("userName",userName);
					result = "welcome";
				}else {
					model.addAttribute("errorMsg", "登录失败：密码不匹配");
				}
			}
		} catch (Exception e) {
			model.addAttribute("errorMsg", "登录失败：" + e.getMessage());
		}

		return result;
	}
}
