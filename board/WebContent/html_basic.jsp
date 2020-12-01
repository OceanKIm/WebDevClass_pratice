<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- 이부분 절대 건들면 안됌 -->
 <!-- this is 주석! -->
<!DOCTYPE html> <!-- 개중요한 부분!! html5문법으로 이 문서가 되어있다는 뜻 -->
<html> <!-- html은 head와 body로 이루어져 있음 -->
	<head>
		<meta charset="UTF-8">
		<title>Hello</title> 
		<link rel="stylesheet" type="text/css" href="common.css">
		<style>
			/* 태그 선택자 - 모든 div에 적용되게 함 */
			div {
				color:blue;
				background-color:yellow;
			}
			/* 클래스 선택자 - 주로 제일 많이 씀*/
			.span2 {
				color:orange;
			}
			.list {
				color:purple;
			}
			/* ID 선택자  - 유니크한 값임! 같은 id값이 있어서는 안됨 (주로 자바스크립트를 위함)*/
			#div3 {
				color:green;
			}		
		</style>
	</head>
	<body>
		<a href="img.jsp">아이유 보러 가기</a>
		<!-- in-line 태그 (span) 자기가 필요한 크기의 위치를 차지함? -->
		<span style="color:red;">안녕하세요</span>
		<span class="span2">안녕하세요</span>
		<br> <!--  br 개행 -->
		<!--  block 태크 (div) 자기위치의 가로 값을 다 차지함. 때문에 실제로 개행이 된 것이 아님 -->
		<div>안뇽!</div>
		<div>안뇽!</div>
		<div id="div3">div test</div>
		
		<!-- 목록 만들기 등 -->
		<ul class="list">
			<strong><li>list 1</li></strong>
			<i><li>list 2</li></i>
			<li>list 3</li>
			<li>list 4</li>
			<li>list 5</li>
		</ul>	
		
		<h1>Hello JSP</h1>
		<h2>Hello JSP</h2>
		<h3>Hello JSP</h3>
	</body>
</html>








