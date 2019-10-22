<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="Refresh" content="2,userList.jsp">
</head>
<body>
   <%--
   1 获取所有的昵称
   2 循环显示
   3 用不同颜色，标记自己
    --%>
    在线用户：<br/>
    <c:forEach items="${ALIANAME_SET }" var="aliaName">
       <c:choose>
          <c:when test="${aliaName == CURR_ALIA_NAME }">
             <font color="red">${aliaName }</font><br/>
          </c:when>
          <c:otherwise>${aliaName }<br/></c:otherwise>
       </c:choose>
    </c:forEach>
    
</body>
</html>