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
		<div class="bot-my">1</div>
		<div class="bot-my">2</div>
		<div class="bot-my">3</div>
		<div class="bot-my2">4</div>
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