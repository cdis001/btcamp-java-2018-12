<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<title>수업 조회</title>
</head>
<body>
 <jsp:include page="../header.jsp" />
 <h1>수업 조회(JSP + EL + JSTL)</h1>
 <c:choose>
 <c:when test="${empty lesson}">
  <p>해당 번호의 수업이 없습니다.</p>
 </c:when>
  <c:otherwise>
 <form action='update' method='post'>
  <table border='6'>
   <tr>
    <th>번호</th>
    <td><input type='text' name='no' value='${lesson.no}' readonly></td>
   </tr>
   <tr>
    <th>수업명</th>
    <td><input type='text' name='title' value='${lesson.title}' textarea></td>
   </tr>
   <tr>
    <th>내용</th>
    <td><input type='text' name='contents' value='${lesson.contents}' textarea></td>
   </tr>
   <tr>
    <th>시작일</th>
    <td><input type='text' name='startDate' value='${lesson.startDate}' textarea></td>
   </tr>
   <tr>
    <th>종료일</th>
    <td><input type='text' name='endDate' value='${lesson.endDate}' textarea></td>
   </tr>
   <tr>
    <th>총수업시간</th>
    <td><input type='text' name='totalHours' value='${lesson.totalHours}' textarea></td>
   </tr>
   <tr>
    <th>일수업시간</th>
    <td><input type='text' name='dayHours' value='${lesson.dayHours}' textarea></td>
   </tr>
  </table>
  <p>
   <a href='./'>목록</a> <a href='delete/${lesson.no}'>삭제</a>
   <button type='submit'>변경</button>
  <p>
 </form>
 </c:otherwise>
  </c:choose>
</body>
</html>


