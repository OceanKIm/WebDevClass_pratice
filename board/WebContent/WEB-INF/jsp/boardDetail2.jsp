<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>this is detail page</title>
</head>
	<body>
		<h1>디테일페이지 2입니다.</h1>
		<a href="/BoardDel?i_board=${data.i_board}">
			<button>삭제</button>
		</a>
		<a href="/BoardMod?i_board=${data.i_board}">
			<button>수정</button>
		</a>
		<div>제목 : ${data.title}</div>
		<div>내용: ${data.ctnt}</div>
		<div>등록일 : ${data.r_dt}</div>
		<div>수정일 : ${data.m_dt}</div>	
	</body>
</html>