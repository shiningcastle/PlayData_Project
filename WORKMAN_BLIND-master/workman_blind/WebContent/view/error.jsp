<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>에러 상황입니다</title>
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
<img src="https://media.giphy.com/media/cKKXNlTYino7hWNXwl/giphy.gif" width=300>
<p>
<%
out.println(request.getAttribute("msg"));
%>
<br>
<p>
<p>
<p>
<p>
<a href="index.html">로그인 페이지</a> &nbsp; <a href="workman?command=main">홈 페이지</a></center>
</body>
</html>