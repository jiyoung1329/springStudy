<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<script>
	function check(){
/* 		id = document.getElementById('id');
		pw = document.getElementById('pw');
	
		if(id.value == "" || pw.value == ""){
			alert('필수 항목입니다.');
			return;
		} */
		document.getElementById('f').submit();
	}
</script>
</head>
<body>
<c:if test="${not empty msg }" >
	<script>alert("${msg}");</script>
</c:if>

<c:choose>
	<c:when test="${empty sessionScope.id }">
		<form action="login" method="post" id="f">
			<input type="text" name="id" placeholder="아이디" /> <br>
			<input type="password" name="pw" placeholder="비밀번호" /> <br>
			<input type="button" value="로그인" onclick="check();">
			<input type="button" value="취소" onclick="javascript:location.href='index'">
		</form>
	</c:when>
	<c:otherwise>
		<p>
			${sessionScope.name }님 환영합니다.<br><br>
			<a href="index">인덱스 페이지로 이동</a>
		</p>
	</c:otherwise>
</c:choose>
</body>
</html>


