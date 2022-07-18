<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member</title>

<style>
.danger {color: red;}
.success {color: green;}
</style>
</head>
<body>
<c:if test="${not empty msg }" >
	<script>alert("${msg}");</script>
</c:if>

	<form action="member" method="post" id="f">
		<input type="text" name="id" id="id" placeholder="아이디">
		<input type="button" value="중복확인" onclick="doubleCheck()"><br>
		<div id="id-comment"></div>
		<input type="password" name="pw" id="pw" placeholder="비밀번호"><br>
		<input type="password" name="confirmPw" id="confirmPw" placeholder="비밀번호 확인"><br>
		<input type="text" name="name" id="name" placeholder="이름"><br>
		<input type="text" name="email" id="email" placeholder="이메일">
		<input type="button" value="인증번호전송" onclick="sendAuth()" ><br>
		<input type="text" name="authNumber" id="authNumber" placeholder="인증번호" />
		<input type="button" value="인증번호확인" onclick="checkAuth()" ><br>
		<input type="submit" value="회원 가입" >
		<input type="button" value="취소" onclick="location.href='index'">
	</form>
	
</body>
<script>
const comment = document.querySelector("#id-comment");
console.log("comment1: ", comment)
var req;
function doubleCheck(){
	const id = document.querySelector("#id").value;
	req = new XMLHttpRequest();
	req.onreadystatechange = makeComment;
	req.open('post', 'double_check');
	req.setRequestHeader('Content-Type', 'application/json; charset=UTF-8')
	console.log("id: ", id)
	if (id){
		req.send(id);
	} else {
		comment.innerText = "아이디를 입력해주세요."
		comment.className = "danger";
	}
}
function makeComment(){
	if (req.readyState == 4 && req.status == 200){
		if (req.response == "pass"){
			comment.innerText = "사용가능한 아이디입니다.";
			comment.className = "success";
		} else {
			comment.innerText = "이미 존재하는 아이디입니다.";
			comment.className = "danger";
			
		}
		
	}
}

function result(){
	
}

function sendAuth(){
	req = new XMLHttpRequest();
	req.onreadystatechange = result;
	req.open('post', 'sendAuth');
	req.setRequestHeader('Content-Type', 'application/json; charset=UTF-8')
	req.send(document.getElementById("email").value)
}

function checkAuth(){
	req = new XMLHttpRequest();
	req.onreadystatechange = result;
	req.open('post', 'checkAuth');
	req.setRequestHeader('Content-Type', 'application/json; charset=UTF-8')
	req.send(document.getElementById("authNumber").value)
}
</script>
</html>