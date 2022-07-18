<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/cookie_session/cookie/result">쿠키확인</a>
	<script>
	const width = 500;
	const height= 500;
	const popupCookie = getCookie("popup");
	console.log(popupCookie);
	if (popupCookie == null){
		window.open("/cookie_session/cookie/popup", "popup", "width=500, height=200");
	}
	
	 function getCookie(name) {
        var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
        return value? value[2] : null;
     };

	
	</script>
</body>
</html>