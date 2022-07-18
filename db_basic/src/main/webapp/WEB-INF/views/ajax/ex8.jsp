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
		const search = document.getElementById('search').value;
		const option = document.getElementById('sel').value;
		let data = {search: search, option: option}
		data = JSON.stringify(data);
		console.log(data)
		req = new XMLHttpRequest();
		req.onreadystatechange = textChange;
		req.open('post', 'ex8');
		req.setRequestHeader('Content-Type', 'application/json; charset=UTF-8')
		req.send(data);
	}
	
	function textChange() {
		var result = document.getElementById("result");
		if (req.readyState == 4 && req.status == 200){
// 			console.log(req.response)
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
	<select id="sel">
		<option value="title" selected>타이틀</option>
		<option value="artist">아티스트</option>
		<option value="price">가격</option>
	</select>
	<input type="text" id="search">
	<button id="link">검색하기</button><br>
	결과: 
	<div id="result"></div><br>
</body>
</html>