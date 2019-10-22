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
    <%
       User u = new User();
       u.setAge(10);
       u.setUserName("zhangsan");
       pageContext.setAttribute("user", u);
       
       u = new User();
       u.setUserName("lisi");
       request.setAttribute("user", u);
       // 就近原则
       // EL表达式的隐式对象
       u = new User();
       u.setUserName("wangwu");
       session.setAttribute("user", u);
       
       u = new User();
       u.setUserName("zhaoliu");
       application.setAttribute("user", u);
    %>
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