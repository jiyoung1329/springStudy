<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="login">로그인</a>
	<a href="register">회원가입</a>
	
	<br><br>
	
	<h3>model 속성 출력</h3>
	아이디: ${id }<br>
	비밀번호: ${pw }<br>
	아이디: ${login.id }<br>
	비밀번호: ${login.pw }<br>
	
	${msg }
</body>
</html>