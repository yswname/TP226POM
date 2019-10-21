<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
       request.setAttribute("REQ","2222222222222");
       out.println("Hello How are !");
       pageContext.setAttribute("DATA", "11111111111");
       
       String str = null;
       str.toString();
   %>
   
   <jsp:include page="page.jsp"></jsp:include>
   <br/>-------------------------<br/>
   <%@include file="page.jsp" %>
  
  <%-- 
   <%!
       void test(){
	      out.println("111");
       }
   %>
   --%> 
</body>
</html>