<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?after6">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/post.css?after19">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
<div class="aaa">
    <div id="top-menu">
     	<button type="button"  onclick = "history.back()" class="home"><img src="${pageContext.request.contextPath}/resources/img/back1.svg" width="30" height="30"></button>
     	<img class="top-post-img" src="${post.mainImageUrl}" alt="Post image" width="50" height="50">
     	<div class="top-star"><img src="${pageContext.request.contextPath}/resources/img/star.svg" width="17" height="17"> 4.5</li>	</div>
     	<div class="top-post-name">
     		<li>${post.title}</li>
     	</div>
     	
    	<button type="button" class="search"><img src="${pageContext.request.contextPath}/resources/img/search1.svg" width="50" height="55"></button>
    </div>
    <script type="text/javascript">
    window.onscroll = function() {changeBackground()};

    function changeBackground() {
        if (document.body.scrollTop > 800 || document.documentElement.scrollTop > 800) {
            document.getElementById("top-menu").style.background = "white";
            document.querySelector(".home img").src = "${pageContext.request.contextPath}/resources/img/back.svg";
            document.querySelector(".search img").src = "${pageContext.request.contextPath}/resources/img/search1.svg";
            document.querySelector(".search").style.visibility = "hidden";
            document.querySelector(".top-post-img").style.visibility = "visible";
            document.querySelector(".top-star").style.visibility = "visible";
            document.querySelector(".top-post-name").style.visibility = "visible";
        } else {
            document.getElementById("top-menu").style.background = "linear-gradient(#000 0%, rgba(0, 0, 0, 0) 100%)";
            document.querySelector(".home img").src = "${pageContext.request.contextPath}/resources/img/back1.svg";
            document.querySelector(".search img").src = "${pageContext.request.contextPath}/resources/img/search1.svg";
            document.querySelector(".search").style.visibility = "visible";          
            document.querySelector(".top-post-img").style.visibility = "hidden";
            document.querySelector(".top-star").style.visibility = "hidden";
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
				<li class="price-w"><fmt:formatNumber value="${post.price}" pattern="#,###"/>원</li>
				<li class="price-sw"><fmt:formatNumber value="${post.totalprice}" pattern="#,###"/>원</li>
			</div>
			<li class="star"><img src="${pageContext.request.contextPath}/resources/img/star.svg" width="17" height="17"> 4.5</li>	
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
	            	<img src="${pageContext.request.contextPath}/resources/img/heart1.svg" width="28" heigth="29">               
	                <span class="txt">찜하기</span>
	            </c:when>
	            <c:otherwise>	
	            	<img src="${pageContext.request.contextPath}/resources/img/heart.svg" width="28" heigth="29">                
	                <span class="txt">찜하기</span>
	            </c:otherwise>
	        </c:choose>       
	    </button>
	</div>
	</div>
		<div class="group-buy">
		<div class="group-title">
			<li>2인 공동구매 참여하기</li>		
			<button class="all-group-see" id="all-group-see">전체보기</button>
			<span class="all-group">5개팀</span>
		</div>
		<div class="all-groupbuy" id="all-groupbuy">
			<div class="all-groupbuy-detail">
				<header>
					<h2>전체 공동구매</h2>
					<button id="x-load"><img src="${pageContext.request.contextPath}/resources/img/x2.svg" width="30" height="30"></button>
				</header>
				<div>
					<c:set var="count" value="0" />
					 <c:forEach var="groupBuy" items="${groupBuyList}">
					 <c:if test="${count < 30}">
					    <div class="group-all">
					        <div class="group-user-all">
					            <li>${fn:substring(groupBuy.creatorName, 0, 1)}<c:forEach begin="1" end="${fn:length(groupBuy.creatorName)-2}" varStatus="loop"><c:out value="*" /></c:forEach>${fn:substring(groupBuy.creatorName, fn:length(groupBuy.creatorName)-1, fn:length(groupBuy.creatorName))}
					                <c:choose>
					                    <c:when test="${groupBuy.status eq 'waiting'}">(1/2)</c:when>
					                    <c:otherwise>					                    	
					                    <li>(2/2)</li> <span class="success-all">공동구매완료</span></c:otherwise>
					                </c:choose>
					            </li>
					            <c:if test="${groupBuy.status eq 'waiting'}">
					                <button class="join-btn" id="join-btn" data-groupbuy-id="${groupBuy.groupBuyID}">주문참여</button>
					            </c:if>
					        </div>
					    </div>
					    <c:set var="count" value="${count + 1}" />
					    </c:if>
					</c:forEach>
				</div>
			</div>
		</div>
			<script>
				document.getElementById('x-load').addEventListener('click', function() {
					document.getElementById('all-groupbuy').style.display = 'none';				
					document.body.style.overflowY = 'scroll'; // 스크롤 허용
				});
				document.getElementById('all-group-see').addEventListener('click', function() {
					document.getElementById('all-groupbuy').style.display = 'block';
					document.body.style.overflowY = 'hidden'; // 스크롤 막기
				});
			</script>
		<c:set var="count" value="0" />
		 <c:forEach var="groupBuy" items="${groupBuyList}">
		 <c:if test="${count < 5}">
		    <div class="group">
		        <div class="group-user">
		            <li>${fn:substring(groupBuy.creatorName, 0, 1)}<c:forEach begin="1" end="${fn:length(groupBuy.creatorName)-2}" varStatus="loop"><c:out value="*" /></c:forEach>${fn:substring(groupBuy.creatorName, fn:length(groupBuy.creatorName)-1, fn:length(groupBuy.creatorName))}
		                <c:choose>
		                    <c:when test="${groupBuy.status eq 'waiting'}">(1/2)</c:when>
		                    <c:otherwise><li>(2/2)</li> <li class="success">공동구매완료</li></c:otherwise>
		                </c:choose>
		            </li>
		            <c:if test="${groupBuy.status eq 'waiting'}">
		                <button class="join-btn" data-groupbuy-id="${groupBuy.groupBuyID}">주문참여</button>
		            </c:if>
		        </div>
		    </div>
		    <c:set var="count" value="${count + 1}" />
		    </c:if>
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
		<button type="button" class="two-buy" id="two-buy">
			<li class="buy-price"><fmt:formatNumber value="${post.totalprice}" pattern="#,###"/>원</li>
			<li class="buy-go">2인 공동구매 시작하기</li>
		</button>
	</footer>
	<footer class="credit" id="credit">
		<button type="button" class="under" id="under"><img src="${pageContext.request.contextPath}/resources/img/under.svg" width="40" heigth="35"></button>
		<div class="credit-pro">
			<li class="credit-title">${post.title}</li>
			<div class="credit-buy">
				<li class="credit-price"><strong><fmt:formatNumber value="${post.totalprice}" pattern="#,###"/></strong>원</li>
				<div class="quantity">
					<button type="button" class="btn-dec" onclick='count("minus")'><img src="${pageContext.request.contextPath}/resources/img/-.svg" width="15" height="15"></button>
					<li class="quant" id="quant1">1</li>
					<button type="button" class="btn-inc" onclick='count("plus")'><img src="${pageContext.request.contextPath}/resources/img/+.svg" width="15" height="15"></button>
				</div>	
			</div>
		</div>
		<span class="delivery">
			<span>무료배송</span>
		</span>
		<div class="coupon">
			<button class="btn-coupon">쿠폰선택</button>
		</div>
		<div class="all-credit">
			<li class="all-pro">총 <strong id="quant2">1</strong>개</li>
			<li class="all-pro-price">총 금액
				<strong id="totalPrice"><fmt:formatNumber value="${post.totalprice}" pattern="#,###"/></strong>
				<span>원</span>
			</li>								
		</div>
		<form id="purchaseForm" action="${pageContext.request.contextPath}/member/purchase" method="post">
		    <input type="hidden" name="quantity" id="purchaseQuantity">
		    <input type="hidden" name="totalPrice" id="purchaseTotalPrice">
		    <input type="hidden" name="postId" id="postId" value="${post.postId}">
		</form>
		
		<form id="joinForm" action="${pageContext.request.contextPath}/member/purchase_join" method="post">
		  <input type="hidden" name="quantity1" id="purchaseQuantity1">
		  <input type="hidden" name="totalPrice1" id="purchaseTotalPrice1">
		  <input type="hidden" name="postId1" id="postId1" value="${post.postId}">
		  <input type="hidden" name="groupBuyID1" id="joinGroupBuyID1">
		</form>
		<script>
		    function submitForm(postId) {
		        // 현재 화면에 표시된 수량과 총 가격
		        let quantity = document.getElementById('quant1').innerText;
		        let totalPrice = document.getElementById('totalPrice').innerText.replace(/,/g, ''); // 콤마(,) 제거
		
		        console.log('quantity:', quantity);
		        console.log('totalPrice:', totalPrice);
		        console.log('postId:', postId);
		        
		        // hidden input 필드에 값 설정
		        document.getElementById('purchaseQuantity').value = quantity;
		        document.getElementById('purchaseTotalPrice').value = totalPrice;
		
		        // form 제출
		        document.getElementById('purchaseForm').submit();
		
		       
		    }
		    function submitjoinForm(postId, groupBuyId) {
		        // 현재 화면에 표시된 수량과 총 가격
		        let quantity = document.getElementById('quant1').innerText;
		        let totalPrice = document.getElementById('totalPrice').innerText.replace(/,/g, ''); // 콤마(,) 제거

		        
		        // hidden input 필드에 값 설정
		        document.getElementById('purchaseQuantity1').value = quantity;
		        document.getElementById('purchaseTotalPrice1').value = totalPrice;
		        document.getElementById('postId1').value = postId;
		        document.getElementById('joinGroupBuyID1').value = groupBuyId;
		        
		        console.log('quantity:', quantity);
		        console.log('totalPrice:', totalPrice);
		        console.log('postId:', postId);
		        console.log('groupBuyId:', groupBuyId);
		        
		        // form 제출
		        document.getElementById('joinForm').submit();
		    }
		</script>
		<button type="button" class="credit-two-buy" id="credit-buy" >
		    <li class="credit-buy-go">2인 공동구매 시작하기</li>
		</button>
		
		 <button type="button" class="credit-two-buy" id="credit-join-buy" >
		    <li class="credit-buy-go">2인 공동구매 참여하기</li>
		  </button>
	</footer>
	
	
<script type="text/javascript">
	// 2인 공동구매 시작하기 버튼에 이벤트 핸들러 추가
	$('#two-buy').click(function() {
	  // credit 보이기, two-buy 숨기기
	  $('#credit').show();
	  $('#two-buy').hide();

	  // credit-buy 버튼 보이기, credit-join-buy 버튼 숨기기
	  $('#credit-buy').show();
	  $('#credit-join-buy').hide();
	  
	  // 구매하기 버튼 클릭 시 purchaseForm 제출
	  $('#credit-buy').off('click').click(function() {
	    //$('#purchaseForm').submit();
		  submitForm(${post.postId});
	  });
	});

	let currentGroupBuyId; // 전역 변수 선언

	// 참여하기 버튼에 이벤트 핸들러 추가
	$('.join-btn').click(function() {
	  currentGroupBuyId = $(this).data('groupbuy-id'); // data-groupbuy-id 값 가져와서 전역 변수에 저장

	  // credit 보이기, two-buy 숨기기
	  $('#credit').show();
	  $('#two-buy').hide();

	  // credit-join-buy 버튼 보이기, credit-buy 버튼 숨기기
	  $('#credit-join-buy').show();
	  $('#credit-buy').hide();

	  // 구매하기 버튼 클릭 시 joinForm 제출
	  $('#credit-join-buy').off('click').click(function() {
	    submitjoinForm(${post.postId}, currentGroupBuyId); // 저장된 groupBuyId 값을 사용
	 
	  });
	});
</script>
	<script type="text/javascript">
	
	

	document.getElementById('under').addEventListener('click', function() {
		document.getElementById('credit').style.display = 'none';
		document.getElementById('two-buy').style.display = 'block';
	});
	
	function count(type)  {
	    // 결과를 표시할 element
	    const resultElement1 = document.getElementById('quant1');
	    const resultElement2 = document.getElementById('quant2');
	    const totalPriceElement = document.getElementById('totalPrice');
	    // 현재 화면에 표시된 값
	    let number = resultElement1.innerText;
	    // 더하기/빼기
	    if(type === 'plus') {
	        number = parseInt(number) + 1;
	    }else if(type === 'minus')  {
	        if(number > 1) 
	        number = parseInt(number) - 1;
	    }
	    
	    // 결과 출력
	    resultElement1.innerText = number;
	    resultElement2.innerText = number;
	    
	    // 총 금액 업데이트
	    totalPriceElement.innerText = (number * ${post.totalprice}).toLocaleString('ko-KR');
	    
	  
	}
	</script>
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