<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?ver=4">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/mychecklist.css?after">
<title>같이의 가치-공동구매</title>
</head>
<body>
	<div class="aaa">
		<header class="mychecklist-top">
			<div class="middle">
				<div class="left">
					<button type="button"  onclick="location.href = '${pageContext.request.contextPath}/'" class="back"><img src="${pageContext.request.contextPath}/resources/img/back.svg" width="30" height="30"></button>
					<img class="left-icon" src="${pageContext.request.contextPath}/resources/img/icon.jpg" width="50" height="50">
				</div>
				<div class="title">내가 찜한 상품</div>	
			</div>
		</header>
		<div class="screen"></div>
		<div class="check-num">
			<li class="all">전체</li>
			<li class="all-num">23</li>
		</div>
		<div class="check-main">
			<c:forEach begin="0" end="10" var="i" >
				<div class="checklist">
					<div class="check-img">이미지</div>
					<div class="check-info">
						<div class="check-name">이름</div>
						<div class="check-price1">10,000</div>
						<div class="check-price2">10%</div>
						<div class="check-price3">9,000</div>
						<div class="check-star">★★★★★</div>
					</div>
					<button type="button" class="cancel">
						<img class="x" src="/five/resources/img/x.svg" width="10" height="10">
					</button>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>