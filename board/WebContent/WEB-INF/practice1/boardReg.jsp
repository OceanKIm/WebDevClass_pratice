<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>글작성</title>
	</head>
<body>
	<h3>글등록</h3>
	<form action="/p1/BoardReg" method="post" >
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			내용 : <textarea name="ctnt">입력하세요..</textarea>
		</div>
		<div>
			<input type="submit" value="글등록">
		</div>
	</form>
</body>
</html>