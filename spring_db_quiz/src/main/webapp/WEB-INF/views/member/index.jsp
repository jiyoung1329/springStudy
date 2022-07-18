<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<script>
let msg = '<c:out value="${msg}" />';
if (msg != ""){
	alert(msg);
}
</script>
</head>

<body>
	<c:import url="/header" />
	<c:import url="/main" />
	<c:import url="/footer" />
</body>
</html>