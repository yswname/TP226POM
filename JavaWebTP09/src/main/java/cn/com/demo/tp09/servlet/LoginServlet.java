package cn.com.demo.tp09.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    String aliaName = request.getParameter("aliaName");
	    ServletContext application = request.getServletContext();
	    HttpSession session = request.getSession();
	    
	    Object obj = application.getAttribute("ALIANAME_SET");
	    if(obj == null){
	    	obj = new HashSet<String>();
	    	application.setAttribute("ALIANAME_SET", obj);
	    }
	    Set<String> aliaNameSet = (Set<String>)obj;
	    
	    boolean hasContains = aliaNameSet.contains(aliaName);
	    if(hasContains || aliaName == null){
	    	request.setAttribute("message","请选另外一个昵称进入聊天室");
	    	request.getRequestDispatcher("loginPage.jsp").forward(request,response);
	    }else{
	    	aliaNameSet.add(aliaName);
	    	session.setAttribute("CURR_ALIA_NAME", aliaName);
	    	session.setMaxInactiveInterval(60*1000*5);
	    	request.getRequestDispatcher("talkRoom.jsp").forward(request, response);
	    }
	}



}
