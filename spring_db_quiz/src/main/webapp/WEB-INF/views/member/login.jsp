<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<script src="check.js"></script>
<c:url var="root" value="/" />
<script src="${root }/resources/check.js"></script>
<script>
let msg = '<c:out value="${msg}" />';
if (msg != ""){
	alert(msg);
}
</script>


</head>
<body>
	<div align="center">
		<h1>로그인</h1>
		<table>
		<tr><td>
			<form action="login" id="f">
				<input type="text" name="id" placeholder="아이디" id="id"> <br>
				<input type="password" name="pwd1" placeholder="비밀번호" id="pwd1"><br>
				<input type="button" value="로그인" onclick="loginCheck()"><br>
			</form>
		</td></tr>
		</table>
	</div>
	<c:import url="/footer" />
</body>
</html>