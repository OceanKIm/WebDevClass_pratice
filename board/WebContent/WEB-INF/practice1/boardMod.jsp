<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>글수정</title>
	</head>
<body>
	<h3>글수정</h3>
	<form action="/p1/BoardMod" method="post" >
		<div>
			<input type="hidden" name="i_board" value="${data.i_board}">
		</div>
		<div>
			제목 : <input type="text" name="title" value="${data.title}">
		</div>
		<div>
			내용 : <textarea name="ctnt">${data.ctnt}</textarea>
		</div>
		<div>
			<input type="submit" value="글수정">
			<input type="reset" value="리셋">
		</div>
	</form>
</body>
</html>