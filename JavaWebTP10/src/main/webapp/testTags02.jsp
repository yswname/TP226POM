<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<f:setBundle basename="test"/>
</head>
<body>
<%--
   <c:import url="http://www.baidu.com"></c:import>
   
   <c:redirect url="http://www.baidu.com"></c:redirect>
   <c:remove var="age"/>
   <c:set var="age" value="10"></c:set>
    --%>
   <c:url value="http://www.baidu.com" var="test" ></c:url>
   xxx:${test }
   
   <% 
    java.util.Date date = new java.util.Date();
    pageContext.setAttribute("date",date);
   %>

   <f:formatDate value="${date }" pattern="yyyy-MM-dd hh:mm:ss"/>

   <f:message key="hello"></f:message>
   <input type='button' value='<f:message key="testbtn"></f:message>'/>
   
</body>
</html>