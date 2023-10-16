<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/searchResult.css?after">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?after3">
<title>같이의 가치-공동구매</title>
</head>
<body>
	<div class="bbb">
		<div class="search-m">
			<div class="search-line">
				<button type="button"  onclick="location.href='${pageContext.request.contextPath}/';" class="home"><img src="${pageContext.request.contextPath}/resources/img/back.svg" width="30" height="30"></button>
				<input class="form-input" autocomplete="off" aria-autocomplete="list" type="search" placeholder="상품을 검색해보세요!" value="">
				<button type="button" class="search-btn"><img src="${pageContext.request.contextPath}/resources/img/search2.svg" width="30" height="30"></button>
			</div>		
		</div>
		<!--서치 메인-->
		<div class="search-main">
			<div class="search-cate">			
			</div>
			<!--필터 분류-->
			<div class="filter-option">
				<div class="option">
					<!--가격분류-->
					<div class="select price">
						<div type="button" class="price-box" onclick="toggleMenu()" style="cursor: pointer;">가격대별</div>
						<img src="${pageContext.request.contextPath}/resources/img/under.svg"/>	
						<div class="price-box-menu hidden">
					        <div onclick="selectPrice(this, '전체')">전체</div>
					        <div onclick="selectPrice(this, '1만원 미만')">1만원 미만</div>
					        <div onclick="selectPrice(this, '5만원 이하')">5만원 이하</div>
					        <div onclick="selectPrice(this, '5~10만원')">5~10만원</div>
					        <div onclick="selectPrice(this, '10만원 이상')">10만원 이상</div>
						</div>				
					</div>
					<!--인기순 분류-->
					<div class="select pop">
						<img src="${pageContext.request.contextPath}/resources/img/pop.svg" width="13px" height="10px" style="padding-right:3px;padding-top:3px;"/>		
						<div type="button" class="pop-box" onclick="toggleMenu2()" style="cursor: pointer;">인기순</div>	
						<div class="pop-box-menu hidden">
							<div onclick="selectPop(this)">인기순</div>
							<div onclick="selectPop(this)">최신순</div>
						</div>	
					</div>
					<span class="bar"></span>
					<button></button>
				</div>
			</div>
			<script>
			    var price = document.querySelector('.price-box-menu');
				var pop = document.querySelector('.pop-box-menu');
				
				function toggleMenu() {
				     if (price.classList.contains('hidden')) {
				    	 price.classList.remove('hidden');
				    	 pop.classList.add('hidden');
				     } else {
				    	 price.classList.add('hidden');
				     }
				}					
				function toggleMenu2() {	     
				     if (pop.classList.contains('hidden')) {
				    	 pop.classList.remove('hidden');
				    	 price.classList.add('hidden');
				     } else {
				    	 pop.classList.add('hidden');
				     }
				}	
				function selectPop(element) {
					  var selectedText = element.innerText;				  
					  // 변경된 필터 표시
					  var popBox = document.querySelector('.pop-box');
					  popBox.innerText = selectedText;
					  // 글씨색 변경
					  var allOptions = document.querySelectorAll('.pop-box-menu div');
					  
					   for (var i =0; i<allOptions.length; i++) {
					     allOptions[i].style.color = '';
					   }
					   
					   element.style.color = 'red';
					   pop.classList.add('hidden');
					}
			</script>
			<!--포스트-->
			<div class="filter-post">
			<c:forEach var="post" items="${posts}">
				<c:if test="${post.postId >= 0}">
					<a href="${pageContext.request.contextPath}/post/view/${post.postId}">
						<div class="cate-product">
							<div class="pro-img"><img src="${post.mainImageUrl}" alt="Post image"></div>	
							<div class="pro-name">${post.title}</div>
							<div class="pro-price">
								<li class="price1">${post.price} 원</li>
								<li class="price2">${post.discountRate}%</li>
								<!-- 가격과 할인율로 실제 판매가격 계산 -->
								<li class="price3" data-price="${post.price - (post.price * post.discountRate / 100)}">${post.price - (post.price * post.discountRate / 100)}원</li>
								<div class="pro-info">
									<li>별점</li>
									<li>구매 : ${i}</li>
								</div>
								<div class="line"></div>
						    </div>	
						</div>
					</a>
				</c:if>
			</c:forEach>	
			</div>
	    </div>
	</div>
	<script>
    function selectPrice(element, selectedOption) { 
        var priceBox = document.querySelector('.price-box');
     	// 선택된 가격대 표시
        priceBox.innerText = selectedOption;
		var selectedText = element.innerText;		
		// 변경된 가격대 표시
		priceBox.innerText = selectedText;
		  
		// 글씨색 변경
		var allOptions = document.querySelectorAll('.price-box-menu div');		  
		for (var i =0; i<allOptions.length; i++) {
			allOptions[i].style.color = '';
		}	   
		element.style.color = 'red';
		//리스트 숨기기
		price.classList.add('hidden');
         
        // 모든 상품 숨기기
        var products = document.querySelectorAll('.cate-product');
        products.forEach(function(product) {
            product.style.display = "none";
        });
        //범위 확인 후 보여주기
        switch (selectedOption) {
        	case "전체":
        		products.forEach(function(product) {
					product.style.display = "block";
				});
        		break;
        	case "1만원 미만":
        		var filteredProducts1 = document.querySelectorAll('.cate-product .price3');
        		filteredProducts1.forEach(function(product) {
        	        var price = parseInt(product.innerText.replace(/[^0-9]/g,""));// "원"이나 콤마(,)등이 포함된 숫자만 추출
        	        if (price < 10000) {
        	            product.closest('.cate-product').style.display = 'block';
        	        }
        	    });
				break;
        	case "5만원 이하":
        		var filteredProducts2 = document.querySelectorAll('.cate-product .price3');
        	    filteredProducts2.forEach(function(product) {
        	        var price = parseInt(product.innerText.replace(/[^0-9]/g,""));
        	        if (price <= 50000) {
        	            product.closest('.cate-product').style.display = 'block';
        	        }
        	    });
				break;
        	case "5~10만원":
        		var filteredProducts3 = document.querySelectorAll('.cate-product .price3');
        	    filteredProducts3.forEach(function(product) {
        	        var price = parseInt(product.innerText.replace(/[^0-9]/g,""));
        	        if (price > 50000 && price < 100000) {
        	            product.closest('.cate-product').style.display = 'block';
        	        }
        	    });
				break;
        	case "10만원 이상":
        		var filteredProducts4 = document.querySelectorAll('.cate-product .price3');
        	    filteredProducts4.forEach(function(product) {
        	        var price = parseInt(product.innerText.replace(/[^0-9]/g,""));
        	        if (price >= 100000) {
        	            product.closest('.cate-product').style.display = 'block';
        	        }
        	    });
				break;
        }
    }
	</script>
</body>
</html>