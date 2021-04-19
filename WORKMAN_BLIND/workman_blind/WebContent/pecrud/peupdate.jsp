<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
	<br>
	<br>
	<br>
	<center>

		<h3>평가글 정보 수정</h3>
		<hr>
		<p>
		<form action="${pageContext.request.contextPath}/workman"
			method="post">

			<input type="hidden" name="command" value="ptevalupdate"> <input
				type="hidden" name="evalnum"
				value="${sessionScope.peupdate.evalnum}">
			<center>${sessionScope.peupdate.companyname.companyname}</center>

			<dl class="reputeDetailList-list-dl">
				<dt>
					<span>•</span> 장단점
				</dt>
			</dl>

			<input type="checkbox" id="proscons" name="proscons" value="휴식시간 많음">
			<label for="proscons"> 휴식시간 많음</label><br> <input
				type="checkbox" id="proscons" name="proscons" value="휴식시간 적음">
			<label for="proscons"> 휴식시간 적음</label><br> <input
				type="checkbox" id="proscons" name="proscons" value="칼퇴근 가능">
			<label for="proscons"> 칼퇴근 가능</label><br> <input type="checkbox"
				id="proscons" name="proscons" value="칼퇴근 어려움"> <label
				for="proscons"> 칼퇴근 어려움</label><br>


			<dl class="reputeDetailList-list-dl">
				<dt>
					<span>•</span> 급여
				</dt>
			</dl>

			<input type="checkbox" id="wagedelay" name="wagedelay" value="급여일 준수">
			<label for="wage_delay"> 급여일 준수</label><br> <input
				type="checkbox" id="wagedelay" name="wagedelay" value="급여일 미준수">
			<label for="wage_delay"> 급여일 미준수</label><br> <input
				type="checkbox" id="wagedelay" name="wagedelay" value="높은 급여">
			<label for="wage_delay"> 높은 급여</label><br> <input
				type="checkbox" id="wagedelay" name="wagedelay" value="낮은 급여">
			<label for="wage_delay"> 낮은 급여</label><br>

			<dl class="reputeDetailList-list-dl">
				<dt>
					<span>•</span> 근무환경
				</dt>
			</dl>

			<input type="checkbox" id="environment" name="environment"
				value="깨끗한 근무환경"> <label for="environment"> 깨끗한 근무환경</label><br>
			<br> <input type="checkbox" id="environment" name="environment"
				value="지저분한 근무환경"> <label for="environment"> 지저분한
				근무환경</label><br>
			<br> <input type="checkbox" id="environment" name="environment"
				value="텃세 없음"> <label for="environment"> 텃세 없음</label><br>
			<br> <input type="checkbox" id="environment" name="environment"
				value="텃세 심함"> <label for="environment"> 텃세 심함</label><br>
			<br>

			<dl class="reputeDetailList-list-dl">
				<dt>
					<span>•</span> 관리자성향
				</dt>
			</dl>

			<input type="checkbox" id="incline" name="incline" value="친절함">
			<label for="incline"> 친절함</label><br>
			<br> <input type="checkbox" id="incline" name="incline"
				value="불친절함"> <label for="incline"> 불친절함</label><br>
			<br> <input type="checkbox" id="incline" name="incline"
				value="신세대 스타일"> <label for="incline"> 신세대 스타일</label><br>
			<br> <input type="checkbox" id="incline" name="incline"
				value="꼰대 스타일"> <label for="incline"> 꼰대 스타일</label><br>
			<br>

			<dl class="reputeDetailList-list-dl">
				<dt>
					<span>•</span> 추가의견
				</dt>
			</dl>

			<input type="text" id="opinion" name="opinion"> <br>
			<hr>
			<input type="submit" value="알바 평가글  수정"> &nbsp; <input
				type="reset" value="입력값 초기화">
		</form>

	</center>
</body>
</html>