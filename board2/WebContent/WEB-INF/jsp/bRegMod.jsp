<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<body>
	<div>
		<h3>
			${(typ == 1) ? '게임게시판' : (typ == 2) ? '스포츠게시판' : '연예/방송게시판'}
			${data != null ? '글수정':'글등록'}
		</h3>
	</div>
	<div>
		<div>
			글번호 : <input type="text" name="i_board" value="${data != null ? data.i_board : num}" readonly>
		</div>
	</div>
	<form action="/bRegMod" method="post" id="frm" onsubmit=" return chk(); ">
		<div>
			<input type="hidden" name="typ" value="${typ}">	
		</div>
		<div>
			<input type="hidden" name="i_board" value="${data.i_board}" readonly>
		</div>
		<div>
			제목 : <input type="text" name="title" value="${data.title}">
		</div>
		<div>
			내용 : <textarea name="ctnt">${data.ctnt}</textarea>
		</div>
		<div>
			<input type="submit" value="${data != null ? '글수정':'글등록'}">
			<input type="reset" value="리셋">	
		</div>
	</form>
	<script>
		function chk() {
			var frm = document.querySelector('#frm');
			if (chkEmptyEle(frm.title, '제목') || chkEmptyEle(frm.ctnt, '내용')) {
				return false;
			}
			return true;
		}
		<c:if test="${err != null}"> 
			alert('${err}');
		</c:if> 
	</script>
</body>















