<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="root" value="/" />
<script src="${root }/resources/check.js"></script>
<script>
let msg = '<c:out value="${msg}" />';
if (msg != ""){
	alert(msg);
}
</script>
<c:choose>

<c:when test="${empty sessionScope.id }">
	<script>alert('로그인 후 이용하세요.'); location.href='/mvc_quiz/login';</script>
</c:when> 

<c:otherwise>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
</head>
<body>
	<c:import url="/header" />
	<div align="center">
		<h1>회원 탈퇴</h1>
		<table>
		<tr><td>
			<form action="delete" method="post" id="f">
				<input type="text" name="id" value="<%=session.getAttribute("id") %>" readonly> <br>
				<input type="password" name="pwd1" placeholder="비밀번호"><br>
				<input type="password" name="pwd2" placeholder="비밀번호 확인" ><br>
				<input type="submit" value="탈퇴"><br>
			</form>
		</td></tr>
		</table>
	</div>
	<c:import url="/footer" />
</body>
</html>

</c:otherwise>
</c:choose>