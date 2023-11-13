<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/best.css?after">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.min.js"></script>
</head>
<body>
<div class="time-banner">
		<img src="${pageContext.request.contextPath}/resources/img/best.jpg" width="100%" height="100%">
</div>
<div class="newarticle">
	<div class="na-title">
		최근 인기 카테고리 베스트
	</div>
		<!--카테고리-->
		<div class="swiper-container category" id="category">
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
		<!--카테고리 게시물 화면-->
		<div class="cate-main">
		<c:set var="count" value="1" />
		<c:forEach var="post" items="${posts}">
		<c:if test="${post.postId >= 0}">
		      <a href="${pageContext.request.contextPath}/post/view/${post.postId}">
		         <div class="cate-product ${post.categoryId}" data-original-rank="${count}">
		         	<div class="rank">${count}</div>
		            <div class="pro-img"><img src="${post.mainImageUrl}" alt="Post image"></div>   
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
		<c:set var="count" value="${count + 1}" />
		</c:if>
		</c:forEach>
		</div>
		<script type="text/javascript">
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
				        var classes = $(this).find('span').attr('class');
				        var classArray = classes.split(" ");   
				        var category = classArray[0];   
				        $(".cate-product").hide();    
				        $('.cate-name').removeClass('click');  
				        $(this).find('.cate-name').addClass('click');
				        
				        if (category === "0") {
				            $(".cate-product").show();
				            $('.cate-icon img').eq(0).attr('src', '${pageContext.request.contextPath}/resources/img/category/all.svg');
				            // 전체 카테고리 선택시 원래 순위로 돌아가기
				            $(".cate-product").each(function() {
				                var originalRank = $(this).data('original-rank');
				                $(this).find('.rank').text(originalRank);
				            });
				            return;
				        } else {
				            $('.cate-icon img').eq(0).attr('src', '${pageContext.request.contextPath}/resources/img/category/all-no.svg');
				        } 
				        
				        var visiblePosts = $('.cate-product.' + category).show();
				        visiblePosts.each(function(index) {
				            $(this).find('.rank').text(index+1);
				        });
				    });
				});
		</script>
</div>
</body>
</html>