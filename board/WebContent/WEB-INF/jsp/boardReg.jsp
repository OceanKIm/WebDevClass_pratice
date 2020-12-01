<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글등록 페이지</title>
</head>
<body>
	<div>글등록</div>
	<!--  method=get -> doGet 메소드 -->
	<!--  method=post -> doPost 메소드 -->
	<form action="/BoardReg" method="post">
		<div>
			글번호 : <input type="number" name="i_board">
		</div>
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			내용 : <textarea name="ctnt">입력하세여.</textarea>
		</div>
		<div>
			<input type="submit" value="글등록"> 
		</div>
	</form>	
</body>
</html>