<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex1</title>
<script>
	window.onload = start;
	function start() {
		/* alert('onload start'); */
		var link = document.getElementById('link');
		link.onclick = send;
	}
	var req;
	function send() {
		req = new XMLHttpRequest();
		req.onreadystatechange = textChange;
		req.open('post', 'ex3');
		req.send(null);
	}
	function textChange() {
		if (req.readyState == 4 && req.status == 200){
			var data = JSON.parse(req.response);
			document.getElementById("id").innerHTML = data.id;
			document.getElementById("pw").innerHTML = data.pw;
		}

	}
</script>
</head>
<body>
	아이디:<label id="id"></label><br>
	비밀번호: <label id="pw"></label><br>
	<button id="link">정보 가져오기</button>
</body>
</html>