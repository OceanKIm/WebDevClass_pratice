<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${title}</title>
</head>
<body>
	<div><h3>로그인</h3></div>
	<div>
		<form action="/login" method="post">
			<div><input type="text" name="user_id" placeholder="id"></div>
			<div><input type="password" name="user_pw" placeholder="password"></div>
			<div><input type="submit" value="LOGIN"></div>
		</form>	
	</div>
	<div>
		<a href="/join">go to join</a>
	</div>
	<script>
		<c:if test="${msg != null}">
			alert('${msg}');
		</c:if>
	</script>
</body>
</html>