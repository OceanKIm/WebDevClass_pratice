<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
</head>
<body>
	<div>
		<h3>회원가입 페이지 입니다.</h3>
	</div>
	<div>
		<form action="/bSign" method="post">
			<div>
				아이디 : <input type="text" name="user_id">
			</div>
			<div>
				비밀번호 : <input type="text" name="user_pw">
			</div>
			<div>
				비번확인 : <input type="text" name="user_pw_chk">
			</div>
			<div>
				이름 : <input type="text" name="user_name">
			</div>
			<div>
				성별 : <input type="text" name="user_gen">
			</div>
			<div>
				<input type="submit" value="회원가입">
			</div>			
		</form>
	</div>
	<script>
		<c:if test="${msg != null}">
			alert('${msg}');
		</c:if>
	</script>	
</body>
</html>