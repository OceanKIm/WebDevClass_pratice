<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>보드 리스트2</h1>
		<h3><a href="/BoardReg">글쓰기</a></h3>
		<table>
			<tr>
				<th>No</th>
				<th>제목</th>
			</tr>	
			<c:forEach var="val" items="${data}">
				<tr>
					<td>${val.i_board}</td>
					<td>
					<a href="/BoardDetail?i_board=${val.i_board}">
						${val.title}
					</a>
					</td>
				</tr>
			</c:forEach>			
		</table>
	</body>
</html>