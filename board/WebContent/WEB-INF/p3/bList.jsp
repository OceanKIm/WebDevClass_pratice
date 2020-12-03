<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리스트</title>
</head>
<body>
	<h3>보드 리스트</h3>
	<div>
		<a href="/p3/bRegMod?i_board=0"><button>글쓰기</button></a>
	</div>
	<div>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="item" items="${data}">
			<tr>
				<td>${item.i_board}</td>
				<td><a href="/p3/bDetail?i_board=${item.i_board}">
					${item.title}
				</a></td>
				<td>${item.r_dt}</td>
				<td>${item.views}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<script>
		<c:if test="${msg != null}">
			alert('${msg}');
		</c:if>
	</script>
</body>
</html>