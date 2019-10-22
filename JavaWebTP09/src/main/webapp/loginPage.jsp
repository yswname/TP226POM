<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="login.jsp" method="post">
      请输入昵称:<input type='text' name='aliaName'/><input type='submit' value='进入聊天室'/>
    </form>
    <%
        Object message = request.getAttribute("message");
        if(message != null){
    %>
    
        <script type='text/javascript'>
            alert('<%=message%>');
        </script>
    <%
        }
    %>
</body>
</html>