<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?after5">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/post.css?after8">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<div class="aaa">
    <a href="${pageContext.request.contextPath}/" class="home"><img src="${pageContext.request.contextPath}/resources/img/back.svg" width="25" height="25"></a>
    <a href="" class="search"><img class="search-i" src="${pageContext.request.contextPath}/resources/img/search.png" width="25" height="25"></a>
	<div class="post-img">
		<img src="${pageContext.request.contextPath}/resources/img/icon.jpg">
	</div>
	<div class="event">2인 공동구매</div>
	<div class="price">
		<li class="price-s">34<div>%</div></li>
		<li class="price-w">15,000원</li>
		<li class="price-sw">9,900원</li>
		<li class="star">★★★★★</li>
		<li class="pro-name">제주 감귤</li>
		<div class="line"></div>
	</div>
	<div class="group-buy"> <!--보류-->
		<li class="group-title">2인 공동구매 참여하기</li>
		<c:forEach var="i" begin="1" end="5">
			<div class="group">
				<div class="group-user">	
					<li>${i}</li>
					<li>이름</li>
				</div>
			</div>
		</c:forEach> 
	</div>
	<div class="line2"></div>
	<div class="product-menu" id="product-menu">
		<ul class="product-info">
			<li><span id="info-btn">상품정보</span></li>
			<li><span id="after-btn">상품후기</span></li>
			<li><span id="ask-btn">상품문의</span></li>
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
	
	document.getElementById('info-btn').addEventListener('click', function() {
	    document.getElementById('info-section').style.display = 'block';
	    document.getElementById('after-section').style.display = 'none';
	    document.getElementById('ask-section').style.display = 'none';

	    // Apply specific styles to the clicked button and reset styles for others
	    var infoBtn = document.getElementById('info-btn');
	    infoBtn.style.color = '#ff5a0b';
	    infoBtn.style.textDecoration = 'underline';
	    infoBtn.style.textUnderlineOffset ='9px';
		infoBtn.style.textDecorationThickness ='2px';

		document.getElementById('after-btn').style.color = 'black';
		document.getElementById('after-btn').style.textDecoration ='none';

		document.getElementById('ask-btn').style.color = 'black';	
		document.getElementById('ask-btn').style.textDecoration ='none';	
	});

	document.getElementById('after-btn').addEventListener('click', function() {
		document.getElementById('info-section').style.display = 'none';
		document.getElementById('after-section').style.display = 'block';
		document.getElementById('ask-section').style.display = 'none';

		// Apply specific styles to the clicked button and reset styles for others
		var afterBtn= document.getElementById("after-btn");
		afterBtn.style.color= '#ff5a0b'
		afterBtn.style.textDecoration= "underline";
		afterBtn.style.textUnderlineOffset='9px'
		afterBtn.style.textDecorationThickness='2px'

		document.getElementById('info-btn').style.color = 'black';
		document.getElementById('info-btn').style.textDecoration ='none';

		document.getElementById('ask-btn').style.color = 'black';	
		document.getElementById('ask-btn').style.textDecoration ='none';	
	});

	document.querySelector('#ask-btn').addEventListener("click",function(){
		document.getElementById('info-section').style.display = 'none';
		document.getElementById('after-section').style.display = 'none';
		document.getElementById('ask-section').style.display = 'block';
		
		// Apply specific styles to the clicked button and reset styles for others
		var afterBtn= document.getElementById("ask-btn");
		afterBtn.style.color= '#ff5a0b'
		afterBtn.style.textDecoration= "underline";
		afterBtn.style.textUnderlineOffset='9px'
		afterBtn.style.textDecorationThickness='2px'

		document.getElementById('info-btn').style.color = 'black';
		document.getElementById('info-btn').style.textDecoration ='none';

		document.getElementById('after-btn').style.color = 'black';	
		document.getElementById('after-btn').style.textDecoration ='none';	
	});
	</script>
	
	<section class="info" id="info-section">
	    상품정보
	</section>
	
	<section class="after" id="after-section">
	    상품후기
	</section>
	
	<section class="ask" id="ask-section">
	    상품문의
	</section>
	
	<div class="product-main">
	</div>
	<!--하단 구매 고정바-->
	<footer class="buy">
		<div class="two-buy">
			<li class="buy-price">9,900 ~</li>
			<li class="buy-go">2인 공동구매 시작하기</li>
		</div>
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