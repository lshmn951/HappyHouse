<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<title>HappyHouse 회원가입</title>
</head>
<body>
<%@ include file="/WEB-INF/views/tempNav.jsp" %>
<section id="breadcrumbs" class="breadcrumbs">
 <div class="container">

        <ol>
          <li><a href="${root }/">Home</a></li>
          <li><a href="${root }/user/signup">회원가입</a></li>
        </ol>
       
      </div>
 </section>
 <section id="blog" class="blog">
<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<h2>회원 가입 페이지</h2>
		<form id="memberform" method="post" action="${root}/user/signup">
			<div class="form-group" align="left">
				<label for="userid">아이디</label>
				<input type="text" class="form-control" id="userid" name="userid" required="required">
			</div>
			<div class="form-group" align="left">
				<label for="userpw">비밀번호</label>
				<input type="password" class="form-control" id="userpw" name="userpw" required="required">
			</div>
			<div class="form-group" align="left">
				<label for="username">이름</label>
				<input type="text" class="form-control" id="username" name="username" required="required">
			</div>
			<div class="form-group" align="left">
				<label for="address">주소</label>
				<input type="text" class="form-control" id="address" name="address" required="required">
			</div>
			<div class="form-group" align="left">
				<label for="phone">전화번호</label>
				<input type="text" class="form-control" id="phone" name="phone" required="required">
			</div>
		
			<div class="form-group" align="center">
				<button type="reset" class="btn btn-warning">초기화</button>
				<input class="btn btn-primary" type="submit" value="가입">
			</div>
			
		</form>
	</div>
</div>
</section>
<footer id="footer">


    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong><span>Anyar</span></strong>. All Rights Reserved
      </div>
      <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/anyar-free-multipurpose-one-page-bootstrap-theme/ -->
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
        <br>this page Made by 고영욱 이성현
      </div>
    </div>
  </footer><!-- End Footer -->
</body>
</html>