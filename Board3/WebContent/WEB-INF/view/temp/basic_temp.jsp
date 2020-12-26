<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${title}</title>
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	<link rel="stylesheet" href="/res/css/common.css?ver=4">
	<link rel="stylesheet" href="/res/css/board.css?ver=8">
	<c:forEach items="${jsList}" var="item">
		<script defer src="/res/js/${item}.js?ver=9"></script>
	</c:forEach>
	<script defer src="/res/js/common.js?ver=3"></script>
</head>
<body>
	<div id="container">
		<header>
			<ul>
			<li><a href="/main">메인</a></li>
				<li><a href="/board/list?typ=1">게임</a></li>
				<li><a href="/board/list?typ=2">스포츠</a></li>
				<li><a href="/board/list?typ=3">연예방송</a></li>
				<li><a href="/logout">Logout</a></li>
				<li style="color:white;">${loginUser.nm}님 환영합니다.</li>
			</ul>
		</header>
		<section>
			<jsp:include page="${page}"/>
		</section>
		<footer>
		</footer>
	</div>
</body>
</html>