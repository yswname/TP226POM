<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Set" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="Refresh" content="2,userList.jsp">
</head>
<body>
   <%--
   1 获取所有的昵称
   2 循环显示
   3 用不同颜色，标记自己
    --%>
    在线用户：<br/>
    <%
       Set<String> aliaNameSet = (Set<String>)application.getAttribute("ALIANAME_SET");
       String currAliaName = (String)session.getAttribute("CURR_ALIA_NAME");
    if(aliaNameSet != null){
    	for(String aliaName:aliaNameSet){
    		if(aliaName != null){
    		if(aliaName.equals(currAliaName)){
    			 out.println("<font color='red'>" + aliaName + "</font><br/>");
    		}else{
    		     out.println(aliaName + "<br/>");
    		}
    		}
    	}
    }
    %>
</body>
</html>