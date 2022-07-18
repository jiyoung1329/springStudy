<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty sessionScope.id }">
		<a href="login"><button>로그인</button></a>
	</c:if>
	<c:if test="${not empty sessionScope.id }">
		<a href="logout"><button>로그아웃</button></a>
	</c:if>
</body>
</html>