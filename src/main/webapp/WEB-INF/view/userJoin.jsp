<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>유저 등록</title>
		<script type="text/javascript">
			function userJoin() {
				
				$.ajax({
					url:"/rest/insertUser",
					type:"POST",		// type에 PUT을 사용 하면 @ModelAttribute 적용 안됨.
					data: {name:$('#name').val(), 
							  id:$('#id').val(),
							  age:$('#age').val(),
							  _method:"PUT"},	// PUT + @ModelAttribute을 사용하기 위한 히든 메서드
					dataType:"json",
					success : function (data) {
						if(data.success) {
							alert("등록 완료.");	
						}
					},
					error : function (e) {
						alert("등록 실패... ㅜㅜ");
					}
				});
				
			}
		</script>
	</head>
	<body>
		<form id="form" name="form" > 
			ID : <input type="text" id="id" name="id" maxlength="10" placeholder="영문만 입력해주세요"/> </br>
			이름 : <input type="text" id="name" name="name" maxlength="10" /> </br>
			나이 : <input type="text" id="age" name="age" maxlength="3" placeholder="숫자만 입력해주세요"/> </br>
		</form>
		
		<input type="button" id="join" onclick="userJoin()" value="등록"/>
	</body>
</html>