<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>디테일</title>
</head>
<body>
	<div><h3>디테일 페이지</h3></div>
	<div>
		<a href="/p4/bList"><button>리스트</button></a>
		<a href="/p4/bDel?i_board=${data.i_board}"><button>글삭제</button></a>
		<a href="/p4/bRegMod?i_board=${data.i_board}"><button>글수정</button></a>
	</div>
	<div>글번호 : ${data.i_board}</div>
	<div>제목 : ${data.title}</div>
	<div>내용 : ${data.ctnt}</div>
	<div>등록일 : ${data.r_dt}</div>
	<div>조회수 : ${data.views}</div>
</body>
</html>