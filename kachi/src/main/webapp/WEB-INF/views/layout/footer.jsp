<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> 
<style>
	.bot{
		background-color : white;
		position : fixed;
		bottom : 0;
		width : 1001px;
		height : 56px;
		transition: top 0.2s ease-in-out, bottom 0.2s ease-in-out;
		z-index: 9999;
		border-top : 2px solid #e1e1e1;
	}
	.nav-down {
    		bottom: -60px;
    		top: auto;
	}
	.bot-my {
		float : left;
		height : 100%;
		width : 248px;
		text-align: center;
	}	
</style>
	<footer class="bot">
		<a href="">
				<div class="bot-my">
					<img src="${pageContext.request.contextPath}/resources/img/footer/home.png" width="50px" height="50px">
				</div>
		</a>
		<a href="">
				<div class="bot-my">
					<img img id="coupon" src="${pageContext.request.contextPath}/resources/img/footer/coupon.png" width="50px" height="50px">
				</div>
		</a>
		<a href="">
				<div class="bot-my">
					<img id="heart" src="${pageContext.request.contextPath}/resources/img/footer/heart.png" width="50px" height="50px">
				</div>
		</a>	
		<a href="${pageContext.request.contextPath}/member/mypage">
				<div class="bot-my">
					<img id="mypage" src="${pageContext.request.contextPath}/resources/img/footer/mypage.png" width="50px" height="50px">
				</div>
		</a>	
	</footer>
	<script type="text/javascript">
		$(function(){			  
			  $(window).scroll(function() {
			    if ($(document).scrollTop() > 300) {
			      $('.bot').addClass('nav-down');
			    } else {
			      $('.bot').removeClass('nav-down');
			    }
			  });
			});
		/*마우스 올릴시 색 변경*/
		$(document).ready(function() {
		    $('.bot-my').eq(1).hover(function() { // 두 번째 bot-my
		     	 var $img = $(this).find('img');
		     	 var newImgSrc = $img.attr('src') === '${pageContext.request.contextPath}/resources/img/footer/coupon.png' ? '${pageContext.request.contextPath}/resources/img/footer/coupon-ac.png' : '${pageContext.request.contextPath}/resources/img/footer/coupon.png';
			     $img.attr('src', newImgSrc);
		    });
		
		    $('.bot-my').eq(2).hover(function() { // 세 번째 bot-my
		    	  var $img = $(this).find('img');	
		    	  var newImgSrc = $img.attr('src') === '${pageContext.request.contextPath}/resources/img/footer/heart.png' ? '${pageContext.request.contextPath}/resources/img/footer/heart-ac.png' : '${pageContext.request.contextPath}/resources/img/footer/heart.png';
		          $img.attr('src', newImgSrc);
		    });
		
		    $('.bot-my').eq(3).hover(function() { // 네 번째 bot-my
			    var $img = $(this).find('img');
			    var newImgSrc = $img.attr('src') === '${pageContext.request.contextPath}/resources/img/footer/mypage.png' ? '${pageContext.request.contextPath}/resources/img/footer/mypage-ac.png' : '${pageContext.request.contextPath}/resources/img/footer/mypage.png';
			    $img.attr('src', newImgSrc);
			});
		});
	</script>
</div>
</body>
</html>