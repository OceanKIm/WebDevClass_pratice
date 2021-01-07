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
				<li><a href="/main.korea">메인</a></li>
				<c:forEach items="${menus}" var="item">
					<li><a href="/board/list.korea?typ=${item.typ}">${item.nm}</a></li>
				</c:forEach>
				<c:if test="${loginUser == null}">
					<li><a href="/user/login.korea">로그인</a></li>
				</c:if>				
				<c:if test="${loginUser != null}">
					<li><a href="/user/logout.korea">로그아웃</a></li>
					<li style="color:white;">${loginUser.nm}님 환영합니다.</li>
				</c:if>
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