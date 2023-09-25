<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/main.css?">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.min.js"></script>
<!--광고 배너-->
<div class="outer">
	<ul class="slider">
  		<li class="slide slide">1</li>
  		<li class="slide slide">2</li>
  		<li class="slide slide">3</li>
  		<li class="slide slide">4</li>
 		<li class="slide slide">5</li>
 		<li class="slide slide">6</li>
	</ul>
  <div class="slideNum">
	  <div id='currentSlide'></div> <!-- Current Slide Number -->
	  <div id='totalSlides'>/6 </div> <!-- Total Slide Number -->
	  <div id='plus'>+</div>
  </div>
  <button id='prevSlide'>왼</button> <!-- Previous Button -->
  <button id='nextSlide'>오</button> <!-- Next Button -->
</div>
<script type="text/javascript">
	var sn = 0; // current slide number
	var totalSlides = $(".slide").length; // total slides
	// Show first slide initially
	$(".slider .slide").eq(sn).fadeIn();
	// Update currentSlide text
	$('#currentSlide').text(sn+1);
	$('#nextSlide').click(function(){
		sn++;
		slideMove();
		updateCurrentSlide();
	});
	$('#prevSlide').click(function(){
		sn--;
		slideMove();
		updateCurrentSlide();
	});
	function updateCurrentSlide() {
		if(sn >= totalSlides) { 
	    	sn = 0;
	  	} else if (sn < 0) {
	    	sn = totalSlides -1;
	  	}
	  	document.getElementById('currentSlide').innerText = sn +1;
	}
	function slideMove() {
	    $(".slider .slide").fadeOut(1000);
	    $(".slider .slide").eq(sn).fadeIn(1000);
	}
	// auto play
	var autoplay = setInterval(function(){
		sn++;
		slideMove();
		updateCurrentSlide();
	},3000);
	updateCurrentSlide();
</script>
<!--카테고리-->
<%
	String pageChange;
%>
<div class="swiper-container category" id="category">
	<div class="swiper-wrapper">
		<c:forEach var="i" begin="1" end="20">
			<div class="swiper-slide product">
				<a href="#"><span class="text">${i}안녕</span></a>
			</div>
		</c:forEach>
	</div>
</div>
	<script type="text/javascript">
	/*상단 고정*/
	$(function() {
		  var lnb = $("#category").offset().top;
		  $(window).scroll(function() {
		    var window = $(this).scrollTop();
		    if(lnb - 110 <= window) {
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
	</script>
<!--카테고리 게시물 화면-->
	<%
        String select = request.getParameter("pageChange");
 
        if (select == null) {
            select = "/WEB-INF/views/category/";
        }
    %>
<div class="cate-main">
	<jsp:include page="/WEB-INF/views/category/cate1.jsp" flush="false"/>
</div>