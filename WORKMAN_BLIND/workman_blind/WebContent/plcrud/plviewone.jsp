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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900" rel="stylesheet">

<!-- Additional Header CSS Files -->
    <link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Quicksand:400,700|Questrial"
	rel="stylesheet" />
    <link rel="stylesheet" type="${pageContext.request.contextPath}/text/css" href="assets/css/bootstrap.min.css">

    <link rel="stylesheet" type="${pageContext.request.contextPath}/text/css" href="assets/css/font-awesome.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/templatemo-softy-pinko.css">
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
                        <a href="#" class="logo">
                            <img src="${pageContext.request.contextPath}/assets/images/pinklogo.PNG" alt="Softy Pinko" width="120" height="50"/>
                        </a>
                        <!-- ***** Logo End ***** -->
                        <!-- ***** Menu Start ***** -->
                        <ul class="nav">
                            <li><a href="main.jsp" class="active">홈</a></li>
                            <li><a href="#work-process">기업스토리</a></li>
                            <li><a href="workman?command=ptlistall" class="id" accesskey="3" title="">알바 리스트</a></li>
                            <li><a href="partTimeListView2.jsp" accesskey="1" title="parttimestory">알바 리뷰</a></li>
                            <li><a href="#blog">이력서 등록/관리</a></li>
                            <li><a href="#contact-us">지원관리</a></li>
                        </ul>
                        <a class='menu-trigger'>
                            <span>Menu</span>
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
				<p style="text-align: right;">
					<a href="workman?command=companyupdatereq" class="id"><i
						class="fa fa-gamepad" style="font-size: 30px; color: grey;"></i>${sessionScope.id}</a>
					(기업 회원)님 &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <i class="fas fa-sign-out-alt" style="font-size: 30px; color: grey;"></i>
					<a href="workman?command=logout" class="logout">[로그아웃]</a>&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;<br>
				</p>
			</div>
		</c:when>
		

		<c:otherwise>
			<div class="navi" style="font-color: gray">
				<p style="text-align: right;">
					<a href="workman?command=memberupdatereq" class="id"><i class="far fa-user" style="font-size: 25px; color: black;"></i>${sessionScope.id}</a>
					(일반 회원)님 &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <i class="fas fa-sign-out-alt" style="font-size: 30px; color: black;"></i>
					<a href="workman?command=logout" class="logout">[로그아웃]</a>&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;<br>
				</p>
			</div>
		</c:otherwise>
	</c:choose>

	
	<div class="limiter">
		
		<div class="container-table100">
			<div class="wrap-table100">
			<div class="heading albaRepute" style="width: 1120px; height: 180px; background-image: url(//image.alba.kr/story/top_repute.png); margin-bottom: 100px; margin-bottom: 100px;"></div>
				<div class="table100">
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">업종</th>
								<th class="column2">기업명</th>
								<th class="column3">근무기간</th>
								<th class="column4">근무시간</th>
								<th class="column5">시급</th>
								<th class="column6">주소</th>
								<th class="column7">연락처</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="column1">${sessionScope.company.category}</td>
								<td class="column2" onclick="location.href='workman?command=ptevalallcom&companyname=${sessionScope.company.companyname}'">${sessionScope.company.companyname}</td>
								<td class="column3">${sessionScope.ptlist.workperiod}</td>
								<td class="column4">${sessionScope.ptlist.worktime}</td>
								<td class="column5">${sessionScope.ptlist.hourlywage}</td>
								<td class="column6">${sessionScope.company.companyloc}</td>
								<td class="column7">${sessionScope.company.companynum}</td>
							</tr>
						</tbody>
					</table>
					<br>
					<c:choose>
						<c:when
							test="${sessionScope.id == sessionScope.company.companyname}">
						<center>	<a href="plcrud/plupdate.jsp" style = "color: #fff;">해당 글 수정</a> &nbsp;
							<a href="workman?command=ptlistdelete&listnum=${sessionScope.ptlist.listnum}" style = "color: #fff;">해당 글 마감</a></center>
						</c:when>
						<c:otherwise>

						</c:otherwise>

					</c:choose>
					<br>
					<hr>
					<a href="workman?command=ptevalallcom&companyname=${sessionScope.company.companyname}" style="color: white;
    				font-weight: bold;">
					기업 알바 리뷰 </a> &nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/main.jsp"style="color: white;
    				font-weight: bold;">메인 화면 이동</a>

				</div>
			</div>
		</div>
	</div>




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