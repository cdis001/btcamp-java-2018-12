<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>사진 조회</title>
<jsp:include page="../commonCss.jsp" />
</head>
<body>
 <jsp:include page="../header.jsp" />

 <div class="container">
  <h1>사진 조회</h1>
  <c:choose>
   <c:when test="${empty board}">
    <p>해당 번호의 사진이 없습니다</p>
   </c:when>
   <c:otherwise>
    <form action='update' method='post' enctype='multipart/form-data'>

     <div class="form-group row">
      <label for="no" class="col-sm-2 col-form-label">번호</label>
      <div class="col-sm-10">
       <input type="text" class="form-control-plaintext" id="no" name='no' value='${board.no}'
        readonly>
      </div>
     </div>

     <div class="form-group row">
      <label for="contents" class="col-sm-2 col-form-label">제목</label>
      <div class="col-sm-8">
       <input name='title' class="form-control-plaintext" value='${board.title}'>
      </div>
     </div>
     
     <div class="form-group row">
    <label for="createdDate" class="col-sm-2 col-form-label">등록일</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" 
          id="createdDate" value="${board.createdDate}">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="viewCount" class="col-sm-2 col-form-label">조회수</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" 
          id="viewCount" value="${board.viewCount}">
    </div>
  </div>
  
  <div class="form-group row">
      <label for="lessonNo" class="col-sm-2 col-form-label">수업</label>
      <div class="col-sm-8">
       <td><select name='lessonNo'>
         <option value='0'>수업을 선택하세요</option>
         <c:forEach items="${lessons }" var="lesson">
          <option value='${lesson.no}' ${board.getLessonNo() == lesson.getNo() ? "selected" : "" }>
           ${lesson.title}(${lesson.startDate} ~ ${lesson.endDate})</option>
         </c:forEach>
       </select></td>
      </tr>
      <input type='hidden' class="form-control-plaintext" name='lessonNo' value='110'>
      </tr>
      <tr>
       <td colspan='2'>최소 한 개의 사진 파일을 등록해야 합니다.</td> <br>
      </tr>
      <tr>
       <th>사진1</th>
       <td><input type='file' class="form-control-plaintext" name='photo'></td>
      </tr>
      <tr>
       <th>사진2</th>
       <td><input type='file' class="form-control-plaintext" name='photo'></td>
      </tr>
      <tr>
       <th>사진3</th>
       <td><input type='file' class="form-control-plaintext" name='photo'></td>
      </tr>
      <tr>
       <th>사진4</th>
       <td><input type='file' class="form-control-plaintext" name='photo'></td>
      </tr>
      <tr>
       <th>사진5</th>
       <td><input type='file' class="form-control-plaintext" name='photo'></td>
      </tr>
      <tr>
       <th>사진</th>
       <td><c:set var="contextRootPath" value="${pageContext.servletContext.contextPath}"></c:set>
        <c:forEach items="${board.files}" var="file">
         <img src='${contextRootPath}/upload/photoboard/${file.filePath}' style='height: 80px'>
        </c:forEach></td>
      </tr>
      </div>
     </div>

     <div class="form-group row">
    <div class="col-sm-10">
      <a class="btn btn-primary" href='.'>목록</a> 
      <a class="btn btn-primary" href='delete/${board.no}'>삭제</a> 
      <button class="btn btn-primary">변경</button>
    </div>
  </div>
    </form>
   </c:otherwise>
  </c:choose>
  <jsp:include page="../javascript.jsp" />
</body>
</html>


