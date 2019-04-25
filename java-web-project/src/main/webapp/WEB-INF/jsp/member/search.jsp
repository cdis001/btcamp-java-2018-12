<%@page import="com.eomcs.lms.domain.Member"%>
<%@page import="java.util.List"%>
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
<title>회원 목록</title>
</head>
<body>
 <jsp:include page="../header.jsp" />
 <h1>회원 목록(JSP2 + EL + JSTL)</h1>
 <table border='1'>
  <tr>
   <th>번호</th>
   <th>이름</th>
   <th>이메일</th>
   <th>전화번호</th>
   <th>가입일</th>
  </tr>
  <c:forEach items="${list}" var="member">
   <tr>
    <td>${member.no}</td>
    <td><a href='./${member.no}'>${member.name}</a></td>
    <td>${member.email}</td>
    <td>${member.tel}</td>
    <td>${member.registeredDate}</td>
   </tr>
  </c:forEach>
 </table>
 <p>
  <a href='./'>목록</a>
  <jsp:include page="../javascript.jsp" />
</body>
</html>

