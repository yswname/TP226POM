<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%--包含 动态包含--%>
   <jsp:include page="header.jsp"></jsp:include>
   <jsp:include page="demoServlet"></jsp:include>
   !!!!!!!!!!!!!!!!!body!!!!!!!!!!!!!!!!!!!!!
   
   <br/>
   <%int i = 1; %>
   <%=i %>
   <%--静态包含 --%>
   <%@include file="footer.jsp" %>
   <%-- 
   <%@include file="demoServlet" %>
   
   
   <jsp:forward page="demoServlet"></jsp:forward>
   
   <c:redirect url="demoServlet"></c:redirect>
   --%>
   <%
   //response.sendRedirect(location);
   %>
</body>
</html>