<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInfo</title>
</head>
<script>
let msg = '<c:out value="${msg}" />';
if (msg != ""){
	alert(msg);
}
</script>
<body>
	<c:import url="/header"/>
<%-- 	<jsp:useBean id="memberDAO" class="actionTag.MemberDAO" /> --%>
<%-- 	<c:set var="members" value="<%=memberDAO.selectAll() %>" /> --%>
	<div align="center">
		<h1>회원 목록</h1>
		<c:choose>
			<c:when test="${empty members }">`````	
				<h1>등록된 데이터가 없습니다.</h1>
			</c:when>
			<c:otherwise>
				<table border=1>
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>전화번호</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="member" items="${members }">
							<tr>
								<td onclick="location.href='user_info?id=${member.getId() }'">
								${member.getId() }
								</td>
								<td>${member.getName() }</td>
								<td>${member.getTel() }</td>
							</tr>
						
						</c:forEach>
					</tbody>
				</table>
			
			</c:otherwise>
		</c:choose>
	</div>
	<c:import url="/footer"/>
</body>
</html>






























