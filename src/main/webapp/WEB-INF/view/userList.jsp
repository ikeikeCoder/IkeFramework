<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>유저 목록</title>
</head>
<body>
	<form name="form">
		<table style="border:1px;">
			<thead>
				<tr>
					<td>No</td>
					<td>ID</td>
					<td>Name</td>
					<td>Age</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}" varStatus="users">
				<tr>
					<td>${users.index }</td>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.age }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>