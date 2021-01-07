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
		<form action="/user/loginProc.korea" method="post">
			<div><input type="text" name="user_id" value="${user_id}" placeholder="id"></div>
			<div><input type="password" name="user_pw" placeholder="password"></div>
			<div><input type="submit" value="LOGIN"></div>
		</form>	
	</div>
	<div style="color:red;">${msg}</div>
	<div>
		<a href="/user/join.korea">go to join</a>
	</div>
</body>
</html>