<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Lesson lesson = (Lesson) request.getAttribute("lesson");
%>
<!DOCTYPE html>

<html><head><title>회원 조회</title></head>
<body>
 <jsp:include page="/header.jsp" />
<h1>수업 조회(JSP)</h1>
<%if (lesson == null) { %>
    <p>해당 번호의 수업이 없습니다.</p>
<%}%>
<form action='update' method='post'>
<table border='6'>
<tr><th>번호</th><td><input type='text' name='no' value='<%=lesson.getNo() %>' readonly></td></tr>
<tr><th>수업명</th><td><input type='text' name='title' value='<%=lesson.getTitle() %>' textarea></td> </tr>
<tr><th>내용</th><td><input type='text' name='contents' value='<%=lesson.getContents() %>' textarea></td> </tr>
<tr><th>시작일</th><td><input type='text' name='startDate' value='<%=lesson.getStartDate() %>' textarea></td> </tr>
<tr><th>종료일</th><td><input type='text' name='endDate' value='<%=lesson.getEndDate() %>' textarea></td> </tr>
<tr><th>총수업시간</th><td><input type='text' name='totalHours' value='<%=lesson.getTotalHours() %>' textarea></td> </tr>
<tr><th>일수업시간</th><td><input type='text' name='dayHours' value='<%=lesson.getDayHours() %>' textarea></td> </tr>
</table>
<p><a href='list'>목록</a> <a href='delete?no=<%=lesson.getNo() %>'>삭제</a> <button type='submit'>변경</button><p>
</form>
</body></html>


