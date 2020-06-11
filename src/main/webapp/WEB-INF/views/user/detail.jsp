<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<c:choose>
	<c:when test="${update==null}">
		<c:set var="ro" value=" readonly"></c:set>
		<c:set var="title" value="마이 페이지"></c:set>
		<c:set var="pw" value="text"></c:set>
	</c:when>
	
	<c:otherwise>
		<c:set var="title" value="회원 정보 수정"></c:set>
		<c:set var="pw" value="password"></c:set>
	</c:otherwise>
</c:choose>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<title>HappyHouse 회원정보 조회</title>
</head>
<body>

<%@ include file="/WEB-INF/views/tempNav.jsp" %>
<section id="breadcrumbs" class="breadcrumbs">
 <div class="container">

        <ol>
          <li><a href="${root }/">Home</a></li>
          <li><a href="${root }/user/detail">회원 정보</a></li>
        </ol>
       
      </div>
 </section>
 <section id="blog" class="blog">
<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<h2>${title}</h2>
		<form id="memberform" method="post" action="${root}/user/update">
			<div class="form-group" align="left">
				<label for="userid">아이디</label>
				<input type="text" class="form-control" id="userid" name="userid" value="${userInfo.userId}" readonly="readonly">
			</div>
			<div class="form-group" align="left">
				<label for="userpw">비밀번호</label>
				<input type="${pw}" class="form-control" id="userpw" name="userpw" value="${userInfo.userPw}" required="required" ${ro}>
			</div>
			<div class="form-group" align="left">
				<label for="username">이름</label>
				<input type="text" class="form-control" id="username" name="username" value="${userInfo.userName}" required="required" ${ro}>
			</div>
			<div class="form-group" align="left">
				<label for="address">주소</label>
				<input type="text" class="form-control" id="address" name="address" value="${userInfo.address}" required="required" ${ro}>
			</div>
			<div class="form-group" align="left">
				<label for="phone">전화번호</label>
				<input type="text" class="form-control" id="phone" name="phone" value="${userInfo.phone}" required="required" ${ro}>
			</div>
		
			<div class="form-group" align="center">
			<c:choose>
				<c:when test="${update==null}">
					<a href="${root}/" role="button" class="btn btn-primary">확인</a>
					<a href="${root}/user/mvupdate/${userInfo.userId}" role="button" class="btn btn-primary">수정</a>
				</c:when>
				<c:otherwise>
					<input class="btn btn-primary" type="submit" value="수정">
					<a href="${root}/user/withdraw/${userInfo.userId}" role="button" class="btn btn-primary">회원 탈퇴</a>
				</c:otherwise>
			</c:choose>
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