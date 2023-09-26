<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.bot{
		background-color : white;
		position : fixed;
		bottom : 0;
		width : 1001px;
		height : 50px;
		transition: top 0.2s ease-in-out, bottom 0.2s ease-in-out;
		z-index: 9999;
	}
	.nav-down {
    		bottom: -50px;
    		top: auto;
	}
	.bot-my {
		border : 1px solid gray;
		float : left;
		height : 100%;
		width : 248px;
		text-align: center;
	}	
	.bot-my2 {
		border : 1px solid gray;
		float : left;
		height : 100%;
		width : 250px;
		text-align: center;
	}	
</style>
	<footer class="bot">
		<c:forEach var="i" begin="1" end="4">
			<div class="bot-my"><img src="${pageContext.request.contextPath}/resources/img/footer/${i}.jpg" width="30px" height="30px"></div>
		</c:forEach>
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
	</script>
</div>
</body>
</html>