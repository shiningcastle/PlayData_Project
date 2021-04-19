<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<title>Table V01</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/images/icons/home.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/util.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css">
<!--===============================================================================================-->

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link
	href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900"
	rel="stylesheet">

<!-- Additional Header CSS Files -->
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Quicksand:400,700|Questrial"
	rel="stylesheet" />
<link rel="stylesheet"
	type="${pageContext.request.contextPath}/text/css"
	href="assets/css/bootstrap.min.css">

<link rel="stylesheet"
	type="${pageContext.request.contextPath}/text/css"
	href="assets/css/font-awesome.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/templatemo-softy-pinko.css">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

</head>
<body>


	<!-- ***** Preloader Start ***** -->
	<!--     <div id="preloader">
        <div class="jumper">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>   -->


	<!-- ***** Header Area Start ***** -->
	<header class="header-area header-sticky">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<nav class="main-nav">
						<!-- ***** Logo Start ***** -->
						<a href="#" class="logo"> <img
							src="${pageContext.request.contextPath}/assets/images/pinklogo.PNG"
							alt="Softy Pinko" width="120" height="50" />
						</a>
						<!-- ***** Logo End ***** -->
						<!-- ***** Menu Start ***** -->
						<ul class="nav">
							<li><a href="main.jsp" class="active">홈</a></li>
							<li><a href="#work-process">기업스토리</a></li>
							<li><a href="workman?command=ptlistall" class="id"
								accesskey="3" title="">알바 리스트</a></li>
							<li><a href="partTimeListView2.jsp" accesskey="1"
								title="parttimestory">알바 리뷰</a></li>
							<li><a href="#blog">이력서 등록/관리</a></li>
							<li><a href="#contact-us">지원관리</a></li>
						</ul>
						<a class='menu-trigger'> <span>Menu</span>
						</a>
						<!-- ***** Menu End ***** -->
					</nav>
				</div>
			</div>
		</div>
	</header>
	<!-- ***** Header Area End ***** -->


	<c:choose>
		<c:when test="${sessionScope.type == 1}">
			<div class="navi" style="font-color: gray">
				<p style="background: linear-gradient(-135deg, #c850c0, #4158d0);text-align: right;">
					<a href="workman?command=companyupdatereq" class="id"><i
						class="fa fa-gamepad" style="font-size: 30px; color: grey;"></i>${sessionScope.id}</a>
					(기업 회원)님 &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <i
						class="fas fa-sign-out-alt" style="font-size: 30px; color: grey;"></i>
					<a href="workman?command=logout" class="logout">[로그아웃]</a>&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;<br>
				</p>
			</div>
		</c:when>


		<c:otherwise>
			<div class="navi" style="font-color: gray">
				<p style="text-align: right;">
					<a href="workman?command=memberupdatereq" class="id"><i
						class="far fa-user" style="font-size: 25px; color: black;"></i>${sessionScope.id}</a>
					(일반 회원)님 &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <i
						class="fas fa-sign-out-alt" style="font-size: 30px; color: black;"></i>
					<a href="workman?command=logout" class="logout">[로그아웃]</a>&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;<br>
				</p>
			</div>
		</c:otherwise>
	</c:choose>


	<div class="limiter">

		<div class="container-table100">
			<div class="wrap-table100">
				<center>
					<img src="${pageContext.request.contextPath}/images/알바리뷰.jpg" border="0" width="1120px" height="250px" style="margin-bottom: 100px">
				</center>
				<div class="table100">
				
				
				
				
				<div align="right">
				
				<c:choose>
					<c:when
						test="${sessionScope.type == 2 && sessionScope.comname == sessionScope.company.companyname}">
						<!--  	<a href="plinsert.jsp">알바 구인글 작성 (기업)</a> -->
						<button type="button" onclick="location.href='pecrud/peinsert.jsp'" style="color: white; font-weight: bold; margin-bottom: 20px;">알바리뷰 글 작성</button>
						<br>
					</c:when>
					<c:otherwise>
					</c:otherwise>

				</c:choose>

				<br>

				</div>
			
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">글번호</th>
								<th class="column2">작성자ID</th>
								<th class="column3">장단점</th>
								<th class="column4">급여 지불</th>
								<th class="column5">근무 환경</th>
								<th class="column6">관리자 성향</th>
								<th class="column7">추가의견</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="list" items="${sessionScope.ptevalallcom}"
								varStatus="status">
								<tr>
									<td class="column2"><a href="workman?command=ptevalcom&evalnum=${list.evalnum}">${list.evalnum}</a></td>
									<td class="column3">${list.userid.userid}</td>
									<td class="column4">${list.proscons}</td>
									<td class="column5">${list.wagedelay}</td>
									<td class="column6">${list.environment}</td>
									<td class="column7">${list.incline}</td>
									<td class="column7">${list.opinion}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<br>
					<c:choose>
						<c:when
							test="${sessionScope.id == sessionScope.company.companyname}">
							<a href="plcrud/plupdate.jsp">해당 글 수정</a> &nbsp;
							<a
								href="workman?command=ptlistdelete&listnum=${sessionScope.ptlist.listnum}">해당건
								마감</a>
						</c:when>
						<c:otherwise>

						</c:otherwise>

					</c:choose>
					<br>
					<hr>
					<a
						href="workman?command=ptevalallcom&companyname=${sessionScope.company.companyname}"
						style="color: white; font-weight: bold;"> 기업 알바 리뷰 </a>
					&nbsp;&nbsp;&nbsp;<a
						href="${pageContext.request.contextPath}/main.jsp"
						style="color: white; font-weight: bold;">메인 화면 이동</a>

				</div>
			</div>
		</div>
	</div>

	<!-- 페이징 -->
		<script type="text/javascript">
			getPagingJob(1, 208662, 20, 10, "");
		</script>
		<div class="pagenation img img4">
			<span class="page"><a href="?page=1&amp;pagesize=20"
				class="on">1</a><a href="?page=2&amp;pagesize=20">2</a><a
				href="?page=3&amp;pagesize=20">3</a><a
				href="?page=4&amp;pagesize=20">4</a><a
				href="?page=5&amp;pagesize=20">5</a><a
				href="?page=6&amp;pagesize=20">6</a><a
				href="?page=7&amp;pagesize=20">7</a><a
				href="?page=8&amp;pagesize=20">8</a><a
				href="?page=9&amp;pagesize=20">9</a><a
				href="?page=10&amp;pagesize=20">10</a></span><span class="total"
				onclick="$(this).toggleClass('oneBtn');"><span
				class="totalBtn"><span class="state">1 / 10434</span><a
					href="?page=1&amp;pagesize=20" class="first">맨 처음으로</a></span></span><span
				class="pageBtn"><a href="?page=11&amp;pagesize=20"
				class="next">&gt;</a> </span>
		</div>
		<!-- //페이징 -->


	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap/js/popper.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/js/main.js"></script>

   
</body>
</html>