<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Blog Single - Serenity Bootstrap Template</title>
<meta content="" name="descriptison">
<meta content="" name="keywords">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<link href="${root }/assets/img/favicon.png" rel="icon">
<link href="${root }/assets/img/apple-touch-icon.png" rel="apple-touch-icon">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

<link href="${root }/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${root }/assets/vendor/icofont/icofont.min.css" rel="stylesheet">
<link href="${root }/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
<link href="${root }/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
<link href="${root }/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="${root }/assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
<link href="${root }/assets/vendor/venobox/venobox.css" rel="stylesheet">
<link href="${root }/assets/vendor/aos/aos.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="${root }/assets/css/style.css" rel="stylesheet">
</head>

<body>

  <!-- ======= Top Bar ======= -->
  <div id="topbar" class="d-none d-lg-flex align-items-center fixed-top topbar-inner-pages">
    <div class="container d-flex align-items-center">
      <div class="contact-info mr-auto">
        <ul>
          <li><i class="icofont-envelope"></i><a href="mailto:contact@example.com">ssafy@ssafy.com</a></li>
          <li><i class="icofont-clock-time icofont-flip-horizontal"></i> Every 9am - 5pm</li>
        </ul>
      </div>
      
      <div class="cta">
      	<%@ include file="/WEB-INF/views/user/userinfo.jsp" %>
      </div>
    </div>
  </div>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top header-inner-pages">
    <div class="container d-flex align-items-center">

      <h1 class="logo mr-auto"><a href="${root }/" class="scrollto">HappyHouse</a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html#header" class="logo mr-auto scrollto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav class="nav-menu d-none d-lg-block">
        <ul>
          <c:if test = "${userInfo == null}">
          <li><a href="${root }/">메인화면</a></li>
          <li><a href="${root }/notice/list">공지사항</a></li>
          <li class="drop-down"><a href="">회원관리</a>
            <ul>
              <li><a href="${root }/user/searchpass">비밀번호찾기</a></li>
            </ul>
          </li>
          </c:if>
		  <c:if test = "${userInfo != null}">
		  <li><a href="${root }/">메인화면</a></li>
          <li><a href="${root }/notice/list">공지사항</a></li>
          <li><a href="${root }/QnA">QnA</a></li>
          <li class="drop-down"><a href="">회원관리</a>
            <ul>
              <li><a href="${root }/user/detail">회원정보 열람 및 수정</a></li>
            </ul>
          </li>
          </c:if>
          
        </ul>
      </nav><!-- .nav-menu -->

    </div>
  </header><!-- End Header -->
  <!-- Vendor JS Files -->
  <script src="${root }/assets/vendor/jquery/jquery.min.js"></script>
  <script src="${root }/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${root }/assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="${root }/assets/vendor/php-email-form/validate.js"></script>
  <script src="${root }/assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="${root }/assets/vendor/venobox/venobox.min.js"></script>
  <script src="${root }/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="${root }/assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="${root }/assets/js/main.js"></script>
</body>
<!-- Vendor JS Files -->
</html>