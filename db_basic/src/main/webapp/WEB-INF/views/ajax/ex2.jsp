<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex1</title>
<script>
	window.onload=start;
	function start(){
		/* alert('onload start'); */
		var link = document.getElementById('link');
		link.onclick=send;
	}
	var req;
	function send(){
		req = new XMLHttpRequest();
		req.onreadystatechange = textChange;
		req.open('post', 'ex1');
		req.send(null);
	}
	function textChange(){
		console.log(5, req.readyState, req.response)
		for (var i=1; i<=5; i++){
			if (req.readyState == i){
				document.getElementById(`data` + i).innerHTML = req.readyState + " " + req.response;
				
			}
			
		}
	}
</script></head>
<body>
	<div id="data1"> AJAX == 비동기 통신</div>
	<div id="data2"> AJAX == 비동기 통신</div>
	<div id="data3"> AJAX == 비동기 통신</div>
	<div id="data4"> AJAX == 비동기 통신</div>
	<a href="#" id="link">데이터 가져오기</a>
</body>
</html>