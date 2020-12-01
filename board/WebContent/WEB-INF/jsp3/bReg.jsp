<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글등록</title>
</head>
<body>
	<h3>글등록</h3>
	<form action="/v3/bReg" method="post">
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			내용 : <textarea name="ctnt"></textarea>
		</div>
		<div>
			<input type="submit" value="등록">
			<input type="reset" value="리셋">	
		</div>
	</form>
</body>
</html>