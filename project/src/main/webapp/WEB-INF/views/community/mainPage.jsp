<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<%@ include file="/WEB-INF/views/layout/community.jsp" %>

<div class="container">

		<div class="">
			<div class="main-photo">
				<img class="main-img"src="${pageContext.request.contextPath}/resources/images/배너.avif" >
			</div>
		</div>
		<div class="main-photo">
			<a href="${pageContext.request.contextPath}/shopping/categorypage">
				<img class="main-cate"src="${pageContext.request.contextPath}/resources/images/쇼핑하기.png">
			</a>
			<img class="main-cate"src="${pageContext.request.contextPath}/resources/images/빅이벤트.png">
			<img class="main-cate"src="${pageContext.request.contextPath}/resources/images/오늘의 딜.png">
			<img class="main-cate"src="${pageContext.request.contextPath}/resources/images/오늘의 발견.png">
			<img class="main-cate"src="${pageContext.request.contextPath}/resources/images/장보기.png">
			<img class="main-cate"src="${pageContext.request.contextPath}/resources/images/집들이.png">
			<img class="main-cate"src="${pageContext.request.contextPath}/resources/images/취향의 발견.png">
			<img class="main-cate"src="${pageContext.request.contextPath}/resources/images/빠른배송.png">
			<img class="main-cate"src="${pageContext.request.contextPath}/resources/images/쉬운이사.png">
			<img class="main-cate"src="${pageContext.request.contextPath}/resources/images/리모델링.png">
		</div>
		
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>		