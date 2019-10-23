<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://javaweb/tp226/myTags" prefix="my"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
      java.util.Date date = new java.util.Date();
      session.setAttribute("myDate", date);
   %>
   !!!!!!!!!!!<br/>
   <my:hello color="green" date="${myDate }" age="30"/>
   <br/>
   <my:hello color="green" date="${myDate }" age="30"/>
   <br/>
   ********************<br/>
   <my:hello color="red" date="${myDate }"/><br/>
    <my:hello color="red" date="${myDate }"/><br/>
    <my:hello color="red" date="${myDate }"/><br/>
    <my:hello color="red" date="${myDate }"/>
    <br/>
    
    <my:bodytag1 begin="10">
        日期<f:formatDate value="${myDate }" pattern="yyyy-MM-dd hh:mm:ss"/><br/>
     </my:bodytag1>
</body>
</html>