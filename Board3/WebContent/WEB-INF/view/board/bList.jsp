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
	<a href="regmod?typ=${param.typ}"><button>글등록</button></a>
</div>
<div>
	<table>
		<tr>
			<th>순번</th>
			<th>제목</th>
			<th>등록일</th>
			<th>수정일</th>
			<th>작성자</th>
			<th>조회수</th>			
		</tr>
		<c:forEach var="item" items="${data}">
		<tr class="pointer" onclick="clkArticle(${param.typ},${item.i_board})">
			<td>${item.seq}</td>
			<td>${item.title}</td>
			<td>${item.r_dt}</td>
			<td>${item.m_dt}</td>
			<td>${item.nm}</td>
			<td>${item.hits}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="pageContainer">
		<c:forEach begin="1" end="${pageCnt}" var="i">
			<span class="page">
				<a href="list?typ=${typ}&page=${i}">${i}</a>
			</span>
		</c:forEach>
	</div>
</div>
<script>
	<c:if test="${msg != null}">
		alert('${msg}');
	</c:if>
</script>












