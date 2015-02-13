<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>유저 등록</title>
		<script src="/resources/app/js/user/user.js"></script>
		<script type="text/javascript">
			$(function (){
				$('#userListDiv').hide();
			})
		</script>
	</head>
	<body>
		<form id="form" name="form" > 
			<input type="hidden" id="_method" name="_method"/>
			ID : <input type="text" id="id" name="id" maxlength="10" placeholder="영문만 입력해주세요"/> </br>
			이름 : <input type="text" id="name" name="name" maxlength="10" /> </br>
			나이 : <input type="text" id="age" name="age" maxlength="3" placeholder="숫자만 입력해주세요"/> </br>
		</form>
		
		<input type="button" id="join" onclick="userJoin()" value="등록"/>
		<input type="button" id="userList" onclick="userList()" value="유저목록"/>
		
		<div id="userListDiv">
			<table id="userListTable" border="1px">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>나이</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</body>
</html>