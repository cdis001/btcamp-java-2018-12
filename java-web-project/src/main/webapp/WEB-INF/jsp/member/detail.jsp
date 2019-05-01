<%@page import="com.eomcs.lms.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 조회</title>
<jsp:include page="../commonCss.jsp" />
</head>
<body>

 <jsp:include page="../header.jsp" />

 <div class="container">
  <h1>회원 조회</h1>
  <jsp:useBean scope="request" id="member" type="com.eomcs.lms.domain.Member" />
  <c:choose>
   <c:when test="${empty member}">
    <p>해당 번호의 회원이 없습니다</p>
   </c:when>
   <c:otherwise>
    <form action='update' method='post' enctype='multipart/form-data'>

     <div class="form-group row">
      <label for="no" class="col-sm-2 col-form-label">번호</label>
      <div class="col-sm-10">
       <input type="text" class="form-control-plaintext" id="no" name='no' value='${member.no}'
        readonly>
      </div>
     </div>

     <div class="form-group row">
      <label for="name" class="col-sm-2 col-form-label">이름</label>
      <div class="col-sm-8">
       <textarea class="form-control" id="name" name='name' rows='1'>${member.name}</textarea>
      </div>
     </div>

     <div class="form-group row">
      <label for="email" class="col-sm-2 col-form-label">이메일</label>
      <div class="col-sm-8">
       <textarea class="form-control" id="email" name='email' rows='1'>${member.email}</textarea>
      </div>
     </div>

     <div class="form-group row">
      <label for="password" class="col-sm-2 col-form-label">암호</label>
      <div class="col-sm-8">
       <input type='password' class="form-control-plaintext" name='password'>
      </div>
     </div>

     <div class="form-group row">
      <label for="photo" class="col-sm-2 col-form-label">사진</label>
      <div class="col-sm-8">
       <input type='password' class="form-control-plaintext" name='password'>
       <c:set var="contextRootPath" value="${pageContext.servletContext.contextPath}"></c:set>
       <c:if test="${empty member.photo}">
        <img src='${contextRootPath}/images/default.jpg' style='height: 80px'>
       </c:if>
       <c:if test="${not empty member.photo}">
        <img src='${contextRootPath }/upload/member/${member.photo} ' style='height: 80px'>
       </c:if>
       <input type='file' class="form-control-plaintext" name='photoFile'>
      </div>
     </div>

     <div class="form-group row">
      <label for="name" class="col-sm-2 col-form-label">전화</label>
      <div class="col-sm-8">
       <input type='text' class="form-control-plaintext" name='tel' value='${member.tel}'>
      </div>
     </div>

     <div class="form-group row">
      <label for="registeredDate" class="col-sm-2 col-form-label">가입일</label>
      <div class="col-sm-10">
       <input type="text" readonly class="form-control-plaintext" id="registeredDate"
        value="${member.registeredDate}">
      </div>
     </div>

     <div class="form-group row">
      <div class="col-sm-10">
       <a class="btn btn-primary" href='.'>목록</a> <a class="btn btn-primary"
        href='delete/${member.no}'>삭제</a>
       <button class="btn btn-primary">변경</button>
      </div>
     </div>
    </form>
   </c:otherwise>
  </c:choose>
 </div>
 <!-- .container -->
 <jsp:include page="../javascript.jsp" />
</body>
</html>

