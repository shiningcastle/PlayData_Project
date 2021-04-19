<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>logout</title>
</head>
<body bgcolor="lightgray" text="black">
&nbsp;
<p>
<p>
<p>
<p>
<p>
<p>
<p>
<p>
<center>

<img src="https://media.giphy.com/media/1jkVi22T6iUrQJUNqk/giphy.gif" width=350>
<h2> 다음에 봐요~ ${sessionScope.id}님, Workman이었습니다!</h2>
<%	session.invalidate();
	session = null; %>

<center> <input type='BUTTON' value="초기 화면으로 돌아가기" onclick="location.href='index.html'">
</center>
</body>
</html>