<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, java.util.ArrayList" %>
<%@page import="cn.com.demo.tp09.bean.TalkMessage" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="message.jsp" method="post">
    输入消息<textarea rows="3" cols="30" name="msg"></textarea>
    <input type='submit' value='发送消息'>
    </form>
    
    <%--
    1 接收消息
    2 封装成Message对象
    3 添加到application消息List中
     --%>
     <%
        request.setCharacterEncoding("UTF-8");
        String msg = request.getParameter("msg");
        if(msg != null){
        String currAliaName = (String)session.getAttribute("CURR_ALIA_NAME");
        TalkMessage message = new TalkMessage(currAliaName, msg);
        
        List<TalkMessage> messageList = (List<TalkMessage>)application.getAttribute("MSG_LIST");
        if(messageList == null){
        	messageList = new ArrayList<TalkMessage>();
        	application.setAttribute("MSG_LIST", messageList);
        }
        
        messageList.add(message);
        }
     %>
</body>
</html>