<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String[] names = {"홍길동", "임꺽정", "유관순"};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex05</title>
</head>
<body>
<h1>표현식(expression element)</h1>
<ul>
<%for (String name : names) {%>
<li><%=name %></li>
<%}%>
</ul>
</body>
</html>