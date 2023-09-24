<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/main.css?">

<!--광고 배너-->
<div class="outer">
	<ul class="slider">
	  <li class="slide slide1">1</li>
	  <li class="slide slide2">2</li>
	  <li class="slide slide3">3</li>
	  <li class="slide slide4">4</li>
	  <li class="slide slide5">5</li>
	</ul>
</div>
<!--카테고리-->
<%
	String pageChange;
%>
<div class="category">
	<div class="mySlides fade">
		<c:forEach var="i" begin="1" end="10">
			<div class="product">
				<li>${i}<li>
			</div>
		</c:forEach>
	</div>
	<div class="mySlides fade">
	  	<c:forEach var="i" begin="11" end="20">
			<div class="product">
				<li>${i}<li>
			</div>
		</c:forEach>
	</div>
	<div style="text-align:center">
	  <span class="dot" onclick="currentSlide(1)"></span> 
	  <span class="dot" onclick="currentSlide(2)"></span> 
	</div>
</div>
<script type="text/javascript">
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
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