<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>HappyHouse 공지사항 목록</title>

</head>
<body>
	<%@ include file="/WEB-INF/views/tempNav.jsp" %>
<section id="breadcrumbs" class="breadcrumbs">
 <div class="container">

        <ol>
          <li><a href="${root}/">Home</a></li>
          <li><a href="${root}/notice/list">공지사항</a></li>
        </ol>
       
      </div>
 </section>
 <section id="blog" class="blog">
		<div class="container" align="center">
			<div align="center">
				<h2>공지사항 목록</h2>
				<h2>${msg}</h2>
				<table class="table table-bordered table-hover">
					<tr>
						<th>번호</th>
						<th>제목</th>
					</tr>
					<c:forEach var="notice" items="${notices}"> 
						<tr>
							<td width="80"><a href="${root}/notice/detail/${notice.no}">${notice.no}</a>
							<td width="300">${notice.subject}</td>
						</tr>
					</c:forEach>
				</table>
				<c:if test="${userInfo.userId eq \"admin\"}">
				<br>
				<br>
					<a href="${root}/notice/mvregist" role="button" class="btn btn-primary">등록</a>
				</c:if>
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