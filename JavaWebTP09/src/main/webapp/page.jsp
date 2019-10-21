<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
        Object data = pageContext.getAttribute("DATA");
        out.println("pageContext:" + data);
        out.println("<br/>");
        out.println("request:" + request.getAttribute("REQ"));
    %>
</body>
</html>