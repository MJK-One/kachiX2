<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/storehome.css?after5">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.min.js"></script>
<!--광고 배너-->
<div class="outer">
	<ul class="slider">
		<c:forEach var="i" begin="1" end="5">
	  		<li class="slide slide"><img src="${pageContext.request.contextPath}/resources/img/advertisement/${i}.PNG" width="100%" height="100%"></li>
	 	</c:forEach>
	</ul>
  	<div class="slideNum">
		  <div id='currentSlide'>1</div> <!-- Current Slide Number -->
		  <div id='totalSlides'>/5 </div> <!-- Total Slide Number -->
		  <div id='plus'>+</div>
  	</div>
</div>

<script type="text/javascript">
//slide action
var sn = 0;//슬라이드 넘버
var slide_len = $(".slide").length;//슬라이드의 갯수
$(".slider .slide").eq(0).fadeIn();//첫번째 슬라이드 표시

function slide_move(){
  if(sn >= slide_len) {//슬라이드 최대 수를 제어
    sn = 0;
  } else if(sn < 0){//슬라이드 최저 수를 제어
    sn = slide_len-1;
  }
  
  // Update the currentSlide div with the current slide number.
  $('#currentSlide').text(sn + 1);

  $(".slider .slide").fadeOut('3000');//모든 슬라이드 fade out
  $(".slider .slide").eq(sn).fadeIn('3000');//번호에 맞는 슬라이드 fade in
  
}

// auto play
var autoplay = null;
autoplay = setInterval(slide_auto, 3000);//슬라이드에 오토 걸기

function slide_auto(){
	sn++;
	slide_move();
}
</script>
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
<script>
   

    function numberWithCommas(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
</script>

<c:forEach var="post" items="${posts}" varStatus="status">
   <c:if test="${post.postId >= 0}">
      <a href="${pageContext.request.contextPath}/post/view/${post.postId}">
         <div class="cate-product ${post.categoryId}">
            <div class="pro-img"><img src="${post.mainImageUrl}" alt="Post image"></div>   
            <div class="pro-name">${post.title}</div>
            <div class="pro-price">
                  <li class="price1" id="price1-${status.index}"></li>
                  <script>document.getElementById('price1-${status.index}').innerText = numberWithCommas(${post.price}) + ' 원'; </script>
               <li class="price2">${post.discountRate}%</li>
               <!-- 가격과 할인율로 실제 판매가격 계산 -->
               <li class="price3" id="price3-${status.index}"></li>
			   <script>document.getElementById('price3-${status.index}').innerText = numberWithCommas(${post.totalprice}) + ' 원';</script>
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