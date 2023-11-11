<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/timesale.css?after9">
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
							<jsp:useBean id="rnow" class="java.util.Date" />
							<fmt:parseNumber value="${rnow.time / (1000*60*60*24)}" integerOnly="true" var="nowfmtTime" scope="request"/>
							<fmt:parseNumber value="${post.salePeriod.time / (1000*60*60*24)}" integerOnly="true" var="saleperiod" scope="request"/>								
							마감임박 ${saleperiod - nowfmtTime}일 남음
						</div>
						<div class="ts-pro-name">${post.title}</div>
						<div class="ts-pro-price">
							<li class="ts-price1">${post.discountRate}%</li>						
							<li class="ts-price2"><fmt:formatNumber value="${post.totalprice}" pattern="#,###"/>원</li>							
							<li class="ts-price4"><fmt:formatNumber value="${post.price}" pattern="#,###"/>원</li>
							<li class="star"><img src="${pageContext.request.contextPath}/resources/img/star.svg" width="17" height="17"> 4.5</li>						
					 	</div>
				 	</div>
				 	</a>
				</c:if>
			 </c:forEach>			
		</div>
		<div class="ts-title">놓치면 후회할 가격 타임세일 초특가</div>
		<!--카테고리-->
		<div class="swiper-container category" id="category-t">
			<div class="swiper-wrapper">
				<!-- 전체 항목 먼저 보이게 -->
				<div class="swiper-slide product">
						<div class="cate-icon">
							<img src="${pageContext.request.contextPath}/resources/img/category/all.svg" width="60" height="60">
						</div>
						<div class="cate-name click">
							<span class="0">전체</span>
						</div>
			    </div>
			    <!-- 카테고리의 모든 항목을 순서대로 출력 -->		    
			    <c:forEach items="${categories}" var="category" >
			        <div class="swiper-slide product">
			                <div class="cate-icon">
			                    <img src="${pageContext.request.contextPath}/resources/img/category/${category.categoryName}.png" width="60" height="60">						
			                </div>
			                <div class="cate-name">
			                	<span class="${category.categoryId}">${category.categoryName}</span>
			                </div>
			        </div>
			    </c:forEach>
		    </div>	
		</div>
		<div class="cate-main-t">
			<c:forEach var="post" items="${posts}" >
			   <c:if test="${post.salePeriod >= now && post.salePeriod <= after}">
			      <a href="${pageContext.request.contextPath}/post/view/${post.postId}">
			         <div class="cate-product ${post.categoryId}">
			            <div class="pro-img">			            	
			            	<img src="${post.mainImageUrl}" alt="Post image">
			            </div>   
			            <div class="pro-name">${post.title}</div>
			            <div class="pro-price">
			                  <li class="price1"><fmt:formatNumber value="${post.price}" pattern="#,###"/>원</li>
			                  <li class="price2">${post.discountRate}%</li>
			                  <li class="price3"><fmt:formatNumber value="${post.totalprice}" pattern="#,###"/>원</li>
			               <div class="pro-info">
			                  <li><img src="${pageContext.request.contextPath}/resources/img/star.svg" width="17" height="17"> 4.5</li>
			               </div>
			               <div class="line"></div>
			             </div>   
			       </div>
			        </a> 
			    </c:if> 
			</c:forEach>
		</div>
	</div>
	<script>
	/*상단 고정*/
	$(function() {
		  var lnb = $("#category").offset().top;
		  $(window).scroll(function() {
		    var window = $(this).scrollTop();
		    if(lnb - 100 <= window) {
		      $("#category").addClass("fixed");
		    }else{
		      $("#category").removeClass("fixed");
		    }
		  })
	});
	/*스와이핑*/
	var swiper = new Swiper('.category', {
            slidesPerView: 'auto',
            preventClicks: true,
            preventClicksPropagation: false,
            observer: true,
            observeParents: true
        });
        var $snbSwiperItem = $('.category .swiper-wrapper .swiper-slide product a');
        $snbSwiperItem.click(function(){
            var target = $(this).parent();
            $snbSwiperItem.parent().removeClass('on')
            target.addClass('on');
            muCenter(target);
        })

        function muCenter(target){
            var snbwrap = $('.category .swiper-wrapper');
            var targetPos = target.position();
            var box = $('.category');
            var boxHarf = box.width()/2;
            var pos;
            var listWidth=0;
            
            snbwrap.find('.swiper-slide').each(function(){ listWidth += $(this).outerWidth(); })
            
            var selectTargetPos = targetPos.left + target.outerWidth()/2;
            if (selectTargetPos <= boxHarf) { // left
                pos = 0;
            }else if ((listWidth - selectTargetPos) <= boxHarf) { //right
                pos = listWidth-box.width();
            }else {
                pos = selectTargetPos - boxHarf;
            }
            
            setTimeout(function(){snbwrap.css({
                "transform": "translate3d("+ (pos*-1) +"px, 0, 0)",
                "transition-duration": "500ms"
            })}, 200);
        }
        
        /*카테고리 목록별 정렬*/
		$(document).ready(function(){
    		$(".swiper-slide.product").click(function() {
        		var classes = $(this).find('span').attr('class');  // span 클래스를 가져옴       	
        		var classArray = classes.split(" ");     // 공백으로 구분하여 배열로 변환   	
       			var category = classArray[0];   // 첫 번째 클래스가 카테고리 ID라고 가정하고 가져옴
         		$(".cate-product").hide();    // 모든 cate-product 클래스를 가진 div 숨기기     
         		// 모든 cate-name에 있는 click 클래스 제거 후, 선택된 cate-name에 click 클래스 추가
         		$('.cate-name').removeClass('click');  
         		$(this).find('.cate-name').addClass('click');
         		
	     		if (category === "0") {
	            	// 전체 버튼이 눌렸으면 모든 상품 표시 및 이미지 src 변경
	            	$(".cate-product").show();
		        	$('.cate-icon img').eq(0).attr('src', '${pageContext.request.contextPath}/resources/img/category/all.svg');
	            	return;
	    		} else {
		    		// 다른 카테고리가 선택되었을 때 전체 버튼의 이미지 src 값을 all-no.svg로 설정 
		    		$('.cate-icon img').eq(0).attr('src', '${pageContext.request.contextPath}/resources/img/category/all-no.svg');
	    		} 
	     		
		        // 선택된 카테고리의 div 만 보이게 하기
		        $('.cate-product.' + category).show();
    		});
		});
	</script>
</body>
</html>