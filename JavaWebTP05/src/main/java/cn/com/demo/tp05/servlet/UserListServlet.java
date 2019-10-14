package cn.com.demo.tp05.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.demo.tp05.entity.UserEntity;
import cn.com.demo.tp05.service.UserService;

/**
 * Servlet implementation class UserListServlet
 * 显示所有得用户列表
 */
public class UserListServlet extends ControllerServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<meta charset=\"utf-8\">\r\n" + 
				"		<title></title>\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"		<table>\r\n" + 
				"			<thead>\r\n" + 
				"				<th>\r\n" + 
				"					<td>\r\n" + 
				"						序号\r\n" + 
				"					</td>\r\n" + 
				"					<td>\r\n" + 
				"						用户名\r\n" + 
				"					</td>\r\n" + 
				"					<td>\r\n" + 
				"						性别\r\n" + 
				"					</td>\r\n" + 
				"					<td>\r\n" + 
				"						电话\r\n" + 
				"					</td>\r\n" + 
				"					<td>\r\n" + 
				"						年龄\r\n" + 
				"					</td>\r\n" + 
				"				</th>\r\n" + 
				"			</thead>\r\n" + 
				"			<tbody>");
		
		UserService userService = new UserService();
		List<UserEntity> userList = userService.search();
		UserEntity user = null;
		for(int i=0;i<userList.size();i++) {
			user = userList.get(i);

		out.println("				<tr>\r\n" + 
				"					<td>\r\n" + 
				"						"+(i+1)+"\r\n" + 
				"					</td>\r\n" + 
				"					<td>\r\n" + 
				"						<a href='editPageServlet?id="+user.getUrId()+"'>"+user.getUrUserName()+"</a>\r\n" + 
				"					</td>\r\n" + 
				"					<td>\r\n" + 
				"						"+user.getUrSex()+"\r\n" + 
				"					</td>\r\n" + 
				"					<td>\r\n" + 
				"						"+user.getUrPhone()+"\r\n" + 
				"					</td>\r\n" + 
				"					<td>\r\n" + 
				"						"+user.getUrAge()+"\r\n" + 
				"					</td>\r\n" + 
				"				</tr>");
		
		}
		
		out.println("			</tbody>\r\n" + 
				"		</table>\r\n" + 
				"	</body>\r\n" + 
				"</html>");
	}

}
