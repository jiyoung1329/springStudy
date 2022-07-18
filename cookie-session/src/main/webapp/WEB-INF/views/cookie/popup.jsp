<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>쿠키를 위한 팝업창입니다.</h3><br><br>
		
	<input type="checkbox" onclick="addCookie()"> 하루동안 열지않음
	
	<script>
	function addCookie(){
		fetch("/cookie_session/cookie/addCookie")
		.then(res => {window.close();})
		.catch(err => {console.log(err);})
	}
	</script>
	
</body>
</html>