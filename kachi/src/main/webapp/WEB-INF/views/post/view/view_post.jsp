<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?after5">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/post.css?after9">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<div class="aaa">
    <div id="top-menu">
     	<button type="button"  onclick = "location.href = '${pageContext.request.contextPath}/'" class="home"><img src="${pageContext.request.contextPath}/resources/img/back1.svg" width="30" height="30"></button>
     	<img class="top-post-img" src="${post.mainImageUrl}" alt="Post image" width="50" height="50">
     	<div class="top-post-name">
     		<li>${post.title}</li>
     	</div>
     	
    	<button type="button" class="search"><img src="${pageContext.request.contextPath}/resources/img/search1.svg" width="50" height="55"></button>
    	<button type="button" class="basket"><img src="${pageContext.request.contextPath}/resources/img/basket1.svg" width="50" height="55"></button>
    </div>
    <script type="text/javascript">
    window.onscroll = function() {changeBackground()};

    function changeBackground() {
        if (document.body.scrollTop > 800 || document.documentElement.scrollTop > 800) {
            document.getElementById("top-menu").style.background = "white";
            document.querySelector(".home img").src = "${pageContext.request.contextPath}/resources/img/back.svg";
            document.querySelector(".search img").src = "${pageContext.request.contextPath}/resources/img/search1.svg";
            document.querySelector(".search").style.visibility = "hidden";
            document.querySelector(".basket img").src = "${pageContext.request.contextPath}/resources/img/basket.svg";
            document.querySelector(".top-post-img").style.visibility = "visible";
            document.querySelector(".top-post-name").style.visibility = "visible";
        } else {
            document.getElementById("top-menu").style.background = "linear-gradient(#000 0%, rgba(0, 0, 0, 0) 100%)";
            document.querySelector(".home img").src = "${pageContext.request.contextPath}/resources/img/back1.svg";
            document.querySelector(".search img").src = "${pageContext.request.contextPath}/resources/img/search1.svg";
            document.querySelector(".search").style.visibility = "visible";
            document.querySelector(".basket img").src = "${pageContext.request.contextPath}/resources/img/basket1.svg";
            document.querySelector(".top-post-img").style.visibility = "hidden";
            document.querySelector(".top-post-name").style.visibility = "hidden";
        }
    }
    </script>
	<div class="post-img">
		<img src="${post.mainImageUrl}" alt="Post image">
		<%-- <img src="${pageContext.request.contextPath}/resources/img/icon.jpg"> --%>
	</div>
	<div class="event">2인 공동구매</div>
	<div class="price">
		<div class="price-info">
			<div class="sale">
				<li class="price-s">${post.discountRate}</li>
				<li class="price-s2">%</li>
			</div>
			<div class="price-won">
				<li class="price-w">${post.price} 원</li>
				<li class="price-sw">${post.price - (post.price * post.discountRate / 100)}원</li>
			</div>
			<li class="star">★★★★★</li>	
		</div>
		<div class="product-name">
			<li class="pro-name">${post.title}</li>
		</div>
	</div>
	<div class="deliver">
		<div class="del">
			<img src="${pageContext.request.contextPath}/resources/img/del.svg" width="28" height="25">
			<li class="deltxt t1">무료배송</li>
			<li class="deltxt t2 ">(전상품 무료 배송)</li>
		</div>
		<script>
		$(document).ready(function() {
	 

			$('.heart').click(function() {
			    var postId = "${post.postId}";
			    $.ajax({
			        url: '${pageContext.request.contextPath}/toggleWishlist', 
			        type: 'POST',
			        data: {postId: postId},
			        success: function(data) {
			        	if (data.error) {
			                alert(data.error); // 로그인하지 않았다면 경고창 띄우기
			            } else if (data.added) {
			                $('.heart img').attr('src', '${pageContext.request.contextPath}/resources/img/heart1.svg');
			                addedToWishList = true;
			            } else {
			                $('.heart img').attr('src', '${pageContext.request.contextPath}/resources/img/heart.svg');
			                addedToWishList = false;
			            }
			        },
			        error: function(jqXHR, textStatus, errorThrown) {
			            console.log(textStatus, errorThrown);
			        }
			    });
			});
		});
		</script>
		<div class="action-btn">
	    <button class="heart">
	        <c:choose>
	            <c:when test="${isInWishlist}">
	                <img src="${pageContext.request.contextPath}/resources/img/heart1.svg">
	            </c:when>
	            <c:otherwise>
	                <img src="${pageContext.request.contextPath}/resources/img/heart.svg">
	            </c:otherwise>
	        </c:choose>
	        <span class="txt">찜하기</span>
	    </button>
	</div>
	</div>
	<div class="group-buy"> <!--보류-->
		<div class="group-title">
			<li>2인 공동구매 참여하기</li>
		</div>
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
	    ${post.content}
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