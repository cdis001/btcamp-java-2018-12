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
<title>ex11</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:useBean</h1>
<jsp:useBean id="b1" class="bitcamp.vo.Board" scope="page"/>
<jsp:useBean id="b2" class="bitcamp.vo.Board"/>
<jsp:useBean id="b3" class="bitcamp.vo.Board"/>

<jsp:setProperty property="no" name="b3" value="100"/>
<jsp:setProperty property="contents" name="b3" value="내용입니다"/>
<jsp:setProperty property="viewCount" name="b3" value="256"/>
<%--
<jsp:setProperty property="createdDate" name="b3" value="2019-04-10"/>
 --%>
<%=b1 %><br>
<%=b2 %><br>
<%=b3 %><br>
</body>
</html>