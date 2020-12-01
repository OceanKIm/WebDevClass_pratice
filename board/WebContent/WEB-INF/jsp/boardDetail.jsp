<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.ocean.board.*"%>
<%
	BoardVO vo = (BoardVO)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>board detail page</title>
	</head>
	<body>
		<h1>디테일 페이지 입니다.</h1>
		<div>제목 : <%=vo.getTitle()%></div>
		<div>내용 : <%=vo.getCtnt()%></div>
		<div>수정일 : <%=vo.getR_dt()%></div>
	</body>
</html>