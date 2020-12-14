<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>로그인</title>
	</head>
<body>
	<div>
		<h3>로그인 페이지 입니다.</h3>
	</div>
	<div>
		<form action="/bLogin" method="post">
			<div>
				아이디 : <input type="text" name="user_id">
			</div>
			<div>
				비밀번호 : <input type="text" name="user_pw">
			</div>
			<div>
				<input type="submit" value="로그인">
			</div>
		</form>
	</div>
	<div>
		<a href="/bSign"><button>회원가입</button></a>
	</div>
	<script>
		<c:if test="${msg != null}">
			alert('${msg}');
		</c:if>
	</script>
</body>
</html>