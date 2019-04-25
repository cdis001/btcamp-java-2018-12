<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
<link rel="stylesheet" href="${contextRootPath}/css/common.css">
<title>사진 검색</title>
</head>
<body>
 <jsp:include page="../header.jsp" />
 <h1>사진 검색 결과(JSP2 + EL + JSTL)</h1>
 <table border='1'>
  <tr>
   <th>번호</th>
   <th>제목</th>
   <th>등록일</th>
   <th>조회수</th>
   <th>수업</th>
  </tr>
  <c:forEach items="${list}" var="board">
   <tr>
    <td>${board.no}</td>
    <td><a href='detail?no=${board.no}'>${board.title}</a></td>
    <td>${board.createdDate}</td>
    <td>${board.viewCount}</td>
    <td>${board.lessonNo}</td>
   </tr>
  </c:forEach>
 </table>
 <p>
  <a href='./'>목록</a>
  <jsp:include page="../javascript.jsp" />
</body>
</html>

