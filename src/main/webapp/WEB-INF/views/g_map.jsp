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
					maskStore();
				}//function
				, "json"
		);//get
	});//change
		
});//ready
function geocode(jsonData,flag) {

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
					//alert(data.results[0].geometry.location.lat);
					tmpLat = data.results[0].geometry.location.lat;
					tmpLng = data.results[0].geometry.location.lng;
					$("#lat_"+index).text(tmpLat);
					$("#lng_"+index).text(tmpLng);
					addMarker(tmpLat, tmpLng, vo.AptName,vo.dong);
					if(jsonData.length-1 == index){
						centerChange(tmpLat,tmpLng);
					}
				}
				, "json"
		);//get
		
	});//each
}
function maskStore(){
		var tmpLat;
		var tmpLng;
		var sc = $("#sido").val();
		var si = $("#sido option[value="+sc+"]").text();
		var gc = $("#gugun").val();
		var gu = $("#gugun option[value="+gc+"]").text();

		$.get("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/storesByAddr/json"
				,{ address:si+" "+gu+" "+$("#dong").val()
				}
				, function(data, status) {
					var name;
					var stock_at;
					var remain_stat;
					$("#maskResult").empty();
					$.each(data.stores,function(index,vo){
						tmpLat = vo.lat;
						tmpLng = vo.lng;
						addMaskMarker(tmpLat,tmpLng,vo);
						let	str = "<tr><td>" + vo.name + "</td><td>";
						if(vo.type=="01"){
							str+="약국</td>";
						}else if(vo.type=="02"){
							str+="우체국</td>";
						}else if(vo.type=="03"){
							str+="농협</td>";							
						}
						str	+= "<td>" + vo.stock_at + "</td>";
						if(vo.remain_stat=='plenty'){
							str+="<td style='color:green'>100개 이상</td>";
						}else if(vo.remain_stat=='some'){
							str+="<td style='color:yellow'>30개 이상 100개 미만</td>";
						}else if(vo.remain_stat=='few'){
							str+="<td style='color:red'>2개 이상 30개 미만</td>";			
						}else if(vo.remain_stat=='empty'){
							str+="<td style='color:gray'>1개 이하</td>";						
						}else{
							str+="<td>판매 중지</td>";
						}
						$("#maskResult").append(str);
					});
				}
				, "json"
		);//get
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
		
		var centerControlDiv = document.createElement('div');
		  var centerControl = new CenterControl(centerControlDiv, map);

		  centerControlDiv.index = 1;
		  map.controls[google.maps.ControlPosition.LEFT_BOTTOM].push(centerControlDiv);
		  var transitLayer = new google.maps.TransitLayer();
		  transitLayer.setMap(map);
	}
	function centerChange(tmpLat, tmpLng){
		var p = new google.maps.LatLng(parseFloat(tmpLat),parseFloat(tmpLng));
		map.setCenter(p);
		map.setZoom(15);
	}
	function addMarker(tmpLat, tmpLng, aptName,dong) {
		var iconBase = "https://img.icons8.com/office/40/000000/building.png"
		var marker = new google.maps.Marker({
			position: new google.maps.LatLng(parseFloat(tmpLat),parseFloat(tmpLng)),
			animation: google.maps.Animation.DROP,
			icon: iconBase,
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
	function addMaskMarker(tmpLat, tmpLng,vo) {
		var iconBase = "https://img.icons8.com/plasticine/50/000000/protection-mask.png"
		var marker = new google.maps.Marker({
			position: new google.maps.LatLng(parseFloat(tmpLat),parseFloat(tmpLng)),
			animation: google.maps.Animation.DROP,
			icon: iconBase,
			label : vo.name,
			title : vo.name,
			stock : vo.stock_at,
			remain : vo.remain_stat
			
		});
		marker.addListener('click', function() {
			map.setZoom(17);
			map.setCenter(marker.getPosition());
			callInfoWindowStore(this);
		});
		
		marker.setMap(map);
	}
	function callInfoWindowStore(marker){
		var str = "<h6>"+marker.title+"</h6>"
				+"<p>입고 시간: "+marker.stock+"</p>";
		if(marker.remain=='plenty'){
			str+="<p style='color:green'>마스크 재고상태: 100개 이상</p>";
		}else if(marker.remain=='some'){
			str+="<p style='color:yellow'>마스크 재고상태: 30개 이상 100개 미만</p>";
		}else if(marker.remain=='few'){
			str+="<p style='color:red'>마스크 재고상태: 2개 이상 30개 미만</p>";			
		}else if(marker.remain=='empty'){
			str+="<p style='color:gray'>마스크 재고상태: 1개 이하</p>";						
		}else{
			str+="<p>마스크 판매 중지</p>";
		}
		var infowin = new google.maps.InfoWindow({
			content: str,
		});
		info.close();
		info = infowin;
		info.open(map,marker);
	}
	function callHouseDealInfo(maker) {
		var contentstr = "<table class='table-bordered'><tr><th>식별 번호 </th><th>아파트 이름 </th><th> 층 </th><th>거래 금액 </th><th>거래 날짜 </th></tr>";
		$.get("${pageContext.request.contextPath}/FSelectBoxController/aptDongName"
				,{ name: maker.title,dong:maker.d}
				,function(result){
					$.each(result.data, function(index, vo) {
						let str = "<tr class="+colorArr[index%3]+">"
						+ "<td><a href=\"${pageContext.request.contextPath}/detail?no="+vo.no+"\">" + vo.no + "</td>"
						+ "<td>" + vo.AptName + "</td>"
						+ "<td> " + vo.floor + " </td>"
						+ "<td>" + vo.dealAmount + "</td>"
						+ "<td>" + vo.dealYear+"."+vo.dealMonth + "</td>";
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
	
	function CenterControl(controlDiv, map) {

		  // Set CSS for the control border.
		  var controlUI = document.createElement('div');
		  controlUI.style.backgroundColor = '#fff';
		  controlUI.style.border = '2px solid #fff';
		  controlUI.style.borderRadius = '3px';
		  controlUI.style.boxShadow = '0 2px 6px rgba(0,0,0,.3)';
		  controlUI.style.cursor = 'pointer';
		  controlUI.style.marginBottom = '22px';
		  controlUI.style.textAlign = 'center';
		  controlUI.title = 'Click to recenter the map';
		  controlDiv.appendChild(controlUI);

		  // Set CSS for the control interior.
		  var controlText = document.createElement('div');
		  controlText.style.color = 'rgb(25,25,25)';
		  controlText.style.fontFamily = 'Roboto,Arial,sans-serif';
		  controlText.style.fontSize = '16px';
		  controlText.style.lineHeight = '38px';
		  controlText.style.paddingLeft = '5px';
		  controlText.style.paddingRight = '5px';
		  controlText.textContent = '초기화';
		  controlUI.appendChild(controlText);

		  // Setup the click event listeners: simply set the map to Chicago.
		  controlUI.addEventListener('click', function() {
			  initMap();
			  $("#searchResult").empty();
		  });

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
