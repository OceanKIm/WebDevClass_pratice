<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<body>
	<div>
		<h3>
			${(param.typ == 1) ? '게임게시판' : (param.typ == 2) ? '스포츠게시판' : '연예/방송게시판'}
			${data != null ? '글수정':'글등록'}
		</h3>
	</div>
	<form action="regmod" method="post" id="frm">
		<div>
			<input type="hidden" name="typ" value="${param.typ}">	
		</div>
		<div>
			<input type="hidden" name="i_board" value="${data.i_board}">
		</div>
		<div>
			제목 : <input type="text" name="title" value="${data.title}" required>
		</div>
		<div>
			내용 : <textarea name="ctnt" required>${data.ctnt}</textarea>
		</div>
		<div>
			<input type="submit" value="${data != null ? '글수정':'글등록'}">
			<input type="reset" value="리셋">	
		</div>
	</form>
	<script>
		<c:if test="${err != null}"> 
			alert('${err}');
		</c:if> 
	</script>
</body>















