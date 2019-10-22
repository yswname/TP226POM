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
    <!-- 输出列表 -->
    
   <table>
   <%--控制表格输出--%>
   <%
      count++;
      
      System.out.println(isEmpty(null));
      String test = null;
      test = "abc";
      System.out.println(test);
      
      
      /**
       * 多行
       **/
      for(int i=1;i<11;i++){
    	  System.out.println("******" + isEmpty("abc"));
    	  // 偶数行
    	  if(i%2==0){
   %>
     
      <tr bgColor='red'><td><%out.println(i) ;%>  -- <%=count %></td></tr>
   <%     }else{ %>
      <tr bgColor='green'><td><%=i+20%></td></tr>
   <% 
          }
      }%>
      
      
   </table>
</body>
   <%!
       int count = 0;
       boolean isEmpty(String str){
    	   boolean bool = false;
    	   bool = str != null && !"".equals(str);
    	   return bool;
       }
    %>
</html>