<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
 <link rel="stylesheet"
 href="${contextRootPath}/css/common.css">
 <title>새 수업</title></head>
<body>
 <jsp:include page="../header.jsp" />
<h1>새 수업(JSP)</h1>
<form action='add' method='post'>
<table border='1'>
<tr>
  <th>수업</th>
  <td><input type='text' name='title'></td>
</tr>
<tr>
  <th>내용</th>
  <td><textarea name='contents' rows='5' cols='50'></textarea></td>
</tr>
<tr>
  <th>시작일</th>
  <td><input type='date' name='startDate'></td>
</tr>
<tr>
  <th>종료일</th>
  <td><input type='date' name='endDate'></td>
</tr>
<tr>
  <th>총 교육시간</th>
  <td><input type='number' name='totalHours'></td>
</tr>
<tr>
  <th>일 교육시간</th>
  <td><input type='number' name='dayHours'></td>
</tr>
</tr>
</table>
<p>
  <button type='submit'>등록</button>
  <a href='list'>목록</a>
</p>
</form>
<jsp:include page="../javascript.jsp" />
</body>
</html>


