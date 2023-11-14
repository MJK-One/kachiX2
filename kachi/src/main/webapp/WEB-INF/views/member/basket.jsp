<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?after2">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/basket.css?after7">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<title>같이의 가치-공동구매</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<body>
	<div class="aaa">
		<header class="basket-top">
			<div class="middle">
				<div class="left">
					<button type="button"  onclick="location.href = '${pageContext.request.contextPath}/'" class="back"><img src="${pageContext.request.contextPath}/resources/img/back.svg" width="30" height="30"></button>
					<img class="left-icon" src="${pageContext.request.contextPath}/resources/img/icon.jpg" width="50" height="50">
				</div>
				<div class="title">내 장바구니</div>	
			</div>
		</header>
		<div class="screen"></div>
		<div class="basket-num">
			<li class="all">전체 구매 상품</li>
			<li class="all-num">${posts.size()}</li>
		</div>
		<div class="basket-main">
		    <c:forEach items="${posts}" var="post">
		            <div class="basketlist">
			            <a href="${pageContext.request.contextPath}/post/view/${post.postId}">
			            <div class="basket-img"><img src="${post.mainImageUrl}" alt="이미지"></div>
			                <div class="basket-info">
			                    <div class="basket-name">${post.title}</div>
			                    <div class="basket-price1"><fmt:formatNumber value="${post.price}" pattern="#,###"/>원</div>
			                    <div class="basket-price2">${post.discountRate}%</div>
			                    <div class="basket-price3"><fmt:formatNumber value="${post.totalprice}" pattern="#,###"/>원</div>
			                    <div class="basket-star"><li><img src="${pageContext.request.contextPath}/resources/img/star.svg" width="17" height="17"> 4.5</li></div>
                    			<c:choose>
								    <c:when test="${post.deliveryStatus == false}">
								    	<img src="${pageContext.request.contextPath}/resources/img/del.svg" width="28" height="25">
								        <li class="delivery-status red">배송 준비 중</li>
								    </c:when>
								    <c:when test="${post.deliveryStatus == true}">
								    	<img src="${pageContext.request.contextPath}/resources/img/del.svg" width="28" height="25">
								        <li class="delivery-status blue">배송 중</li>
								    </c:when>
								    <c:otherwise>
								        <div class="delivery-status">배송 상태 정보 없음</div>
								    </c:otherwise>
								</c:choose>
			            </a>
			            		 <c:if test="${post.reviewWritten == false}">
			         			 <button type="button" class="review">구매 후기</button>
			         			 </c:if>
            					<div class="review-detail">         					
            						<h2>후기 작성</h2>       
            						<div class="pro-info-star">
            							<img src="${post.mainImageUrl}" alt="이미지">
            							<div class="review-de-middle">
            								<li>${post.title}</li> 						   
							    <form method="post" action="${pageContext.request.contextPath}/review/submit" enctype="multipart/form-data">
							        <input type="hidden" name="purchaseId" value="${post.purchaseId}">
							        <input type="hidden" name="postId" value="${post.postId}">
									        <div class="star">
									            <div class="rating">                                               
									                <i class="rating__star far fa-star"></i>
									                <i class="rating__star far fa-star"></i>
									                <i class="rating__star far fa-star"></i>
									                <i class="rating__star far fa-star"></i>
									                <i class="rating__star far fa-star"></i>
									                <span class="rating__result"></span> 
									            </div>
									        </div>
								        </div>
								    </div>				     
							        <div class="review-write">
								        <input type="hidden" name="rating" class="rating__result" value=1>
								        <textarea name="reviewContent" rows="5" cols="50"></textarea><br>   
								        <button type="submit" class="submit">작성</button>
								   </div>     
							    </form>           								       						
            					</div>       	
					</div>	
			</div>    	            	  
			</c:forEach>		
	</div>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script>
		$(document).ready(function() {
		    $(".review").click(function() {
		        var $reviewDetail = $(this).next('.review-detail');
		        
		        // 클릭한 '후기 작성'이 현재 표시되어 있으면 숨기고, 그렇지 않으면 표시합니다.
		        if ($reviewDetail.is(":visible")) {
		            $reviewDetail.hide();
		            // '후기 작성'이 숨겨져 있을 때는 active 클래스를 제거합니다.
		            $(this).removeClass('active');
		        } else {
		            // 먼저 모든 '후기 작성'을 숨깁니다.
		            $('.review-detail').hide();
		            // 모든 '후기 작성' 버튼에서 active 클래스를 제거합니다.
		            $('.review').removeClass('active');
		            
		            // 선택된 '후기 작성'만 표시하고, active 클래스를 추가합니다.
		            $reviewDetail.show();
		            $(this).addClass('active');
		        }
		    });
		});
		</script>
		<script>
		// rating 클래스를 갖는 모든 요소를 가져옵니다.
		const ratingElements = document.querySelectorAll('.rating');

		ratingElements.forEach((ratingElement, index) => {
		    const ratingStars = [...ratingElement.getElementsByClassName("rating__star")];
		    const ratingResult = ratingElement.querySelector(".rating__result");
		    const formElement = ratingElement.closest("form"); // 폼 요소를 찾습니다.

		    

	        if (!formElement) {
	            console.error('Form element not found');
	            return;
	        }
	        const ratingInput = formElement.querySelector("input[name='rating']"); // 폼에서 rating 필드를 찾습니다.
	        
		    printRatingResult(ratingResult);
		    executeRating(ratingStars, ratingResult);
		    
		    function executeRating(stars, result) {
		        const starClassActive = "rating__star fas fa-star";
		        const starClassUnactive = "rating__star far fa-star";

		        stars.map((star) => {
		            star.onclick = () => {
		                let i = stars.indexOf(star);

		                if (star.className.indexOf(starClassUnactive) !== -1) {
		                    printRatingResult(result, i + 1);
		                    for (i; i >= 0; --i) stars[i].className = starClassActive;
		                } else {
		                    printRatingResult(result, i);
		                    for (i; i < stars.length; ++i) stars[i].className = starClassUnactive;
		                }
		                ratingInput.value = result.textContent;
		            };
		        });
		    }
		    function printRatingResult(result, num = 0) {
		        result.textContent = num.toString();
		    }

		    
		});
		</script>
		
	</div>
</body>
</html>