<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ocean.board.*" 
		 import="java.util.List"	%>
<%
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("data");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>보드 리스트</h1>
		<table>
			<tr>
				<th>No</th>
				<th>제목</th>
			</tr>	
			<%for(BoardVO vo : list) {%>
				<tr>
					<th><%=vo.getI_board() %></th>
					<th><a href="/BoardDetail?i_board=<%=vo.getI_board()%>"><%=vo.getTitle()%></a></th>
				</tr>
			<% } %>				
		</table>
	</body>
</html>