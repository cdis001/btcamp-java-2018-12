<%@page import="com.eomcs.lms.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>

<html>
<head>
<title>회원 목록</title>
</head>
<body>
 <jsp:include page="/header.jsp" />
 <h1>회원 목록(JSP + EL)</h1>
 <p>
  <a href='/../java-web-project'>전체목록</a>
 </p>
 <p>
  <a href='add'>회원가입</a>
 </p>
 <table border='1'>
  <tr>
   <th>번호</th>
   <th>이름</th>
   <th>이메일</th>
   <th>전화번호</th>
   <th>가입일</th>
  </tr>
    <jsp:useBean scope="request" id="list" type="java.util.List<Member>"/>
    <%
    for (Member member : list) {
      request.setAttribute("member", member);
  %>
  <tr>
   <td>${member.no}</td>
   <td><a href='detail?no=${member.no}'>${member.name}</a></td>
   <td>${member.email}</td>
   <td>${member.tel}</td>
   <td>${member.registeredDate}</td>
  </tr>
  <% } %>
  <form action='search'>
   <table border='1'>
    <input type='text' name='keyword' value='' textarea>
    </td>
    </tr>
    <button type='submit'>검색</button>
    </form>
   </table>
</body>
</html>
