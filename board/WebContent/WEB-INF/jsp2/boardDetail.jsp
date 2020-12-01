<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>board detail</title>
</head>
<body>
	<h3>보드 디테일</h3>
	<div>
		<a href="/v2/BoardDel?i_board=${data.i_board}">
			<button>글삭제</button>
		</a>
		<a href="/v2/BoardMod?i_board=${data.i_board}">
			<button>글수정</button>
		</a>
	</div>
	<div>
		<div>제목 : ${data.title}</div>
		<div>내용 : ${data.ctnt}</div>
		<div>작성일 : ${data.r_dt}</div>
		<div>수정일 : ${data.m_dt}</div>
		<div>조회수 : ${data.views}</div>
	</div>
		<div>
		<a href="/v2/BoardList">
			<button>목록</button>
		</a>
	</div>
</body>
</html>