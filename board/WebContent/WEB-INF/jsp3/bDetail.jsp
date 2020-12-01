<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>디테일</title>
</head>
<body>
	<h3>디테일 페이지</h3>
	<div>
		<a href="/v3/bDel?i_board=${data.i_board}"><button>글삭제</button></a>
		<a href="/v3/bRegMod?i_board=${data.i_board}"><button>글수정</button></a>
	</div>
	<div>제목 : ${data.title}</div>
	<div>내용 : ${data.ctnt}</div>
	<div>작성일 : ${data.r_dt}</div>
	<div>수정일 : ${data.m_dt}</div>
	<div>조회수 : ${data.views}</div>	
	<!-- <div>param test1 =  ${param}</div>	
	<div>param test2 =  ${param.i_board}</div> -->
</body>
</html>