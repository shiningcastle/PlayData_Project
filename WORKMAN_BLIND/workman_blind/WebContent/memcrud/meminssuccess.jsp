<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>가입 회원 상세 정보 화면</title>
</head>
<body>
	<br>
	<br>
	<br>
	<center>

		##
		<%
			out.println(request.getAttribute("msg"));
		%>
		## <br> 적게 일하고 돈 많이 버세요^^

		<h3>회원정보</h3>
		<hr>
		<p>
		<table border="1">
			<tr>
				<th>회원 ID</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>전화번호</th>
			</tr>
			<tr>
				<td>${sessionScope.member.userid}</td>
				<td>${sessionScope.member.userpw}</td>
				<td>${sessionScope.member.username}</td>
				<td>${sessionScope.member.usernum}</td>
			</tr>
		</table>

		<br>
		<br>
		<br> <a
			href="workman?command=memberupdatereq&userid=${sessionScope.member.userid}">수정하기</a>

		<a
			href="workman?command=memberdelete&userid=${sessionScope.member.userid}">탈퇴하기</a>

		&nbsp;&nbsp;&nbsp;<a
			href="${pageContext.request.contextPath}/index.html">메인 화면 이동</a>

	</center>
</body>
</html>
