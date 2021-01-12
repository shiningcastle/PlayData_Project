<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<title>세상 모든 알바! Workman</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- Custom Theme files -->
<link href="../css/pinsert.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- //Custom Theme files -->
<!-- web font -->
<link
	href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i"
	rel="stylesheet">
<!-- //web font -->
</head>
<body>
	<!-- main -->
	<div class="main-w3layouts wrapper">
		<h1>알바 구인 글</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
				<form action="${pageContext.request.contextPath}/workman"
					method="post">
					<input type="hidden" name="command" value="ptlistinsert"> <input
						class="text" type="text" name="companyname"
						value="${sessionScope.id}" readonly> <br> <input
						class="text" type="text" name="worktime" placeholder="근무시간"
						required=""> <br> <input class="text" type="text"
						name="hourlywage" placeholder="시급" required=""> <input
						class="text email" type="text" name="workperiod"
						placeholder="근무기간" required=""> <input class="text"
						type="text" name="objective" placeholder="목적" required="">
					<div class="wthree-text">
						<label class="anim"> <!--  	<input type="checkbox" class="checkbox" required="">
							<span>I Agree To The Terms & Conditions</span>  -->
						</label>
						<div class="clear"></div>
					</div>
					<input type="submit" value="구인글 등록">
				</form>
			</div>
		</div>
		<!-- copyright -->
		<div class="colorlibcopy-agile">
			<p>
				© 주식회사 Workman. All rights reserved </a>
			</p>
		</div>
		<!-- //copyright -->
		<ul class="colorlib-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
	<!-- //main -->
</body>
</html>