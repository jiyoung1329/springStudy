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
	<c:set var="count" value="${0 }" />
	<c:if test="${ list.isEmpty() == false }">
		<table border=1>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
			</tr>
			<c:forEach var="member" items="${list }" >
				<c:set var="count" value="${count+1 }" />
				<tr>
					<td>${member.id }</td>
					<td>${member.pwd }</td>
					<td>${member.name }</td>
				</tr>
			</c:forEach>
			
		</table>
	</c:if>
	total record: ${count }
</body>
</html>