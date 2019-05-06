<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<title>새 수업</title>
  <link rel="stylesheet" href="/java-web-project/node_modules/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="/java-web-project/css/header.css">
  <link rel="stylesheet" href="/java-web-project/css/common.css">
  <link rel="stylesheet" href="index.css">
</head>
<body>
 <h1>새 수업</h1>
 <form action='add' method='post'>

  <div class="form-group row">
   <label for="title" class="col-sm-2 co-form-label">수업 제목</label>
   <div class="col-sm-10">
    <input type='text' class="form-control" name='title'>
   </div>
  </div>

  <div class="form-group row">
   <label for="title" class="col-sm-2 co-form-label">내용</label>
   <div class="col-sm-10">
    <textarea name='contents' class="form-control" rows='5' cols='50'></textarea>
   </div>
  </div>

  <div class="form-group row">
   <label for="startDate" class="col-sm-2 co-form-label">시작일</label>
   <div class="col-sm-10">
    <input type='date' class="form-control" name='startDate'>
   </div>
  </div>

  <div class="form-group row">
   <label for="startDate" class="col-sm-2 co-form-label">종료일</label>
   <div class="col-sm-10">
    <input type='date' class="form-control" name='endDate'>
   </div>
  </div>

  <div class="form-group row">
   <label for="startDate" class="col-sm-2 co-form-label">총 교육시간</label>
   <div class="col-sm-10">
    <input type='number' class="form-control" name='totalHours'>
   </div>
  </div>

  <div class="form-group row">
   <label for="startDate" class="col-sm-2 co-form-label">일 교육시간</label>
   <div class="col-sm-10">
    <input type='number' class="form-control" name='dayHours'>
   </div>
  </div>

   <div class="form-group row">
    <div class="col-sm-10">
      <a class="btn btn-primary" href='.'>목록</a> 
      <button class="btn btn-primary">등록</button>
    </div>
  </div>
 </form>
<script src="/java-web-project/node_modules/jquery/dist/jquery.slim.min.js"></script>
<script src="/java-web-project/node_modules/popper.js/dist/umd/popper.min.js"></script>
<script src="/java-web-project/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="../header.js"></script>
<script src="index.js"></script>
</body>
</html>


