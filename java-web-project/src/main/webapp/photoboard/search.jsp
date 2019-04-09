<%@page import="com.eomcs.lms.domain.PhotoBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 trimDirectiveWhitespaces="true"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>사진 검색</title>
</head>
<body>
 <jsp:include page="/header.jsp" />
 <h1>사진 검색 결과(JSP2 + EL + JSTL)</h1>
 <table border='1'>
   <jsp:useBean scope="request" id="list" type="java.util.List<PhotoBoard>"/>
  <tr>
   <th>번호</th>
   <th>제목</th>
   <th>등록일</th>
   <th>조회수</th>
   <th>수업</th>
  </tr>
<c:forEach items="${list }" var="board">
  <tr>
   <td>${board.no}</td>
   <td><a href='detail?no=${board.no}'>${board.getTitle}</a></td>
   <td>${board.getCreatedDate}</td>
   <td>${board.getViewCount}</td>
   <td>${board.getLessonNo}</td>
  </tr>
  </c:forEach>
 </table>
 <p>
  <a href='list'>목록</a>
</body>
</html>

