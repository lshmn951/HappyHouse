<%@ page language="java" contentType="text/html; charset=UTF-8" %>
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
<title>HappyHouse 로그인</title>
</head>
<body>
<%@ include file="/WEB-INF/views/tempNav.jsp" %>
<section id="breadcrumbs" class="breadcrumbs">
 <div class="container">

        <ol>
          <li><a href="${root }/">Home</a></li>
          <li><a href="${root }/user/login">로그인</a></li>
        </ol>
       
      </div>
 </section>
  <section id="blog" class="blog">
<div class="container" align="center">
	<div class="col-lg-6" align="center">
	<h2>로그인 화면</h2>
	${msg}
	<form action="${root}/user/login" method="post">
		<div class="form-group" align="left">
				<label for="userid">아이디</label>
				<input type="text" class="form-control" id="userid" name="userid" required="required">
			</div>
			<div class="form-group" align="left">
				<label for="userpw">비밀번호</label>
				<input type="password" class="form-control" id="userpw" name="userpw" required="required">
			</div>
		<input class="btn btn-primary" type="submit" value="로그인">
		<a href="${root}/user/mvsearchpass" role="button" class="btn btn-primary">비밀번호찾기</a>
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