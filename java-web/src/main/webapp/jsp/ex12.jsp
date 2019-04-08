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
<title>ex12</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:useBean</h1>
<%
application.setAttribute("s1", "홍길동");
session.setAttribute("s2", "임꺽정");
request.setAttribute("s3", "안중근");
pageContext.setAttribute("s4", "윤봉길");
%>
<jsp:useBean id="s1" type="java.lang.String" scope="application"/>
<jsp:useBean id="s2" type="java.lang.String" scope="session"/>
<jsp:useBean id="s3" type="java.lang.String" scope="request"/>
<jsp:useBean id="s4" type="java.lang.String" scope="page"/>

<%--
<jsp:useBean id="s5" type="java.lang.String" scope="page"/>
 --%>
 
<%=s1 %><br>
<%=s2 %><br>
<%=s3 %><br>
<%=s4 %><br>
</body>
</html>