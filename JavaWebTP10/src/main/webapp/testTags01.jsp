<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <c:set var="age" value="20" scope="request"></c:set><br/>
  <c:out value="30"></c:out><c:out value="zhangsan"></c:out><br/>
  <c:out value="${age }"></c:out><br/>
  ${requestScope.age }
</body>
</html>