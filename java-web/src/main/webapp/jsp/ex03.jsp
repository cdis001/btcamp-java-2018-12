<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% int i = 100; %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>스크립트릿(scriptlet)과 JSP 주석</h1>
<pre>
<%--
JSP 주석
 -해당 태그 안에 작성한 것은 자바 코드를 생성할 때 제거된다
 
스크립트릿
 -JSP 파일 안에 실행할 자바 코드를 넣은 태그
 -예)
  <% 자바 코드 %>
 -스크립트릿 안에 작성한 코드는 실행시 복사되어 실행됨 
 --%>
</pre>
<%
if (i < 10) {
  for (int x = 0; x < i ; x++) {
    out.println("<p>" + x + "</p>");
  }
}
%>
</body>
</html>