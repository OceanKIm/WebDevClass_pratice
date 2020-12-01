<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String missYou() {
		return "joann";
	}

	int Adder(int a, int b) {
		return a + b;
	}
	
	String upper(String str) {
		return str.toUpperCase();
	}
%>
<%
	// 스크립트릿 test
	int a = 10;
	int b = 20;
	String name = "ocean";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scriptlet Test</title>
</head>
<body>
	<h3>a = <%= a%></h3>
	<h3>b = <%= b%></h3>
	<h3>name = <%= name %></h3>
	<h3>miss you <%=missYou()%></h3>
	<h3>5 + 7 = <%=Adder(5, 7)%></h3>
	<h3>upper joann = <%=upper("joann")%></h3>
</body>
</html>