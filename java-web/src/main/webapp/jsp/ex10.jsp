<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex10</title>
</head>
<body>
<h1>JSP 빌트인 객체</h1>
<%
request.setAttribute("aaa", "111");
session.setAttribute("bbb", "222");
application.setAttribute("ccc", "333");
out.println("444");
%>
</body>
</html>