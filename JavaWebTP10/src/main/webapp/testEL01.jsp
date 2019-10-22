<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="cn.com.demo.javaweb.tp10.bean.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    ${user }<br/>get(is)/setUserName   UserName  userName<br/>
    ${pageScope.user.userName}<br/>
    ${requestScope.user.userName }<br/>
    ${sessionScope.user.userName }<br/>
    ${applicationScope.user.userName }<br/>
    ----------------------------<br/>
    ${param["name"] }<br/>
    ${paramValues["name"][1] }<br/>
    ${cookie["JSESSIONID"].value }
</body>
</html>