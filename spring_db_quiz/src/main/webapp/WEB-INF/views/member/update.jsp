<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
<c:url var="root" value="/" />
<script src="${root }/resources/check.js"></script>
</head>
<body>
<script>
let msg = '<c:out value="${msg}" />';
if (msg != ""){
	alert(msg);
}
</script>
<c:choose>

	<c:when test="${empty sessionScope.id }">
		<script>alert('로그인 후 이용하세요.'); location.href='login.jsp';</script>
	</c:when>
	
	<c:otherwise>
		<c:import url="/header" />
		<div align="center">
			<h1>회원 수정</h1>
			<table>
			<tr><td>
				<form action="update" method="post" id="f">
					<input type="text" name="id" id="id" value="${sessionScope.id }" readonly><br>
					<input type="password" name="pwd1" placeholder="비밀번호" id="pwd1"><br>
					<input type="password" name="pwd2" placeholder="비밀번호 확인 " id="pwd2" onchange="pwCheck()">
					<label id="label">(*필수 체크)</label><br>
					<input type="text" name="name" id="name" value="${member.name }" ><br>
					<input type="text" name="addr" value="${member.addr }" ><br>
					<input type="text" name="tel" value="${member.tel }" ><br>
					<input type="button" value="회원수정" onclick="allCheck()"><br>
				</form>
			</td></tr>
			</table>
		</div>
		<c:import url="/footer" />
	</c:otherwise>
	
</c:choose>
</body>
</html>