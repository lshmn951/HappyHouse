
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

	<style>
		label{padding-right:20px}
	</style>
</head>
<body>
<br>
	<h1 align="center">거래 목록 </h1>

	<div class = "container" align="center">
	<br>
	<form>
		<table border='1' id="houselist_table">
		<thead>
			<tr>
				<th>&nbsp 식별 번호 &nbsp </th>
				<th>&nbsp 법정동 &nbsp</th>
				<th>&nbsp 아파트 이름 &nbsp</th>
				<th>&nbsp 지번 &nbsp</th>
				<th>&nbsp 실거래가 &nbsp</th>
		
			</tr>
		</thead>
		<tbody id="searchResult">
		</tbody>
		</table>
	</form>
	</div>
</body>
</html>
