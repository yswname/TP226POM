package cn.com.demo.tp04.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.demo.tp04.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        System.out.println("*************create LoginSErvlet");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// super.service(request, response);
		// 获取数据
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// 处理
		LoginService service = new LoginService();
		boolean bool = service.verifyPassword(userName, password);
		// 生成，并且返回响应
		String resContent = "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n";
		if(bool) {		
                resContent+=userName +" 你好，恭喜登录成果";
		}else {
			    resContent += " 登录失败，请重试";
		}
		
		resContent+="</body>\r\n" + 
				"</html>";
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(resContent);
        out.flush();
        out.close();
	}


}
