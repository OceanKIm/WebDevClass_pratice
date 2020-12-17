<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<body>
	<div>
		<c:if test="${param.typ == 1 || param.typ == null}">
				<h3>게임 디테일</h3>
		</c:if>
		<c:if test="${param.typ == 2}">
				<h3>스포츠 디테일</h3>
		</c:if>
		<c:if test="${param.typ == 3}">
				<h3>연예/방송 디테일</h3>
		</c:if>
	</div>
	<div>
		<a href="/bList?typ=${param.typ}"><button>리스트</button></a>		
	</div>
	<div>
		<div>글번호 : ${data.i_board}</div>
		<div>제목 : ${data.title}</div>
		<div>내용 : ${data.ctnt}</div>
		<div>작성일 : ${data.r_dt}</div>
		<div>수정일 : ${data.m_dt}</div>
		<div>조회수 : ${data.views}</div>
	</div>
	<div>
		<form action="/bDetail" method="post">
			<input type="hidden" name="typ" value="${data.typ}">
			<input type="hidden" name="i_board" value="${data.i_board}">
			<input type="submit" value="글삭제" onclick="isDel(event);">
		</form>
		<a href="/bRegMod?i_board=${data.i_board}&typ=${data.typ}"><button>글수정</button></a>
	</div>
	<div style="margin-top: 20px;">
		<div>
			<form action="/cmt" method="post">
				<input type="hidden" name="typ" value="${data.typ}">
				<input type="hidden" name="i_board" value="${data.i_board}">
				댓글 : <input type="text" name="cmt_ctnt">
				<input type="submit" value="댓글쓰기">
			</form>
		</div>
		<div>
			<table>
				<tr>
					<th>순번</th>
					<th>댓글</th>
					<th>작성일</th>		
					<th>공감</th>	
					<th>비공감</th>	
				</tr>
				<c:forEach items="${cmtList}" var="item">
					<tr>
						<td>${item.i_cmt}</td>
						<td>${item.ctnt}</td>
						<td>${item.r_dt}</td>
						<td><a href="/cmt?typ=${param.typ}&i_board=${param.i_board}&i_cmt=${item.i_cmt}&emp=yes&showCmt=${showCmt}">
						${item.emp}</a></td>
						<td><a href="/cmt?typ=${param.typ}&i_board=${param.i_board}&i_cmt=${item.i_cmt}&emp=no&showCmt=${showCmt}">
						${item.unemp}</a></td>
					</tr>
				</c:forEach>
			</table>
			<a href="/bDetail?i_board=${data.i_board}&typ=${data.typ}&showCmt=${showCmt + 10}"><button>댓글더보기</button></a>
		</div>
	</div>
	<script>
		function isDel(e){
			var result = confirm('삭제하시겠습니까?');
			if (!result) {
				e.preventDefault();
			}
		}
		<c:if test="${msg != null}">
			alert('${msg}');
		</c:if>
	</script>
</body>
