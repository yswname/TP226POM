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
   <form action="login" method="post">
      UserName:<input type="text" name="userName"/><br/>
      Password:<input type='password' name='password'/><br/>
      <input type="submit" value='登录'/>
   </form>
  <c:if test="${!empty errorMsg }">
   <script type="text/javascript">
      alert('${errorMsg}');
   </script>
  </c:if>
</body>
</html>