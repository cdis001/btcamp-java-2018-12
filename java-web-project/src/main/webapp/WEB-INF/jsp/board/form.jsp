<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<jsp:include page="../commonCss.jsp" />
<title>새 글(JSP)</title>
</head>
<body>
 <jsp:include page="../header.jsp" />
 <div class="container">
 <h1>새 글</h1>
 <form action='add' method='post'>
 
 <div class="form-group row">
    <label for="contents" class="col-sm-2 col-form-label">내용</label>
    <div class="col-sm-8">
      <textarea class="form-control" id="contents" 
                name='contents' rows='5'></textarea>
    </div>
  </div>
  
  <div class="form-group row">
    <div class="col-sm-10">
      <a class="btn btn-primary" href='./'>목록</a> 
      <button class="btn btn-primary">등록</button>
    </div>
  </div>
 </form>
  </div>
 <!-- .container -->
 <jsp:include page="../javascript.jsp" />
</body>
</html>
