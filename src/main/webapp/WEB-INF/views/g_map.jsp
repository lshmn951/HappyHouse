<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>g_map6</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		
			<div class="card col-sm-12" >
				<div class="card-body">

<!-- here start -->
<script>
let colorArr = ['table-primary','table-success','table-danger'];
$(document).ready(function(){
	$.get("${pageContext.request.contextPath}/FSelectBoxController/sido"
		,function(result){
			console.log(result);
			$.each(result.data, function(index, vo) {
				$("#sido").append("<option value='"+vo.sido_code+"'>"+vo.sido_name+"</option>");
			});//each
		}//function
		, "json"
	);//get
});//ready
$(document).ready(function(){
	$("#sido").change(function() {
		$.get("${pageContext.request.contextPath}/FSelectBoxController/gugun"
				,{ sido:$("#sido").val()}
				,function(result){
					$("#gugun").empty();
					$("#gugun").append('<option value="0">선택</option>');
					$.each(result.data, function(index, vo) {
						$("#gugun").append("<option value='"+vo.gugun_code+"'>"+vo.gugun_name+"</option>");
					});//each
				}//function
				, "json"
		);//get
	});//change
	$("#gugun").change(function() {
		$.get("${pageContext.request.contextPath}/FSelectBoxController/dong"
				,{ gugun:$("#gugun").val()}
				,function(result){
					$("#dong").empty();
					$("#dong").append('<option value="0">선택</option>');
					$.each(result.data, function(index, vo) {
						$("#dong").append("<option value='"+vo.dong+"'>"+vo.dong+"</option>");
					});//each
				}//function
				, "json"
		);//get
	});//change
	$("#dong").change(function() {
		$.get("${pageContext.request.contextPath}/FSelectBoxController/apt"
				,{ dong:$("#dong").val()}
				,function(result){
					$("#searchResult").empty();
					$.each(result.data, function(index, vo) {
						let str = "<tr class="+colorArr[index%3]+">"
						+ "<td><a href=\"${pageContext.request.contextPath}/detail?no="+vo.no+"\">" + vo.no + "</td>"
						+ "<td>" + vo.dong + "</td>"
						+ "<td>" + vo.AptName + "</td>"
						+ "<td>" + vo.jibun + "</td>"
						+ "<td>" + vo.dealAmount + "</td>";
						$("#searchResult").append(str);
					});//each
					geocode(result.data,true);
				}//function
				, "json"
		);//get
	});//change
		
});//ready
function geocode(jsonData,flag) {
	console.log(jsonData);

	let idx = 0;
	if(flag == true){
		initMap();
	}
	$.each(jsonData, function(index, vo) {
		let tmpLat;
		let tmpLng;
		$.get("https://maps.googleapis.com/maps/api/geocode/json"
				,{	key:"(my-google-key)"
					, address:vo.dong+"+"+vo.AptName+"+"+vo.jibun
				}
				, function(data, status) {
					console.log(data);
					//alert(data.results[0].geometry.location.lat);
					tmpLat = data.results[0].geometry.location.lat;
					tmpLng = data.results[0].geometry.location.lng;
					$("#lat_"+index).text(tmpLat);
					$("#lng_"+index).text(tmpLng);
					addMarker(tmpLat, tmpLng, vo.AptName,vo.dong);
				}
				, "json"
		);//get
	});//each
}
</script>
시도 : <select id="sido">
	<option value="0">선택</option>
</select>
구군 : <select id="gugun">
	<option value="0">선택</option>
</select>
읍면동 : <select id="dong">
	<option value="0">선택</option>
</select>
<table class="table mt-2">
	<thead>
	</thead>
	<tbody >
	</tbody>
</table>
<!-- here end -->
<!-- map start -->
<div id="map" style="width: 100%; height: 500px; margin: auto;"></div>
<script src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
<script async="" defer="" src="https://maps.googleapis.com/maps/api/js?key=(my-google-key)&libraries=geometry&callback=initMap"></script>
<script>
	var multi = {lat: 37.5665734, lng: 126.978179};
	var map;
	var info;
	function initMap() {
		map = new google.maps.Map(document.getElementById('map'), {
			center: multi, zoom: 12
		});
		info = new google.maps.InfoWindow();
	}
	function addMarker(tmpLat, tmpLng, aptName,dong) {
		var marker = new google.maps.Marker({
			position: new google.maps.LatLng(parseFloat(tmpLat),parseFloat(tmpLng)),
			label: aptName,
			title: aptName,
			d: dong
			
		});
		marker.addListener('click', function() {
			map.setZoom(17);
			map.setCenter(marker.getPosition());
			callHouseDealInfo(this);
		});
		marker.setMap(map);
	}
	function callHouseDealInfo(maker) {
		var contentstr = "<table>";
		$.get("${pageContext.request.contextPath}/FSelectBoxController/aptDongName"
				,{ name: maker.title,dong:maker.d}
				,function(result){
					$.each(result.data, function(index, vo) {
						let str = "<tr class="+colorArr[index%3]+">"
						+ "<td><a href=\"${pageContext.request.contextPath}/detail?no="+vo.no+"\">" + vo.no + "</td>"
						+ "<td>" + vo.dong + "</td>"
						+ "<td>" + vo.AptName + "</td>"
						+ "<td>" + vo.jibun + "</td>"
						+ "<td>" + vo.dealAmount + "</td>";
						contentstr += str;
					});//each
					contentstr += "</table>";
					var infowin = new google.maps.InfoWindow({
						content: contentstr,
					});
					info.close();
					info = infowin;
					info.open(map,maker);
					
				}//function
				, "json"
		);//get
	}
</script>
<!-- map end -->

				</div>
			</div>
		
		<!-- section end -->
<!-- 		<footer class="col-ms-12 bg-dark rounded mt-1"></footer> -->
	</div>
</body>
</html>
