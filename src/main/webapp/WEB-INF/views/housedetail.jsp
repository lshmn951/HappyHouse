<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<main id="main">
<%@ include file="/WEB-INF/views/tempNav.jsp" %>
 <section id="breadcrumbs" class="breadcrumbs">
 <div class="container">

        <ol>
          <li><a href="/WEB-INF/views/initMain.jsp">Home</a></li>
          <li><a href="/WEB-INF/views/housedetail.jsp">detail</a></li>
        </ol>
       
      </div>
 </section>
<section id="blog" class="blog">
	<h1 align="center">상세 정보 </h1>

	<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
	<div class ="container" align="center" >
	<img src ="${root }/img/${src}" onerror="this.src="${root }/img/다세대주택.jpg>
	<h2>조회한 건물 정보</h2>
	<c:choose>
		<c:when test="${!empty housedeals }">
		<div align="left" style ="border :3px dotted green; width: 600px; height: 320px " >
			<p> 1. 식별 번호 : ${houseinfo.no }</p>
			<p> 2. 법정동 명 : ${housedeals.dong }</p>
			<p> 3. 아파트 이름 : ${housedeals.aptName }</p>
			<p> 4. 법정동 코드 : ${housedeals.code }</p>
			<p> 5. 건축 년도 : ${housedeals.buildYear }</p>
			<p> 6. 거래 가격 : ${housedeals.dealAmount }</p>
			<p> 7. 지번 주소 : ${housedeals.jibun }</p>
			<p> 8. 거래 정보 : ${housedeals.type }</p>
		</div>	
		</c:when>
		<c:otherwise>
			<p>건물 정보가 없습니다.</p>
		</c:otherwise>
	</c:choose>
	<br>
	</div>
	
	</section>
</main>
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