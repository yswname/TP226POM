<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <font color='red'>
     <%
        String name = request.getParameter("name");
        byte[] bytes = name.getBytes("iso-8859-1");
        //name = new String(bytes,"utf-8");
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String message = "上午好";
        if(hour>12 && hour<18){
        	message = "下午好";
        }else if(hour>=18 && hour<=24){
        	message = "晚上好";
        }
        out.println(name +" ");
        out.println(message);
     %>
   </font>
</body>
</html>