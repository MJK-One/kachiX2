<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="i" begin="1" end="10">
	<div class="cate-product">
		<div class="pro-img">이미지${i}</div>
		<div class="pro-name">물품 이름${i}</div>
		<div class="pro-price">
			<li class="price1">10,000 원</li>
			<li class="price2">20%</li>
			<li class="price3">8,000원</li>
			<div class="pro-info">
				<li>별점</li>
				<li>구매 : ${i}</li>
			</div>
		</div>	
	</div>
</c:forEach> 