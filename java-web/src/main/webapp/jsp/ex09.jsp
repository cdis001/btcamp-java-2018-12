<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex09</title>
</head>
<body>
<h1>tablib 지시문</h1>
<c:forEach items="홍길동,임꺽정,유관순,안중근,윤봉길,김구,김원봉" var="n">
이름=<%=pageContext.getAttribute("n") %>, ${n} <br>
</c:forEach>
</body>
</html>