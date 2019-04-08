<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    buffer="1kb"
    autoFlush="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex08</title>
</head>
<body>
<h1>include 지시문</h1>
<%@ include file = "./ex08_header.txt" %>
<p>테스트</p>
<%@ include file = "./ex08_footer.txt" %>
</body>
</html>