<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>     
<c:choose>
	<c:when test="${fn:length(data) == 0}">
		<h3>글이 없습니다.</h3>
	</c:when>
	<c:otherwise>
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
		<c:if test="${loginUser != null}">
				<a href="/board/reg.korea?typ=${param.typ == null ? 1 : param.typ}"><button>글등록</button></a>
		</c:if>
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
				<th>좋아요</th>				
			</tr>
			<c:forEach var="item" items="${data}">
			<tr class="pointer" onclick="clkArticle(${param.typ == null ? 1 : param.typ},${item.i_board})">
				<td>${item.seq}</td>
				<td>${item.title}</td>
				<td>${item.r_dt}</td>
				<td>${item.m_dt}</td>
				<td>${item.writer_nm}</td>
				<td>${item.hits}</td>
				<td>${item.favorite_cnt}</td>
			</tr>
			</c:forEach>
		</table>
		<div class="pageContainer">
			<c:forEach begin="1" end="${pageCnt}" var="i">
				<span class="page">
					<a href="list?typ=${param.typ}&page=${i}">${i}</a>
				</span>
			</c:forEach>
		</div>
	</div>
	</c:otherwise>
</c:choose>

<script>
	<c:if test="${msg != null}">
		alert('${msg}');
	</c:if>
</script>












