<%@page import="com.eomcs.lms.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 trimDirectiveWhitespaces="true"%>
<%
String contextRootPath = application.getContextPath();
    %>
<jsp:useBean scope="session" id="loginUser" type="com.eomcs.lms.domain.Member"/>
<header>
 <img src='http://bitcamp.co.kr/img/logo.jpg' style='height: 50px'>
 <%if (loginUser == null) {%>
 <a href='<%=contextRootPath %>/auth/login'>로그인</a>
 <%} else {%>
 <img src='<%=contextRootPath %>/upload/member/${loginUser.photo}' 
     style='height: 20px;'>${loginUser.name}
 <a href='<%=contextRootPath %>/auth/logout'>로그아웃</a>
 <%}%>
</header>