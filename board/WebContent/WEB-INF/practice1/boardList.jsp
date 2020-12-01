<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메인 게시판</title>
</head>
	<body>
		<h3>메인 게시판</h3>
		<div>
			<a href="/p1/BoardReg"><button>글쓰기</button></a>
		</div>
		<table>
			<tr>
				<th>NO</th>
				<th>제목</th>
				<th>등록일</th>
			</tr>
			<c:forEach var="item" items="${data}">
			<tr>
				<td>${item.i_board}</td>
				<td><a href="/p1/BoardDetail?i_board=${item.i_board}">${item.title}</a></td>
				<td>${item.r_dt}</td>				
			</tr>
			</c:forEach>
		</table>
	</body>
</html>