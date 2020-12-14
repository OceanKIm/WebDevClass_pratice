<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<div>
<c:if test="${param.typ == 1 || param.typ == null}">
	 	<h3>게임 게시판</h3>
</c:if>
<c:if test="${param.typ == 2}">
		<h3>스포츠 게시판</h3>
</c:if>
<c:if test="${param.typ == 3}">
		<h3>연예/방송 게시판</h3>
</c:if>
</div>
<div>
	<a href="/bRegMod?typ=${typ}"><button>글등록</button></a>
</div>
<div>
	<table>
		<tr>
			<th>순번</th>
			<th>제목</th>
			<th>등록일</th>
			<th>수정일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="item" items="${data}">
		<tr class="pointer" onclick="clkItem(${typ},${item.i_board})">
			<td>${item.i_board}</td>
			<td>${item.title}</td>
			<td>${item.r_dt}</td>
			<td>${item.m_dt}</td>
			<td>${item.views}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="pageContainer">
		<a href="/bList?typ=${typ}&page=1&pageMove=first">◀</a>
		<a href="/bList?typ=${typ}&page=${pageBegin}&pageMove=down">◁</a>
		<c:forEach begin="${pageBegin}" end="${pageCnt}" var="i">
			<span class="page">
				<a href="/bList?typ=${typ}&page=${i}">${i}</a>
			</span>
		</c:forEach>
		<a href="/bList?typ=${typ}&page=${pageCnt + 1}&pageMove=up">▷</a>
		<a href="/bList?typ=${typ}&page=${pageEnd}&pageMove=last">▶</a>
	</div>
</div>
<script>
	<c:if test="${msg != null}">
		alert('${msg}');
	</c:if>
	function clkItem(typ, i_board) {
		console.log(`typ=${typ}, i_board=\${i_board}`);
		var url = `/bDetail?typ=\${typ}&i_board=\${i_board}`;
		location.href = url;
	}
</script>












