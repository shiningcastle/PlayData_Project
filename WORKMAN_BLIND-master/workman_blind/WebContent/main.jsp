<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link
   href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900"
   rel="stylesheet">

<title>Softy Pinko - Bootstrap 4.0 Theme</title>
<!--
SOFTY PINKO
https://templatemo.com/tm-535-softy-pinko
-->

<!-- Additional CSS Files -->
<link
   href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Quicksand:400,700|Questrial"
   rel="stylesheet" />
<link rel="stylesheet" type="text/css"
   href="assets/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
   href="assets/css/font-awesome.css">

<link rel="stylesheet" href="assets/css/templatemo-softy-pinko.css">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>

<body>


   <!-- ***** Preloader Start ***** -->
   <div id="preloader">
      <div class="jumper">
         <div></div>
         <div></div>
         <div></div>
      </div>
   </div>
   <!-- ***** Preloader End ***** -->


   <!-- ***** Header Area Start ***** -->
   <header class="header-area header-sticky">
   <div class="myloginarea">
                     <c:choose>
                     <c:when test="${sessionScope.type == 1}">
                        <div class="navi" style="font-color: white">
                           <p style="text-align: right; color: white;">
                              <a href="workman?command=companyupdatereq" class="id"> <i
                                 class="far fa-building"
                                 style="font-size: 30px; color: white;"></i>
                                 ${sessionScope.id}
                              </a> (기업 회원)님 &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <i
                                 class="fas fa-sign-out-alt"
                                 style="font-size: 25px; color: white;"></i><a
                                 href="workman?command=logout" class="logout"
                                 style="color: white;"> [로그아웃]</a>&nbsp;
                              &nbsp;&nbsp;&nbsp;&nbsp;<br>
                           </p>
                        </div>
                     </c:when>

                     <c:otherwise>
                        <div class="navi" style="font-color: white">
                           <p style="text-align: right; color: white;">
                              <a href="workman?command=memberupdatereq" class="id"> <i
                                 class="far fa-user" style="font-size: 25px; color: white;"></i>${sessionScope.id}</a>
                              (일반 회원)님 &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <i
                                 class="fas fa-sign-out-alt"
                                 style="font-size: 25px; color: white;"></i><a
                                 href="workman?command=logout" class="logout"
                                 style="color: white;"> [로그아웃]</a>&nbsp;
                              &nbsp;&nbsp;&nbsp;&nbsp;<br>
                           </p>
                        </div>
                     </c:otherwise>

                  </c:choose></div><br>
      <div class="container">
         <div class="row">
            <div class="col-12">
               <nav class="main-nav">
                  <!-- ***** Logo Start ***** -->
                  
                  <a href="#" class="logo"> <img
                     src="assets/images/pinklogo.PNG" alt="Softy Pinko" width="120"
                     height="50" />
                  </a>
                  <!-- ***** Logo End ***** -->
                  <!-- ***** Menu Start ***** -->
                  <center><ul class="nav">
                     <li><a href="#welcome" class="active">홈</a></li>
                     <li><a href="#work-process">기업스토리</a></li>
                     <li><a href="workman?command=ptlistall" class="id"
                        accesskey="3" title="">알바 리스트</a></li>
                     <li><a href="partTimeListView2.jsp" accesskey="1"
                        title="parttimestory">알바 리뷰</a></li>
                     <li><a href="#blog">이력서 등록/관리</a></li>
                     <li><a href="#contact-us">지원관리</a></li>
                  </ul></center>
                  <a class='menu-trigger'> <span>Menu</span>
                  </a>

               

                  <!-- ***** Menu End ***** -->
               </nav>
            </div>
         </div>
      </div>
   </header>
   <!-- ***** Header Area End ***** -->

   <!-- ***** Welcome Area Start ***** -->
   <div class="welcome-area" id="welcome">

      <!-- ***** Header Text Start ***** -->
      <div class="header-text">
         <div class="container">
            <div class="row">
               <div
                  class="offset-xl-3 col-xl-6 offset-lg-2 col-lg-8 col-md-12 col-sm-12">
                  <!--  -->

<br> <br>
                  <h1>
                     워크맨은 오늘도 열심히 일하는<br>
                     <strong>당신을 </strong>응원합니다.
                  </h1>
                  <p>개미는 뚠뚠 오늘도 뚠뚠 열심히 일을 하네..</p>
                  <a href="#" class="main-button-slider" onclick="settimeoutUtube()">Discover More</a> <br> <br>
				
                  <br> <br> <br> <br> <br>
               </div>

               	<div id="utubeView" style="margin-bottom: 300px; padding-left: 272px;"></div>

            </div>
         </div>
      </div>
      <!-- ***** Header Text End ***** -->
   </div>
   <!-- ***** Welcome Area End ***** -->

   <!-- ***** Features Small Start ***** -->
   <section class="section home-feature">
      <div class="container">
         <div class="row">
            <div class="col-lg-12">
               <div class="row">
                  <!-- ***** Features Small Item Start ***** -->
                  <div class="col-lg-4 col-md-6 col-sm-6 col-12"
                     data-scroll-reveal="enter bottom move 50px over 0.6s after 0.2s">
                     <div class="features-small-item">
                        <div class="icon">
                           <i><img src="assets/images/featured-item-01.png" alt=""></i>
                        </div>
                        <h5 class="features-title">현명한 선택</h5>
                        <p>더이상 선택당하지 마세요. 이제 당신이 선택할 차례입니다. 후기를 보고 꼼꼼히 고르고 골라 최고의 알바를 선택해 지원하세요!</p>
                     </div>
                  </div>
                  <!-- ***** Features Small Item End ***** -->

                  <!-- ***** Features Small Item Start ***** -->
                  <div class="col-lg-4 col-md-6 col-sm-6 col-12"
                     data-scroll-reveal="enter bottom move 50px over 0.6s after 0.4s">
                     <div class="features-small-item">
                        <div class="icon">
                           <i><img src="assets/images/featured-item-01.png" alt=""></i>
                        </div>
                        <h5 class="features-title">최상의 관계</h5>
                        <p>근무지 사장님의 성향을 보고 나와 성격이 잘맞는 사장님으로 선택해요! 의견 충돌 제로!!</p>
                     </div>
                  </div>
                  <!-- ***** Features Small Item End ***** -->

                  <!-- ***** Features Small Item Start ***** -->
                  <div class="col-lg-4 col-md-6 col-sm-6 col-12"
                     data-scroll-reveal="enter bottom move 50px over 0.6s after 0.6s">
                     <div class="features-small-item">
                        <div class="icon">
                           <i><img src="assets/images/featured-item-01.png" alt=""></i>
                        </div>
                        <h5 class="features-title">베푼만큼 돌아오는 선행</h5>
                        <p>퇴사하셨나요? 알바 후기를 적어보세요. 잠깐의 시간을 투자해 선행을 베풀면  훗날 다시 알바를 구할때 큰 도움을 받을지도 몰라요!  </p>
                     </div>
                  </div>
                  <!-- ***** Features Small Item End ***** -->
               </div>
            </div>
         </div>
      </div>
   </section>
   <!-- ***** Features Small End ***** -->

   <!-- ***** Features Big Item Start ***** -->
   <section class="section padding-top-70 padding-bottom-0" id="features">
      <div class="container">
         <div class="row">
            <div class="col-lg-5 col-md-12 col-sm-12 align-self-center"
               data-scroll-reveal="enter left move 30px over 0.6s after 0.4s">
               <img src="assets/images/left-image.png"
                  class="rounded img-fluid d-block mx-auto" alt="App">
            </div>
            <div class="col-lg-1"></div>
            <div
               class="col-lg-6 col-md-12 col-sm-12 align-self-center mobile-top-fix">
               <div class="left-heading">
                  <h2 class="section-title">알바, 더이상 탈주하지 마세요!</h2>
               </div>
               <div class="left-text">
                  <p>
                     저희 워크맨은 해당 알바를 직접 경험해본 선배들의 생생한 후기로<br>여러분의 더욱 현명한 알바 지원을
                     도와드립니다.
                  </p>
               </div>
            </div>
         </div>
         <div class="row">
            <div class="col-lg-12">
               <div class="hr"></div>
            </div>
         </div>
      </div>
   </section>
   <!-- ***** Features Big Item End ***** -->

   <!-- ***** Features Big Item Start ***** -->
   <section class="section padding-bottom-100">
      <div class="container">
         <div class="row">
            <div
               class="col-lg-6 col-md-12 col-sm-12 align-self-center mobile-bottom-fix">
               <div class="left-heading">
                  <h2 class="section-title">이제는 이 곳 워크맨에서 구인하세요!</h2>
               </div>
               <div class="left-text">
                  <p>
                     업무가 자신이 생각했던 것과 다르다며 며칠만에 탈주하던 알바생들.. <br>이제는 없을겁니다..! <br>기업의
                     생생후기를 보고 해당 업무에 자신있는 알바생들만이 지원을 할테니까요!
                  </p>
               </div>
            </div>
            <div class="col-lg-1"></div>
            <div
               class="col-lg-5 col-md-12 col-sm-12 align-self-center mobile-bottom-fix-big"
               data-scroll-reveal="enter right move 30px over 0.6s after 0.4s">
               <img src="assets/images/right-image.png"
                  class="rounded img-fluid d-block mx-auto" alt="App">
            </div>
         </div>
      </div>
   </section>
   <!-- ***** Features Big Item End ***** -->

   <!-- ***** Home Parallax Start ***** -->
   <section class="mini" id="work-process">
      <div class="mini-content">
         <div class="container">
            <div class="row">
               <div class="offset-lg-3 col-lg-6">
                  <div class="info">
                     <h1>가입 기업</h1>
                     <p>
                        워크맨과 함께하고 있는 기업 목록입니다.<br>마음에 드는 곳을 클릭하여 지원해 보세요!
                     </p>
                  </div>
               </div>
            </div>

                <!-- ***** Mini Box Start ***** -->
            <div class="row">
               <div class="col-lg-2 col-md-3 col-sm-6 col-6">
                  <a href="#" class="mini-box"> <i><img
                        src="assets/images/pc.png" alt="" width="80" height="80"></i>
                     <strong>${sessionScope.allcompany[0].companyname}</strong> <span>${sessionScope.allcompany[0].category}</span>
                  </a>
               </div>
               <div class="col-lg-2 col-md-3 col-sm-6 col-6">
                  <a href="#" class="mini-box"> <i><img
                        src="assets/images/cu.png" alt="" width="80" height="80"></i>
                     <strong>${sessionScope.allcompany[1].companyname}</strong> <span>${sessionScope.allcompany[1].category}</span>
                  </a>
               </div>
               <div class="col-lg-2 col-md-3 col-sm-6 col-6">
                  <a href="#" class="mini-box"> <i><img
                        src="assets/images/innisfree.jpg" alt="" width="80" height="80"></i>
                     <strong>${sessionScope.allcompany[2].companyname}</strong> <span>${sessionScope.allcompany[2].category}</span>
                  </a>
               </div>
               <div class="col-lg-2 col-md-3 col-sm-6 col-6">
                  <a href="#" class="mini-box"> <i><img
                        src="assets/images/gs25.png" alt="" width="80" height="80"></i>
                     <strong>${sessionScope.allcompany[3].companyname}</strong> <span>${sessionScope.allcompany[3].category}</span>
                  </a>
               </div>
               <div class="col-lg-2 col-md-3 col-sm-6 col-6">
                  <a href="#" class="mini-box"> <i><img
                        src="assets/images/hansot.jpg" alt="" width="80" height="80"></i>
                     <strong>${sessionScope.allcompany[4].companyname}</strong> <span>${sessionScope.allcompany[4].category}</span>
                  </a>
               </div>
               <div class="col-lg-2 col-md-3 col-sm-6 col-6">
                  <a href="#" class="mini-box"> <i><img
                        src="assets/images/twosome.png" alt="" width="80" height="80"></i>
                     <strong>${sessionScope.allcompany[5].companyname}</strong> <span>${sessionScope.allcompany[5].category}</span>
                  </a>
               </div>
            </div>
            
          
         </div>
      </div>
   </section>
   <!-- ***** Home Parallax End ***** -->

   <!-- ***** Testimonials Start ***** -->
   <section class="section" id="testimonials">
      <div class="container">
         <!-- ***** Section Title Start ***** -->
         <div class="row">
            <div class="col-lg-12">
               <div class="center-heading">
                  <h2 class="section-title">What do they say?</h2>
               </div>
            </div>
            <div class="offset-lg-3 col-lg-6">
               <div class="center-text">
                  <p>지금 그 알바를 해보았던 선배들의 생생한 후기! 이 곳에서 만나보세요!</p>
               </div>
            </div>
         </div>
         <!-- ***** Section Title End ***** -->

         <div class="row">
            <!-- ***** Testimonials Item Start ***** -->
            <div class="col-lg-4 col-md-6 col-sm-12">
               <div class="team-item">
                  <div class="team-content">
                     <i><img src="assets/images/testimonial-icon.png" alt=""></i>
                     <p>먹을거는 잘 사주시지만 매니저 포함 직원들이 무섭고 군대가 따로없어요.. 업무강도도 무지무지 높습니다.
                        절대가지마세요. 월급은 안밀려요</p>
                     <div class="user-image">
                        <img src="http://placehold.it/60x60" alt="">
                     </div>
                     <div class="team-info">
                        <h3 class="user-name">moonyangels2</h3>
                        <span>올리브영 남부터미널점</span>
                     </div>
                  </div>
               </div>
            </div>
            <!-- ***** Testimonials Item End ***** -->

            <!-- ***** Testimonials Item Start ***** -->
            <div class="col-lg-4 col-md-6 col-sm-12">
               <div class="team-item">
                  <div class="team-content">
                     <i><img src="assets/images/testimonial-icon.png" alt=""></i>
                     <p>매우 꿀알바 입니다. 근무 중 개인공부 가능합니다.<br> 근데 시급이 너무짜요<br><br></p>
                     <div class="user-image">
                        <img src="http://placehold.it/60x60" alt="">
                     </div>
                     <div class="team-info">
                        <h3 class="user-name">jongwook123</h3>
                        <span>우당탕탕 독서실</span>
                     </div>
                  </div>
               </div>
            </div>
            <!-- ***** Testimonials Item End ***** -->

            <!-- ***** Testimonials Item Start ***** -->
            <div class="col-lg-4 col-md-6 col-sm-12">
               <div class="team-item">
                  <div class="team-content">
                     <i><img src="assets/images/testimonial-icon.png" alt=""></i>
                     <p>목돈벌고 탈주하기 좋은알바! <br>할만한데 장난감회사다 보니 진상이 너무 많아요<br></p>
                     <div class="user-image">
                        <img src="http://placehold.it/60x60" alt="">
                     </div>
                     <div class="team-info">
                        <h3 class="user-name">hesung789</h3>
                        <span>손오공</span>
                     </div>
                  </div>
               </div>
            </div>
            <!-- ***** Testimonials Item End ***** -->
         </div>
      </div>
   </section>
   <!-- ***** Testimonials End ***** -->

   <!-- ***** Pricing Plans Start ***** -->
   <section class="section colored" id="pricing-plans">
      <div class="container">
         <!-- ***** Section Title Start ***** -->
         <div class="row">
            <div class="col-lg-12">
               <div class="center-heading">
                  <h2 class="section-title">방금 올라온 공고!</h2>
               </div>
            </div>
            <div class="offset-lg-3 col-lg-6">
               <div class="center-text">
                  <p>Part-time jobs can help people make money to pay off debt, save for emergencies or other financial goals, 
                  or provide an extra cushion for things like hobbies, travel, or special occasions. While it’s still possible to find part-time jobs by responding to classifieds, 
                  through word of mouth, or via local flyers, it’s now faster and easier than ever to find part-time work through online job sites.</p>
               </div>
            </div>
         </div>
         <!-- ***** Section Title End ***** -->

         <div class="row">
            <!-- ***** Pricing Item Start ***** -->
            <div class="col-lg-4 col-md-6 col-sm-12"
               data-scroll-reveal="enter bottom move 50px over 0.6s after 0.2s">
               <div class="pricing-item">
                  <div class="pricing-header">
                     <h3 class="pricing-title">${sessionScope.ptlistall[0].companyname.companyname}</h3>
                  </div>
                  <div class="pricing-body">
                     <div class="price-wrapper">
                        <span class="currency">₩</span> <span class="price">${sessionScope.ptlistall[0].hourlywage}</span>
                        <span class="period">시급</span>
                     </div>
                     <ul class="list">
                        <li class="active">${sessionScope.ptlistall[0].objective}</li>
                     </ul>
                  </div>
                  <div class="pricing-footer">
                     <a class="main-button" style="color: white;" onclick="location.href='workman?command=ptlist&listnum=${sessionScope.ptlistall[0].listnum}&companyname=${sessionScope.ptlistall[0].companyname.companyname}'">더 알아보기</a>
                  </div>
               </div>
            </div>
            <!-- ***** Pricing Item End ***** -->

            <!-- ***** Pricing Item Start ***** -->
            <div class="col-lg-4 col-md-6 col-sm-12"
               data-scroll-reveal="enter bottom move 50px over 0.6s after 0.4s">
               <div class="pricing-item active">
                  <div class="pricing-header">
                     <h3 class="pricing-title">${sessionScope.ptlistall[1].companyname.companyname}</h3>
                  </div>
                  <div class="pricing-body">
                     <div class="price-wrapper">
                        <span class="currency">₩</span> <span class="price">${sessionScope.ptlistall[1].hourlywage}</span>
                        <span class="period">시급</span>
                     </div>
                     <ul class="list">
                        <li class="active">${sessionScope.ptlistall[1].objective}</li>
                     </ul>
                  </div>
                  <div class="pricing-footer">
                     <a class="main-button" style="color: white;" onclick="location.href='workman?command=ptlist&listnum=${sessionScope.ptlistall[1].listnum}&companyname=${sessionScope.ptlistall[1].companyname.companyname}'">더 알아보기</a>
                  </div>
               </div>
            </div>
            <!-- ***** Pricing Item End ***** -->

            <!-- ***** Pricing Item Start ***** -->
            <div class="col-lg-4 col-md-6 col-sm-12"
               data-scroll-reveal="enter bottom move 50px over 0.6s after 0.6s">
               <div class="pricing-item">
                  <div class="pricing-header">
                     <h3 class="pricing-title">${sessionScope.ptlistall[3].companyname.companyname}</h3>
                  </div>
                  
                  <div class="pricing-body">
                     <div class="price-wrapper">
                        <span class="currency">₩</span> <span class="price">${sessionScope.ptlistall[3].hourlywage}</span>
                        <span class="period">시급</span>
                     </div>
                     <ul class="list">
                        <li class="active">${sessionScope.ptlistall[3].objective}</li>
                     </ul>
                  </div>
                  <div class="pricing-footer">
                     <a class="main-button" style="color: white;" onclick="location.href='workman?command=ptlist&listnum=${sessionScope.ptlistall[3].listnum}&companyname=${sessionScope.ptlistall[3].companyname.companyname}'">더 알아보기</a>
                  </div>
               </div>
            </div>
            <!-- ***** Pricing Item End ***** -->
         </div>
      </div>
   </section>
   <!-- ***** Pricing Plans End ***** -->

   <!-- ***** Counter Parallax Start ***** -->
   <section class="counter">
      <div class="content">
         <div class="container">
            <div class="row">
               <div class="col-lg-3 col-md-6 col-sm-12">
                  <div class="count-item decoration-bottom">
                     <strong>126</strong> <span>오늘 올라온 후기</span>
                  </div>
               </div>
               <div class="col-lg-3 col-md-6 col-sm-12">
                  <div class="count-item decoration-top">
                     <strong>630</strong> <span>오늘 올라온 공고</span>
                  </div>
               </div>
               <div class="col-lg-3 col-md-6 col-sm-12">
                  <div class="count-item decoration-bottom">
                     <strong>180</strong> <span>오늘 가입한 회원</span>
                  </div>
               </div>
               <div class="col-lg-3 col-md-6 col-sm-12">
                  <div class="count-item">
                     <strong>270</strong> <span>오늘 매칭된 알바</span>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </section>
   <!-- ***** Counter Parallax End ***** -->



  

   <!-- ***** Footer Start ***** -->
   <footer>
      <div class="container">
         <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12">
               <ul class="social">
                  <li><a href="#"><i class="fab fa-facebook"></i></a></li>
                  <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                  <li><a href="#"><i class="fab fa-instagram"></i></a></li>
                  <li><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
                  <li><a href="#"><i class="fa fa-rss"></i></a></li>
               </ul>
            </div>
         </div>
         <div class="row">
            <div class="col-lg-12">
               <p class="copyright">WORKMAN &copy; 서울특별시 서초구 서초동 서초대로46길 42 엔코아타워 | 02-1234-5678 | workman@work.co.kr</p>
            </div>
         </div>
      </div>
   </footer>

   <!-- jQuery -->
   <script src="assets/js/jquery-2.1.0.min.js"></script>

   <!-- Bootstrap -->
   <script src="assets/js/popper.js"></script>
   <script src="assets/js/bootstrap.min.js"></script>

   <!-- Plugins -->
   <script src="assets/js/scrollreveal.min.js"></script>
   <script src="assets/js/waypoints.min.js"></script>
   <script src="assets/js/jquery.counterup.min.js"></script>
   <script src="assets/js/imgfix.min.js"></script>

   <!-- Global Init -->
   <script src="assets/js/custom.js"></script>

   <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
   <script type="text/javascript">
   
   function settimeoutUtube() {
      setTimeout(function utubeview() {
         axios.get('make', {
            params : {
               command : "utube"
            }
         }).then(response => {
            document.getElementById("utubeView").innerHTML = response.data;
         }).catch(error => {
            console.log("폼보기 에러" + error);
         });
      }, 1000);
   }
   

   
</script>
</body>
</html>