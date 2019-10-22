<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  ${1+1 }<br/>
  ${1+"1" }<br/>
  ${"1" + "1" }<br/>

  ----------<br/>
  ${3-"2" }<br/>
  ---------------<br/>
  ${3/"2" }<br/>
  ${5%2 }<br/>
  ----------<br/>
  ${3>4 }<br/>
  ${"4">"3" }<br/>
  ${"a">"b" }<br/>
  ${"a"<"b" }<br/>
  ${"a"=="a" }<br/>
  -----------and  or not<br/>
  ${!(true and false) }<br/>
  ----------------<br/>
   ${5 mod 2 }<br/>
  
</body>
</html>