<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ page import="java.util.Random" isELIgnored="false" 
        isErrorPage="false" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
     Date date = null;
   %>
   <%
      Random random = new Random();
      int randomNumber = random.nextInt(100);
      
      out.println(randomNumber);
   %>
   <table>
   <%
      for(int i=1;i<11;i++){
    	  if(i%2==0){
   %>
      <tr bgColor='red'><td><%out.println(i) ;%></td></tr>
   <%     }else{ %>
      <tr bgColor='green'><td><%out.println(i) ;%></td></tr>
   <% 
          }
      }%>
   </table>
</body>
   
</html>