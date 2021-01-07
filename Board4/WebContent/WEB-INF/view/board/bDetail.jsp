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
		<a href="list?typ=${param.typ}"><button>리스트</button></a>		
	</div>
	<div>
		<div>글번호 : ${data.seq}</div>
		<div>작성자 : ${data.nm}</div>		
		<div>제목 : ${data.title}</div>
		<div>내용 : ${data.ctnt}</div>
		<div>작성일 : ${data.r_dt}</div>
		<div>수정일 : ${data.m_dt}</div>
		<div>조회수 : ${data.hits}</div>
	</div>
	<c:if test="${loginUser.i_user == data.i_user}">
		<div>
			<button onclick="clkDel(${data.i_board}, ${param.typ})">글삭제</button>
			<a href="regmod?i_board=${data.i_board}&typ=${param.typ}"><button>글수정</button></a>
		</div>		
	</c:if>
	<div style="margin-top: 20px;">
		<div>
			<form action="cmt/reg" method="post">
				<input type="hidden" name="typ" value="${param.typ}">
				<input type="hidden" name="i_board" value="${data.i_board}">
				댓글 : <input type="text" name="ctnt">
				<input type="submit" value="댓글쓰기">
			</form>
		</div>
		<div>
			<table>
				<tr>
					<th>순번</th>
					<th>댓글</th>
					<th>작성일</th>		
					<th>작성자</th>	
					<th>공감</th>	
					<th>비공감</th>	
					<th>비고</th>	
				</tr>
				<c:forEach items="${cmtList}" var="item">
					<tr>
						<td>${item.seq}</td>
						<td>${item.ctnt}</td>
						<td>${item.r_dt}</td>
						<td>${item.nm}</td>
						<td class="emp" id="emp_${item.i_cmt}" onclick="clkEmp(${item.i_cmt});">${item.emp}</td>
						<td class="emp" id="unemp_${item.i_cmt}" onclick="clkUnemp(${item.i_cmt});">${item.unemp}</td>
						<c:if test="${item.i_user == loginUser.i_user}">
							<td>
								<a href="cmt/del?i_board=${data.i_board}&typ=${param.typ}&i_cmt=${item.i_cmt}">
									<button>삭제</button>
								</a>
								<button onclick="clkCmtMod(${item.i_cmt});">수정</button>								
							</td>
						</c:if>
					</tr>
					<c:if test="${item.i_user == loginUser.i_user}">
						<tr	id="mod_${item.i_cmt}" class="cmd_mod_form">
							<td	colspan="4">
							 	<form action="cmt/mod" method="post">
								 	<input type="hidden" name="typ" value="${param.typ}">	
									<input type="hidden" name="i_board" value="${data.i_board}">
									<input type="hidden" name="i_cmt" value="${item.i_cmt}">
									<input type="text" name="ctnt" value="${item.ctnt}">
									<input type="submit" value="수정">
									<input type="button" value="닫기" onclick="clkCmtClose(${item.i_cmt});">				 							 		
							 	</form>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
			<a href="detail?i_board=${data.i_board}&typ=${data.typ}&showCmt=${showCmt + 10}"><button>댓글더보기</button></a>
		</div>
	</div>
	<div id="favoriteContainer" is_favorite="${data.is_favorite}"
		onclick="toggleFavorite(${data.i_board});">
		<c:choose>
			<c:when test="${data.is_favorite == 1}">
				<i class="fas fa-heart"></i>
			</c:when>
			<c:otherwise>
				<i class="far fa-heart"></i>
			</c:otherwise>
		</c:choose>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
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

























