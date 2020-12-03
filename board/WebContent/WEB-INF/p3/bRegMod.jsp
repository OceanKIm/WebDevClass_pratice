<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<c:if test="${param.i_board > 0}">
		<title>글수정</title>
	</c:if>
	<c:if test="${param.i_board == 0}">
		<title>글작성</title>
	</c:if>
</head>
<body>
	<c:if test="${param.i_board > 0}">
		<h3>글수정</h3>
	</c:if>
	<c:if test="${param.i_board == 0}">
		<h3>글작성</h3>
	</c:if>
	<div style="color:red;">${msg}</div>
	<form action="/p3/bRegMod" method="post" id="frm" onsubmit="return chk();">
		<div>
			<input type="hidden" name="i_board" value="${param.i_board}">
		</div>
		<div>
			제목 : <input type="text" name="title" value="${data.title}">
		</div>
		<div>
			내용 : <textarea name="ctnt">${data.ctnt}</textarea>
		</div>
		<div>
			<c:if test="${param.i_board > 0}">
				<input type="submit" value="수정">
				<input type="reset" value="리셋">	
			</c:if>
			<c:if test="${param.i_board == 0}">
				<input type="submit" value="등록">
				<input type="reset" value="리셋">	
			</c:if>	
		</div>
	</form>
	<script>
		function chk() {
			console.log('chk() called!');
			var frm = document.querySelector('#frm');
			console.log('i_board = ' + frm.i_board.value);
			if (frm.title.value == '') {
				alert('제목을 입력하세요.');
				frm.title.focus();
				return false;
			} else if (frm.ctnt.value == '') {
				alert('내용을 입력하세요.');
				frm.ctnt.focus();
				return false;
			}
		}
	</script>
</body>
</html>














