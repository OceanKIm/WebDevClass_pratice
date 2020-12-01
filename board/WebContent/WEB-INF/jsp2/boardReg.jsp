<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board Reg</title>
</head>
<body>
	<h3>글쓰기</h3>
	<form action="/v2/BoardReg" method="post">
	<div>
		제목 : <input type="text" name="title">
	</div>
		내용 : <textarea name="ctnt">입력창...</textarea>
	<div>
		<input type="submit" value="등록">
	</div>
	</form>
</body>
</html>