function userJoin() {
	$('#_method').val("PUT");
	var data = $('#form').serialize();
	
	$.ajax({
		url:"/rest/insertUser",
		type:"POST",	
		data: data,
		dataType:"json",
		success : function (data) {
			if(data.success) {
				alert("등록 완료.");	
				$('#form input').val("");
				userList();
			}
		},
		error : function (request, status, error) {
			alert("에러코드 : " + request.status + "\n" + "등록실패.. ㅜ");
		}
	});
}

function userList() {
	$.ajax({
		url:"/rest/selectUserList",
		type:"GET",	
		dataType:"json",
		success : function (data) {
			$('#userListDiv').hide();
			$('#userListTable tbody tr').remove();
			
			$.each(data, function(index, data){
				$.newTr = $("<tr><td>"+data.id+"<a href=\"javascript:userDel('"+data.id+"');\">[삭제]</a></td><td>"+data.name+"</td><td>"+data.age+"</td><tr>");
				$('#userListTable tbody').append($.newTr);
			});
			
			$('#userListDiv').show();
		},
		error : function (e) {
			alert("등록 실패... ㅜㅜ");
		}
	});
}

function userDel(id) {
	$.ajax({
		url:"/rest/deleteUser/"+id,
		type:"POST",	
		data: {
			_method : "DELETE"
		},
		dataType:"json",
		success : function (data) {
			if(data.success) {
				alert("삭제 완료");
				userList();
			}
		},
		error : function (e) {
			alert("삭제 실패... ㅜㅜ");
		}
	});
}