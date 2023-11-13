<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?after">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/purchaseResult.css?after2">
<!-- 제이쿼리 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous" type="text/javascript"></script>
<!-- 아임포트 -->
<script src ="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" type="text/javascript"></script>
<title>구매</title>
</head>
<body>
	<div class="bbb">
		<header class="purchase-top">
			<div class="middle">
				<div class="left">
					<button type="button"  onclick="location.href = '${pageContext.request.contextPath}/'" class="back"><img src="${pageContext.request.contextPath}/resources/img/back.svg" width="30" height="30"></button>
					<img class="left-icon" src="${pageContext.request.contextPath}/resources/img/icon.jpg" width="50" height="50">
				</div>
				<div class="title">주문 완료</div>	
			</div>
		</header>
		<div class="screen"></div>
			<section class="product-area">
				<div class="product">
					<div class="product-title">주문번호</div>
					<div class="product-info">40</div>
				</div>
				<div class="product">
					<div class="product-title">상품정보</div>
					<div class="product-info">
						<div class="pro-name">상품명</div>
						<div class="pro-price">가격</div>
					</div>
				</div>
				<div class="product">
					<div class="product-title">구매자</div>
					<div class="product-info">
						<div class="pro-name">이름</div>
						<div class="pro-price">전화번호</div>
						<div class="pro-price">이메일</div>
					</div>
				</div>
				<div class="product">
					<div class="product-title">배송지</div>
					<div class="product-info">
						<div class="pro-del">배송지</div>
					</div>
				</div>
				<div class="product-last">
					<div class="product-title">배송방법</div>
					<div class="product-info">
						<div class="pro-del">택 배</div>
					</div>
				</div>
			</section>	
			<button class="home">
				홈으로
			</button>		
	</div>
</body>
</html> 
