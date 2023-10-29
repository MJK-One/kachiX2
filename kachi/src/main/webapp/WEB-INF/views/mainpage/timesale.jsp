<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/timesale.css?after5">
</head>
<body>
	<div class="time-banner">
		<img src="${pageContext.request.contextPath}/resources/img/timesale.png" width="100%" height="100%">
	</div>
	<div class="timesale">
		<div class="ts-title">놓치면 후회할 가격! 타임세일⏰</div>
		<div class="ts">
			<% 
			    java.util.Date now = new java.util.Date();
			    java.util.Calendar cal = java.util.Calendar.getInstance();
			    cal.setTime(now);
			    cal.add(java.util.Calendar.DATE, 7);
			    java.util.Date after = cal.getTime();
			    request.setAttribute("now", now);
			    request.setAttribute("after", after);
			%>
			<c:forEach var="post" items="${posts}" varStatus="status">	
					<c:if test="${post.salePeriod >= now && post.salePeriod <= after}">	
					<a href="${pageContext.request.contextPath}/post/view/${post.postId}">	
				    <div class="time-pro">
						<div class="ts-pro-img"><img src="${post.mainImageUrl}" alt="Post image"></div>
						<div class="ts-pro-time">
						<img src="${pageContext.request.contextPath}/resources/img/timer.svg">
						마감임박 일 남음</div>
						<div class="ts-pro-name">${post.title}</div>
						<div class="ts-pro-price">
							<li class="ts-price1">${post.discountRate}%</li>						
							<li class="ts-price2" id="price2-${status.index}"></li>
							<script>document.getElementById('price2-${status.index}').innerText = numberWithCommas(${post.totalprice}) + ' 원';</script>
							<li class="ts-price4" id="price4-${status.index}"></li>
							<script>document.getElementById('price4-${status.index}').innerText = numberWithCommas(${post.price}) + ' 원';</script>
					 	</div>
				 	</div>
				 	</a>
				</c:if>
			 </c:forEach>			
		</div>
	</div>
</body>
</html>