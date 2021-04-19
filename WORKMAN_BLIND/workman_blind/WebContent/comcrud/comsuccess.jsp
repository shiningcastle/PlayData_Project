<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>가입 기업 상세 정보 화면</title>
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
		## <br> 귀사의 발전을 기원합니다!

		<h3></h3>
		<hr>
		<p>
		<table border="1">
			<tr>
				<th>기업명</th>
				<th>비밀번호</th>
				<th>업종</th>
				<th>주소</th>
				<th>전화번호</th>
			</tr>
			<tr>
				<td>${sessionScope.company.companyname}</td>
				<td>${sessionScope.company.companypw}</td>
				<td>${sessionScope.company.category}</td>
				<td>${sessionScope.company.companyloc}</td>
				<td>${sessionScope.company.companynum}</td>
			</tr>
		</table>

		<br>
		<br>
		<br> &nbsp;&nbsp;&nbsp;<a
			href="${pageContext.request.contextPath}/index.html">메인 화면 이동</a>

	</center>
</body>
</html>

<!-- <a href="workman?command=CompanyUpdateReq&Companyname=${sessionScope.company.companyname}">수정하기</a>

<a href="workman?command=Companydelete&Companyname=${sessionScope.company.companyname}">탈퇴하기</a> -->
