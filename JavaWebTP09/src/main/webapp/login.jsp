<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.HashSet" %>
<%@page import="java.util.Set" %>
<%-- 
   1 获取request中aliaName
   2 判断是否有重名
     如果有：--》转向loginPage.jsp,提示重名
     如果没有：-》显示聊天室页面 talkRoom.jsp
                          保存aliaName---》application
                          set集合
                                      》session（String）
--%>

<%
    request.setCharacterEncoding("UTF-8");
    String aliaName = request.getParameter("aliaName");
    
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
%>