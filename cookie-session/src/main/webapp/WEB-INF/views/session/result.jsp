<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션 확인 페이지</h3>
	아이디: ${sessionScope.id } <br>
	비밀번호: ${sessionScope.pw } <br>
	<a href="delete">세션 삭제하기</a>
</body>
</html>