<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main id="main">
		<%@ include file="/WEB-INF/views/tempNav.jsp"%>
		<section id="breadcrumbs" class="breadcrumbs">
			<div class="container">

				<ol>
					<li><a href="${root }/">Home</a></li>
					<li><a href="#">detail</a></li>
				</ol>

			</div>
		</section>
		<section id="blog" class="blog">
			<h1 align="center">상세 정보</h1>

			<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
			<div class="container" align="center">
				<%-- 	<img src ="${root }/img/${src}" onerror="this.src="resources/img/다세대주택.jpg>  --%>
				<img src="resources/img/다세대주택.jpg">
				<h2>조회한 건물 정보</h2>
				<c:choose>
					<c:when test="${!empty housedeals }">
						<div align="left"
							style="border: 3px dotted green; width: 600px; height: 320px">
							<p>1. 식별 번호 : ${housedeals.no }</p>
							<p>2. 법정동 명 : ${housedeals.dong }</p>
							<p>3. 아파트 이름 : ${housedeals.aptName }</p>
							<p>4. 법정동 코드 : ${housedeals.code }</p>
							<p>5. 건축 년도 : ${housedeals.buildYear }</p>
							<p>6. 거래 가격 : ${housedeals.dealAmount }</p>
							<p>7. 지번 주소 : ${housedeals.jibun }</p>
							<p>8. 거래 정보 : ${housedeals.type }</p>
							<button class="btn btn-primary" id="reviewButton">거주 후기</button>
							
						</div>
						<br>
						<div id="PrReview">
								<h2>거주 후기</h2>
								<table class="table table-bordered table-hover" id="reviewtable">
									
								</table>
								<c:if test="${userInfo != null}">
								<button class="btn btn-primary" id="reviewInsert">후기 작성</button>
								<div id="insertform">
									<div class="form-group" align="left">
										<label for="content">내용</label> 
										<textarea
											class="form-control" rows="6" id="content" name="content" required="required">
										</textarea>
									</div>
									<button class="btn btn-primary" id="postReview">후기 등록</button>
									<button class="btn btn-primary" id="close">닫기</button>
								</div>
								<div id="updateform">
									<div class="form-group" align="left">
										<label for="ucontent">수정 내용</label> 
										<textarea
											class="form-control" rows="6" id="ucontent" name="ucontent" required="required">
										</textarea>
									</div>
									<button class="btn btn-primary" id="putReview">후기 수정</button>
									<button class="btn btn-primary" id="uclose">닫기</button>
								</div>
								</c:if>
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
				&copy; Copyright <strong><span>Anyar</span></strong>. All Rights
				Reserved
			</div>
			<div class="credits">
				<!-- All the links in the footer should remain intact. -->
				<!-- You can delete the links only if you purchased the pro version. -->
				<!-- Licensing information: https://bootstrapmade.com/license/ -->
				<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/anyar-free-multipurpose-one-page-bootstrap-theme/ -->
				Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a> <br>this
				page Made by 고영욱 이성현
			</div>
		</div>
	</footer>
	<!-- End Footer -->
	<script>
	var uNum;
	var puserId = '${userInfo.userId}';
	var phouseNo = ${housedeals.no};
	function list(){
		$.get("${pageContext.request.contextPath}/api/review/"+phouseNo
				,function(result){
					$("#reviewtable").empty();
					console.log(result);
					$("#reviewtable").append("<tr><th>작성자</th><th>내용</th><th>비고</th>");
					$.each(result.data,function(index,vo){
						let str ="<tr>"
						+ "<td>"+vo.userId+"</td>"
						+ "<td>"+vo.content+"</td>";
						if(vo.userId===puserId){
							str += "<td><button class='btn btn-primary' t='up' num="+vo.num+">수정</button>";
							str +="<button class='btn btn-primary' t='de' num="+vo.num+">삭제</button></td>";
						}else{
							str+="<td></td>";
						}
						str += "</tr>";
						$("#reviewtable").append(str);
					});//each
					$("button[t=up]").click(function(){
						console.log($(this).attr("num"));
						$("#updateform").show(500);
						uNum = $(this).attr("num");
					});
					$("button[t=de]").click(function(){
						console.log("삭제");
						$.ajax({
							type:'delete',
							url:'/api/review/'+$(this).attr("num"),
							success:function(result){    				
								list();
							}
						});
					});
				}//function
				,"json"
		);//get
	};
	$("#PrReview").hide();
	$("#insertform").hide();
	$("#updateform").hide();
	$(document).ready(function(){
		
		console.log(puserId);
		console.log(phouseNo);
		$("#reviewButton").click(function(){
				list();
				$("#PrReview").show(500);
			}
		);//reviewButton 클릭
		$("#reviewInsert").click(function(){
			$("#insertform").show(500);
		});
		$("#close").click(function(){
			$("#insertform").hide(500);
		});
		$("#uclose").click(function(){
			$("#updateform").hide(500);
		});
		$("#postReview").click(function(){
			$.ajax({
				type:'POST',
				contentType:"application/json;charset=utf-8",
				url:'/api/review',
				data: JsonInsert(),
				success:function(result){    				
					$('#insertform').hide();
					list();
				}
			});
		});
		$("#putReview").click(function(){
			$.ajax({
				type:'put',
				contentType:"application/json;charset=utf-8",
				url:'/api/review',
				data: JsonUpdate(),
				success:function(result){    				
					$('#updateform').hide();
					list();
				}
			});
		});
		
	})
	
		function JsonInsert() {
	 		let obj = {};
	 		obj['num'] = 0;
	 		obj['userId'] = puserId;
	 		obj['houseNo'] = phouseNo;
	 		obj['content'] = $("#content").val();
	 		return JSON.stringify(obj);
	 	}
	function JsonUpdate() {
 		let obj = {};
 		obj['num'] = uNum;
 		obj['userId'] = puserId;
 		obj['houseNo'] = phouseNo;
 		obj['content'] = $("#ucontent").val();
 		return JSON.stringify(obj);
 	}
	</script>
</body>
</html>