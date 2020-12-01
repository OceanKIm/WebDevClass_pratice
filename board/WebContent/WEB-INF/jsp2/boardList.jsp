<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Board List</title>
</head>
<body>
	<h3>리스트</h3>
	<div>
		<a href="/v2/BoardReg">
			<button>글쓰기</button>
		</a>
	</div>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성일</th>
			<th>수정일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="itme" items="${data}">
		<tr>
			<td>${itme.i_board}</td>
			<td><a href="/v2/BoardDetail?i_board=${itme.i_board}">
				${itme.title}
				</a></td>
			<td>${itme.r_dt}</td>
			<td>${itme.m_dt}</td>
			<td>${itme.views}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>