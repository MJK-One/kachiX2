<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach var="post" items="${posts}">
	<a href="#">
		<div class="cate-product">
			<div class="pro-img"><img src="${post.mainImageUrl}" alt="Post image"></div>
			<div class="pro-name">${post.title}</div>
			<div class="pro-price">
				<li class="price1">${post.price} 원</li>
				<li class="price2">${post.discountRate}%</li>
				<!-- 가격과 할인율로 실제 판매가격 계산 -->
				<li class="price3">${post.price - (post.price * post.discountRate / 100)}원</li>
				<div class="pro-info">
					<li>별점</li>
					<li>구매 : ${i}</li>
				</div>
		    </div>	
		</div>
	</a>
</c:forEach> 