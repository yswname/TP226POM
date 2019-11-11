package cn.com.demo.mvc.controller;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/req")
public class DemoTransRequestController {
	@RequestMapping("/test1")
    public void test1(@RequestParam Map<String,String> map) {
    	Set<Entry<String,String>> entrys = map.entrySet();
    	for(Entry<String,String> entry:entrys) {
    		System.out.println(entry.getKey() + "-->" + entry.getValue());
    	}
    }
	@RequestMapping("/test2/{age}/{name}")
	public void test2(@PathVariable("name") String name,@PathVariable("age") int age) {
		System.out.println(name + "," + age);
	}
	@RequestMapping("/test3/{cat}")
	public void test3(@PathVariable("cat")String cat,@MatrixVariable String name,@MatrixVariable String color) {
		System.out.println(cat + "," + name + "," + color);
	}
	@RequestMapping("/test4")
	public void test4(String[] likes, HttpSession session) {
		for(String str:likes) {
			System.out.print(str+",");
		}
		System.out.println();
		session.setAttribute("x", "x");
	}
	@RequestMapping("/test5")
	public void test5(@RequestHeader("Accept-Language") String header1,@CookieValue("JSESSIONID") String sessionId) {
		System.out.println(header1 + "," + sessionId);
		
	}
}
