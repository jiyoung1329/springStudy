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
		var search= document.getElementById('search').value;

		req = new XMLHttpRequest();
		req.onreadystatechange = textChange;
		req.open('post', 'ex6');
		req.send(search);
	}
	
	function textChange() {
		var result = document.getElementById("result");
		if (req.readyState == 4 && req.status == 200){
			console.log(req.response);
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
	검색 :<input type="text" id="search">
	<button id="link">검색하기</button><br>
	결과: 
	<div id="result"></div><br>
</body>
</html>