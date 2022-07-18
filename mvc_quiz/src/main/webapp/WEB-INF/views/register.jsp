<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="register" method="post">
		<input type="text" name="id" id="id" placeholder="아이디" /></br>
		<input type="password" name="pwd" id="pwd" placeholder="비밀번호" /></br>
		<input type="text" name="name" id="name" placeholder="이름" /></br>
		<input type="submit" value="회원가입" />
		<input type="button" value="홈으로" onclick="location.href='list';" />
	</form>
</body>
</html>