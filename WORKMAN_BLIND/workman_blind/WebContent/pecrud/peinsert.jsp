<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>



<html>
<head>
<style>
.fun-btn {
  background-color: #A840FF;
  color: white;
  padding: 2em 3em;
  border: none;
  transition: all .3s ease;
  border-radius: 5px;
  letter-spacing: 2px;
  text-transform: uppercase;
  outline: none;
  align-self: center;
  cursor: pointer;
  font-weight: bold;
}
</style>
<meta charset="utf-8">
<title>세상 모든 알바! Workman</title>
<meta name="description"
	content="A pure CSS library to beautify the checkbox and radio buttons ">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- 
<base href="https://lokesh-coder.github.io/pretty-checkbox/"> -->
<meta name="viewport" content="width=device-width,initial-scale=1">



<meta name="theme-color" content="#8033b0">



<!-- ANIMATE CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">

<!-- PRETTY CHECKBOX -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/pretty-checkbox@3.0/dist/pretty-checkbox.min.css">
<!-- BOOTSTRAP -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<!-- APP -->
<link rel="stylesheet" href="stylesheets/app.css">

</head>
<body>
	<div class="jumbotron jumbotron-fluid mb-0 text-center"
		style="background-color: #9053c7;">
		<div class="container">
			<h1 class="brand" style="color: #fff">
				<strong><i>${sessionScope.comname}</i></strong>
			</h1>
			<br>
			<p style="color: #fff">
				<strong>당신의 솔직한 이야기를 들려주세요!</strong>
			</p>

		</div>
	</div>

	<br>
	<br>
	<br>
	<form action="${pageContext.request.contextPath}/workman" method="post">
		<div class="container">
			<div class="col-md-8 mx-auto">


				<section class="section" id="colors">
					<h5 class="mb-3">
						<strong><i>Pros and Cons</i></strong>
					</h5>
					<br>
					<div class="content">
						<div class="block card mb-3">
							<div
								class="card-header bg-transparent d-flex justify-content-between">
								<h6 class="mb-0">해당 기업에서 일할 때 어떤 점이 좋고 나빴나요?</h6>
							</div>

							<div class="card-body">

								<div class="pretty p-default">
									<input type="checkbox" id="proscons" name="proscons"
										value="휴식시간 많음">
									<div class="state p-success">
										<label>휴식시간 많음</label>
									</div>
								</div>

								<div class="pretty p-default">
									<input type="checkbox" id="proscons" name="proscons"
										value="휴식시간 적음">
									<div class="state p-danger">
										<label>휴식시간 적음</label>
									</div>
								</div>

								<div class="pretty p-default">
									<input type="checkbox" id="proscons" name="proscons"
										value="칼퇴근 가능">
									<div class="state p-success">
										<label>칼퇴근 가능</label>
									</div>
								</div>

								<div class="pretty p-default">
									<input type="checkbox" id="proscons" name="proscons"
										value="칼퇴근 어려움">
									<div class="state p-danger">
										<label>칼퇴근 어려움</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>

				<br> <br>

				<section class="section" id="colors">
					<h5 class="mb-3">
						<strong><i>Wage</i></strong>
					</h5>
					<br>
					<div class="content">
						<div class="block card mb-3">
							<div
								class="card-header bg-transparent d-flex justify-content-between">
								<h6 class="mb-0">임금에 관해서 만족하셨나요?</h6>
							</div>

							<div class="card-body">

								<div class="pretty p-default">
									<input type="checkbox" id="wagedelay" name="wagedelay"
										value="급여일 준수">
									<div class="state p-success">
										<label>급여일 준수</label>
									</div>
								</div>

								<div class="pretty p-default">
									<input type="checkbox" id="wagedelay" name="wagedelay"
										value="급여일 미준수">
									<div class="state p-danger">
										<label>급여일 미준수</label>
									</div>
								</div>

								<div class="pretty p-default">
									<input type="checkbox" id="wagedelay" name="wagedelay"
										value="높은 급여">
									<div class="state p-success">
										<label>높은 급여</label>
									</div>
								</div>

								<div class="pretty p-default">
									<input type="checkbox" id="wagedelay" name="wagedelay"
										value="낮은 급여">
									<div class="state p-danger">
										<label>낮은 급여</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>

				<br> <br>

				<section class="section" id="colors">
					<h5 class="mb-3">
						<strong><i>Environment</i></strong>
					</h5>
					<br>
					<div class="content">
						<div class="block card mb-3">
							<div
								class="card-header bg-transparent d-flex justify-content-between">
								<h6 class="mb-0">그곳의 근무환경은 어땠나요?</h6>
							</div>

							<div class="card-body">

								<div class="pretty p-default">
									<input type="checkbox" id="environment" name="environment"
										value="쾌적한 근무환경">
									<div class="state p-success">
										<label>쾌적한 근무환경</label>
									</div>
								</div>

								<div class="pretty p-default">
									<input type="checkbox" id="environment" name="environment"
										value="지저분한 근무환경">
									<div class="state p-danger">
										<label>지저분한 근무환경</label>
									</div>
								</div>

								<div class="pretty p-default">
									<input type="checkbox" id="environment" name="environment"
										value="텃세 없음">
									<div class="state p-success">
										<label>텃세 없음</label>
									</div>
								</div>

								<div class="pretty p-default">
									<input type="checkbox" id="environment" name="environment"
										value="텃세 심함">
									<div class="state p-danger">
										<label>텃세 심함</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>

				<br> <br>

				<section class="section" id="colors">
					<h5 class="mb-3">
						<strong><i>Incline</i></strong>
					</h5>
					<br>
					<div class="content">
						<div class="block card mb-3">
							<div
								class="card-header bg-transparent d-flex justify-content-between">
								<h6 class="mb-0">관리자의 성향은 어땠나요?</h6>
							</div>

							<div class="card-body">

								<div class="pretty p-default">
									<input type="checkbox" id="incline" name="incline" value="친절함">
									<div class="state p-success">
										<label>친절함</label>
									</div>
								</div>

								<div class="pretty p-default">
									<input type="checkbox" id="incline" name="incline" value="불친절함">
									<div class="state p-danger">
										<label>불친절함</label>
									</div>
								</div>

								<div class="pretty p-default">
									<input type="checkbox" id="incline" name="incline"
										value="신세대 스타일">
									<div class="state p-success">
										<label>신세대 스타일</label>
									</div>
								</div>

								<div class="pretty p-default">
									<input type="checkbox" id="incline" name="incline"
										value="꼰대 스타일">
									<div class="state p-danger">
										<label>꼰대 스타일</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>

				<br>
				<br>

				<div class="form-outline">
					<div class="state p-danger">
						<label><strong><i>Opinion</i></strong></label>
					</div>
					<br> <input type="text" id="form1" class="form-control"
						name="opinion" />
				</div>

			</div>
		</div>
		<br>
		<br> <input type="hidden" name="command" value="ptevalinsert">
		<input type="hidden" name="userid" value="${sessionScope.id}">
		<input type="hidden" name="companyname"
			value="${sessionScope.comname}">
		<center>	

			<button type="submit" class = "fun-btn">알바 평가글 등록</button>

		</center>

	</form>
	<br>


	<div class="footer text-center">
		<i>멋진 리뷰 감사합니다 ❤</i>
	</div>
	<div id="toggle-all" class="hide" data-module="toggleall">
		<div class="pretty p-svg p-toggle p-plain">
			<input type="checkbox">
			<div class="state p-off">
				<span class="svg"><svg xmlns="http://www.w3.org/2000/svg"
						width="24" height="24" viewBox="0 0 24 24" fill="none"
						stroke="currentColor" stroke-width="2" stroke-linecap="round"
						stroke-linejoin="round" class="feather feather-square">
						<rect x="3" y="3" width="18" height="18" rx="2" ry="2"></rect></svg> </span><label></label>
			</div>
			<div class="state p-on">
				<span class="svg"><svg xmlns="http://www.w3.org/2000/svg"
						width="24" height="24" viewBox="0 0 24 24" fill="none"
						stroke="currentColor" stroke-width="2" stroke-linecap="round"
						stroke-linejoin="round" class="feather feather-check-square">
						<polyline points="9 11 12 14 22 4"></polyline>
						<path
							d="M21 12v7a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h11"></path></svg>
				</span><label></label>
			</div>
		</div>
	</div>
	<script>if ('serviceWorker' in navigator) {
      window.addEventListener('load', () => {
        navigator.serviceWorker.register('./ngsw-worker.js')
          .then(reg => {
            console.log('[App] Successful service worker registration', reg);
          })
          .catch(err =>
            console.error('[App] Service worker registration failed', err)
          );
      });
    }</script>
	<!-- UIKITS -->
	<script defer="defer"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script defer="defer"
		src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-beta.30/js/uikit.min.js"></script>
	<script defer="defer"
		src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-beta.30/js/uikit-icons.min.js"></script>
	<script defer="defer"
		src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.8.1/prism.min.js"></script>
	<script defer="defer"
		src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.8.1/components/prism-bash.min.js"></script>
	<script defer="defer"
		src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.8.1/components/prism-scss.min.js"></script>
	<script defer="defer" src="//platform.twitter.com/widgets.js"
		charset="utf-8"></script>
	<script defer="defer" src="https://buttons.github.io/buttons.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
	<script>feather.replace()</script>
	<script src="javascripts/app.js"></script>
	<iframe scrolling="no" frameborder="0" allowtransparency="true"
		src="https://platform.twitter.com/widgets/widget_iframe.96fd96193cc66c3e11d4c5e4c7c7ec97.html?origin=https%3A%2F%2Flokesh-coder.github.io"
		title="Twitter settings iframe" style="display: none;"></iframe>
	<iframe id="rufous-sandbox" scrolling="no" frameborder="0"
		allowtransparency="true" allowfullscreen="true"
		style="position: absolute; visibility: hidden; display: none; width: 0px; height: 0px; padding: 0px; border: none;"
		title="Twitter analytics iframe"></iframe>
</body>
</html>














