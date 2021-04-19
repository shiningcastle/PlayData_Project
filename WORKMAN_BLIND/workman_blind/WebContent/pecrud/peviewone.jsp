<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>해당 알바 리뷰글 출력</title>
</head>
<body>

<c:choose>
		<c:when test="${sessionScope.type == 1}">
			<div class="navi" style="font-color: gray">
				<p style="background: linear-gradient(-135deg, #c850c0, #4158d0);text-align: right;">
					<a href="workman?command=companyupdatereq" class="id"><i
						class="fa fa-gamepad" style="font-size: 30px; color: grey;"></i>${sessionScope.id}</a>
					(기업 회원)님 &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <i class="fa fa-sign-out"
						style="font-size: 30px; color: grey;"></i><a
						href="workman?command=logout" class="logout">[로그아웃]</a>&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;<br>
				</p>
			</div>
		</c:when>

		<c:otherwise>
			<div class="navi" style="font-color: gray">
				<p style="background: linear-gradient(-135deg, #c850c0, #4158d0);text-align: right;">
					<a href="workman?command=memberupdatereq" class="id"><i
						class="fa fa-gamepad" style="font-size: 30px; color: grey;"></i>${sessionScope.id}</a>
					(일반 회원)님 &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <i class="fa fa-sign-out"
						style="font-size: 30px; color: grey;"></i><a
						href="workman?command=logout" class="logout">[로그아웃]</a>&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;<br>
				</p>
			</div>
		</c:otherwise>
	</c:choose>

	
	<div id="Location">
			<a href="${pageContext.request.contextPath}/main.jsp">홈으로</a>
			<!-- &gt; -->
			<!--  <a href="/story/">알바스토리</a> &gt; <strong>알바리뷰</strong> -->
		</div>

	<br>
	<br>
	<br>
	<center>


		<h3>${sessionScope.ptevalcom.companyname.companyname}</h3>
		<hr>
		<p>
		<table border="1">
			<tr>
				<th>글번호</th>
				<th>작성자 ID</th>
				<th>장단점</th>
				<th>급여지불</th>
				<th>근무환경</th>
				<th>관리자 성향</th>
				<th>추가의견</th>
			</tr>
			<tr>
				<td>${sessionScope.ptevalcom.evalnum}</td>
				<td>${sessionScope.ptevalcom.userid.userid}</td>
				<td>${sessionScope.ptevalcom.proscons}</td>
				<td>${sessionScope.ptevalcom.wagedelay}</td>
				<td>${sessionScope.ptevalcom.environment}</td>
				<td>${sessionScope.ptevalcom.incline}</td>
				<td>${sessionScope.ptevalcom.opinion}</td>
			</tr>
		</table>

		<br> <br> 

		<hr>
		<p>

			<br>
			<c:choose>
				<c:when test="${sessionScope.type == 2 && sessionScope.id == sessionScope.ptevalcom.userid.userid}">
					<button type="button"
						onclick="location.href='${pageContext.request.contextPath}/workman?evalnum=${sessionScope.ptevalcom.evalnum}&command=ptevalupdatereq'">
						수정하기</button>
					<br>
					<button type="button"
						onclick="location.href='${pageContext.request.contextPath}/workman?evalnum=${sessionScope.ptevalcom.evalnum}&command=ptevaldelete'">
						삭제하기</button>
				</c:when>
				
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			
			<br>
		<hr>

	</center>
</body>
</html>