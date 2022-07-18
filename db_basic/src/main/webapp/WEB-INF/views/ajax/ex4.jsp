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
		var input= document.getElementById('input').value;
		console.log("input", input);
		req = new XMLHttpRequest();
		req.onreadystatechange = textChange;
		req.open('post', 'ex4');
		var data = {input: input}
		data = JSON.stringify(data);
		req.setRequestHeader('Content-Type', 'application/json; charset=UTF-8')
		req.send(input);
	}
	function textChange() {
		if (req.readyState == 4 && req.status == 200){
			var data = JSON.parse(req.response);
			document.getElementById("result").innerHTML = data.result;
		}

	}
</script>
</head>
<body>
	입력 :<input type="text" id="input"><br>
	입력값: <label id="result"></label><br>
	<button id="link">정보 가져오기</button>
</body>
</html>