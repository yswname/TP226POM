<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <c:set var="age" value="10" scope="request"></c:set><br/>
  <c:out value="30"></c:out><c:out value="zhangsan"></c:out><br/>
  <c:out value="${age +10}"></c:out><br/>
  ${requestScope.age }<br/>
  
  <c:if test="${!empty age }">
     存在${age }<br/>
  </c:if>
  
  <c:if test="${empty message }">
    !!!!!!!!!!!!!!!!!!!!1
  </c:if>
  <br/>
  <c:choose>
    <c:when test="${age<12 }">儿童</c:when>
    <c:when test="${age<28 }">青少年</c:when>
    <c:otherwise>中老年</c:otherwise>
  </c:choose>
  <%
     String[] names = new String[]{"a","b","c","d"};
     List<String> list = new ArrayList<String>();
     list.add("a1");
     list.add("a2");
     list.add("a3");
     list.add("a4");
     Map<String,String> map = new HashMap<String,String>();
     map.put("a1", "v1");
     map.put("a2", "v2");
     map.put("a3", "v3");
     pageContext.setAttribute("names", map);
  %>
  <br/>
  <c:forEach items="${names }" var="name" varStatus="_var">
     ${name.key }---》${_var.index }<br/>
  </c:forEach>
  
  <!-- 专业迭代字符串 -->
  <c:forTokens items="a.bafdsafass.cafdsfsaafdgsrerafdsa.d.y.k" delims=".a" var="_tmp">
     ${_tmp }<br/>
  </c:forTokens>
 
</body>
</html>