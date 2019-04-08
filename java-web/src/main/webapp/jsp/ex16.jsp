<%@page import="java.util.ArrayList"%>
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
<title>ex16</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:useBean(ex16)</h1>

<jsp:useBean id="list" class="java.util.ArrayList" scope="page"/>

<%
for(Object n : list) {
  out.println(n + "<br>");
}
%>
</body>
</html>