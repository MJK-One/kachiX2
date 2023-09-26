<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/main.css?after">
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
	  <div id='currentSlide'></div> <!-- Current Slide Number -->
	  <div id='totalSlides'>/5 </div> <!-- Total Slide Number -->
	  <div id='plus'>+</div>
  </div>
  <button id='prevSlide'><span> < </span> </button> <!-- Previous Button -->
  <button id='nextSlide'><span> > </span> </button> <!-- Next Button -->
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
		<c:forEach var="i" begin="1" end="17">
			<div class="swiper-slide product">
				<a href="#">
					<div class="cate-icon">
						<img src="${pageContext.request.contextPath}/resources/img/category/${i}.jpg" width="60" height="60">
					</div>
					<span class="text">${i}</span>
				</a>
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