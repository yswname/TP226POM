package cn.com.demo.tp05.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.demo.tp05.entity.UserEntity;
import cn.com.demo.tp05.service.UserService;

/**
 * Servlet implementation class EditPageServlet
 * 修改用户信息页面
 */
public class EditPageServlet extends ControllerServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String urIdStr = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(urIdStr);
		}catch(Exception e) {
			
		}
		UserEntity user = new UserService().searchUserById(id);
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<meta charset=\"utf-8\">\r\n" + 
				"		<title></title>\r\n" + 
				"		<script type=\"text/javascript\">\r\n" + 
				"			function toUserList(){\r\n" + 
				"				location.href=\"userListServlet?\"+Math.random();\r\n" + 
				"			}\r\n" + 
				"		</script>\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"		<form action=\"editServlet\" method=\"post\">\r\n" + 
				"			UserName:<input type=\"text\" name=\"userName\" value=\""+user.getUrUserName()+"\" readonly='readonly'/><br/>\r\n" + 
				"			Password:<input type=\"password\" name=\"password\" value=\""+user.getUrPassword()+"\"/><br/>\r\n" + 
				"			Age:<input type=\"text\" name=\"age\"  value=\""+user.getUrAge()+"\"/><br/>\r\n" + 
				"			Phone:<input type=\"text\" name=\"phone\" value=\""+user.getUrPhone()+"\"/><br/>\r\n");
		if("男".equals(user.getUrSex())) {
		out.println(		"			<input type=\"radio\" value=\"男\" name=\"sex\" checked='checked'/>男\r\n" + 
				"			<input type=\"radio\" value=\"女\" name=\"sex\" />女<br/>\r\n");
		}else {
			out.println(		"			<input type=\"radio\" value=\"男\" name=\"sex\"/>男\r\n" + 
					"			<input type=\"radio\" value=\"女\" name=\"sex\"  checked='checked'/>女<br/>\r\n");
		}
		
		out.println("<input type='hidden' name='id' value='"+user.getUrId()+"'/>");
		
		out.println(		"			<input type=\"submit\" value=\"更新\" />\r\n" + 
				"			<input type=\"button\" value=\"返回用户列表\" onclick=\"toUserList()\"/>\r\n" + 
				"		</form>");
		String message = (String)request.getAttribute("message");
		if(message != null) {
		out.println("		<script type=\"text/javascript\">\r\n" + 
				"			alert(\""+message+"\");\r\n" + 
				"		</script>");
		}
		out.println("	</body>\r\n" + 
				"</html>");
	}

}
