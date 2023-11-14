<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/searchResult.css?after1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?after4">
<title>같이의 가치-공동구매</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	    $(document).ready(function() {
	      $('.search-btn').on('click', function() {
	        var query = $('.form-input').val();
	        var userId = '${user.userID}';
	        if (query.length > 0) {
	          // 검색어를 searchresult.jsp에 전달합니다.
	          window.location.href = '${pageContext.request.contextPath}/member/searchResult?query=' + encodeURIComponent(query);
	
	          // 검색어를 서버에 기록합니다.
	          $.post('${pageContext.request.contextPath}/search/record', { userId: userId, keyword: query }, function(data) {
	              console.log("Search recorded successfully.");
	          });
	        }
	      });
	    });
	</script>


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
			<script>
		   
		
		    function numberWithCommas(x) {
		        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		    }
			</script>
			<div class="filter-post">
    <c:choose>
        <c:when test="${empty posts}">
             <div style="width: 100%; text-align: center;">
                <p style="color: gray;">검색결과가 없습니다.</p>
            </div>
        </c:when>
        <c:otherwise>
            <c:forEach var="post" items="${posts}">
                <c:if test="${post.postId >= 0}">
                    <a href="${pageContext.request.contextPath}/post/view/${post.postId}">
                        <div class="cate-product">
                            <div class="pro-img"><img src="${post.mainImageUrl}" alt="Post image"></div>	
                            <div class="pro-name">${post.title}</div>
                            <div class="pro-price" data-price="${post.totalprice}" >
                                <li class="price1"><script>document.write(numberWithCommas(${post.price}));</script> 원</li>
                                <li class="price2">${post.discountRate}%</li>
                                <!-- 가격과 할인율로 실제 판매가격 계산 -->
                                <li class="price3"><script>document.write(numberWithCommas(${post.totalprice}));</script>원</li>
                                <div class="pro-info">
				                	<li><img src="${pageContext.request.contextPath}/resources/img/star.svg" width="17" height="17"> 4.5</li>
				                </div>
                                <div class="line"></div>
                            </div>	
                        </div>
                    </a>
                </c:if>
            </c:forEach>
        </c:otherwise>
    </c:choose>
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
                filterProductsByPrice(0, 10000);
                break;
            case "5만원 이하":
                filterProductsByPrice(0, 50000);
                break;
            case "5~10만원":
                filterProductsByPrice(50001, 100000);
                break;
            case "10만원 이상":
                filterProductsByPrice(100001, Infinity);
                break;
        }
    }
    function filterProductsByPrice(minPrice, maxPrice) {
        var priceElements = document.querySelectorAll('.cate-product .pro-price');
        
        priceElements.forEach(function(priceElement) {
            var price = parseInt(priceElement.getAttribute('data-price'));
            
            if (price >= minPrice && price <= maxPrice) {
              priceElement.closest('.cate-product').style.display = 'block';
           }
       });
    }
	</script>
</body>
</html>