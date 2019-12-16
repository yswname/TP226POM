package cn.com.demo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/session")
@SessionAttributes("userName")
public class DemoSessionController {
	@RequestMapping("/setValue")
    public String setSession(Model mode) {
    	mode.addAttribute("userName", "zhangsan");
    	return "ok";
    }
	@RequestMapping("/getValue")
	public String getSession(@SessionAttribute("userName") String userName, Model model) {
		model.addAttribute("myUserName", userName);
		return "showSession";
	}
}
