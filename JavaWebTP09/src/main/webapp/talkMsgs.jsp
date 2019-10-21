<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, cn.com.demo.tp09.bean.TalkMessage" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="Refresh" content="2,talkMsgs.jsp">
</head>
<body>
    <%
      List<TalkMessage> msgList = (List<TalkMessage>)application.getAttribute("MSG_LIST");
      if(msgList != null){
    	  for(TalkMessage msg:msgList){
    		  out.println(msg + "<br/>");
    	  }
      }
    %>
</body>
</html>