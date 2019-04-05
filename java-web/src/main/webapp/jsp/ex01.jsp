<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP 구동 원리</h1>
<pre>
1. 웹 브라우저 ==> 서블릿 컨테이너
    -JSP 실행 요청
2. 서블릿 컨테이너가 실행
    2.1. JSP의 서블릿 객체를 찾는다
      2.2. 있으면,
        2.2.1. 그 서블릿 객체를 호출한다.
      2.3. 없으면,
       - JSP엔진을 이용하여 JSP 파일을 가지고 서블릿 자바 소스 파일을 생성한다.
        - 자바 컴파일러를 이용하여 소스 파일을 컴파일 한다.
        - 서블릿 객체를 생성한다.
        - 그 서블릿 객체를 호출한다.
        
</pre>
</body>
</html>