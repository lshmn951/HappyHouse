<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:choose>
	<c:when test="${userInfo.userId ne \"admin\"}">
		<c:set var="ro" value=" readonly"></c:set>
		<c:set var="title" value="공지사항 조회"></c:set>
	</c:when>
	<c:when test="${update==null}">
		<c:set var="ro" value=" readonly"></c:set>
		<c:set var="title" value="공지사항 조회"></c:set>
	</c:when>
	
	<c:otherwise>
		<c:set var="title" value="공지사항 수정"></c:set>
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
<title>HappyHouse 공지사항 조회</title>
</head>
<body>
<%@ include file="/WEB-INF/views/tempNav.jsp" %>
<section id="breadcrumbs" class="breadcrumbs">
 <div class="container">

        <ol>
          <li><a href="${root}/">Home</a></li>
          <li><a href="${root}/notice/list">공지사항</a></li>
          <li><a href="${root}/notice/detail">조회</a></li>
        </ol>
       
      </div>
 </section>
 <section id="blog" class="blog">
<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<h2>${title}</h2>
		<form id="noticeform" method="post" action="${root}/notice/update">
			<div class="form-group" align="left">
				<label for="no">번호:</label>
				<input type="text" class="form-control" id="no" name="no" value="${notice.no}"readonly="readonly">
			</div>
			<div class="form-group" align="left">
				<label for="subject">제목:</label>
				<input type="text" class="form-control" id="subject" name="subject" value="${notice.subject}" required="required" ${ro}>
			</div>
			<div class="form-group" align="left">
				<label for="content">내용:</label>
				<textarea class="form-control" rows="15" id="content" name="content" required="required" ${ro}>${notice.content}</textarea>
			</div>
			
		
			<div class="form-group" align="center">
				<c:choose>
					<c:when test="${userInfo.userId ne \"admin\"}">
						<a href="${root}/notice/list" role="button" class="btn btn-primary">확인</a>
					</c:when>
					<c:when test="${update==null}">
						<a href="${root}/notice/list" role="button" class="btn btn-primary">확인</a>
						<a href="${root}/notice/mvupdate/${notice.no}" role="button" class="btn btn-primary">수정</a>
					</c:when>
						
					<c:otherwise>
						<input class="btn btn-primary" type="submit" value="수정">
						<a href="${root}/notice/delete/${notice.no}" role="button" class="btn btn-primary">삭제</a>
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