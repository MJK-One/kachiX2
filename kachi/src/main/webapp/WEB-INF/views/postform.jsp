<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?ver=3">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/post.css?ver=3">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<div class="aaa">
    <a href="${pageContext.request.contextPath}/" class="home">뒤로가기</a>
	<div class="post-img">
		<img src="${pageContext.request.contextPath}/resources/img/icon.jpg">
	</div>
	<div class="event"></div>
	<div class="price">가격</div>
	<div class="group-buy">
		<li>2인 공동구매 참여하기</li>
		<c:forEach var="i" begin="1" end="5">
			<div class="group">
				<li>${i}<li>
			</div>
		</c:forEach> 
	</div>
	<div class="product-menu" id="product-menu">
		<%
        	String pageChange;
    	%>
		<ul class="product-info">
				<li><a href=""><span>상품정보</span></a></li>
				<li><a href=""><span>상품후기</span></a></li>
				<li><a href=""><span>상품문의</span></a></li>
		</ul>
	</div>
	<script type="text/javascript">
	$(function() {
		  var lnb = $("#product-menu").offset().top;
		  $(window).scroll(function() {
		    var window = $(this).scrollTop();
		    if(lnb <= window) {
		      $("#product-menu").addClass("fixed");
		    }else{
		      $("#product-menu").removeClass("fixed");
		    }
		  })
	});
	</script>
	<div class="product-main">
	</div>
	<!--하단 구매 고정바-->
	<footer class="buy">
		<div class="one-buy"></div>
		<div class="two-buy"></div>
	</footer>
</div>
	<!-- 위로 가기 -->
<a class="back-to-top"></a>
<script type="text/javascript">
$(function(){
	$('.back-to-top').on('click',function(e){
		e.preventDefault();
		$('html, body').animate({scrollTop:0},600);
	});
			  
	$(window).scroll(function() {
		if ($(document).scrollTop() > 500) {
			$('.back-to-top').addClass('show');
		} else {
			$('.back-to-top').removeClass('show');
		}
	});
});
</script>
</body>
</html>