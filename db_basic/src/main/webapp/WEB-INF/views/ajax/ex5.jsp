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
		req.open('post', 'ex5');
		req.send(null);
	}
	
	function textChange() {
		var result = document.getElementById("result");
		if (req.readyState == 4 && req.status == 200){
			var data = JSON.parse(req.response);
			
			var cdInnerHTML = "<table>"
			cdInnerHTML += "<tr><th>title</th><th>artist</th><th>price</th></tr>";
			data.cd.forEach((cd) => {
				cdInnerHTML += "<tr>"
				cdInnerHTML += "<td>" + cd.title + "</td>"
				cdInnerHTML += "<td>" + cd.artist + "</td>"
				cdInnerHTML += "<td>" + cd.price + "</td>"
				cdInnerHTML += "</tr>"
			});
			result.innerHTML = cdInnerHTML;
		}

	}
</script>
</head>
<body>
	<div id="result"></div>
	<button id="link">정보 가져오기</button>
</body>
</html>