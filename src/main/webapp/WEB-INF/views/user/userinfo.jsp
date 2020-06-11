<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="col-lg-18" align="right">
	<c:if test="${userInfo == null}">
		${msg}
		<a href="${root}/user/mvsignup" >회원가입</a>
        <a href="${root}/user/mvlogin" class="button">로그인</a>
	</c:if>
	<c:if test="${userInfo != null}">
    	${userInfo.userName} 님 로그인 되었습니다.
    	<a href="${root}/user/logout" class="button">로그아웃</a>
	</c:if>
		
	<br>
	<br>
</div>
</body>
</html>