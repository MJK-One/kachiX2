<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?after5">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/header.css?after5">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>같이의 가치-공동구매</title>
</head>
<body>
<div class="aaa">
	<!--상단바-->
	<header class="top">
		<div class="top-1">
				<img class="icon" src="${pageContext.request.contextPath}/resources/img/icon.jpg" width="60" height="60">
				<button type="button" class="search" style=" cursor: pointer;" onclick="location.href = '${pageContext.request.contextPath}/member/search'">					
					<img class="search-i" src="${pageContext.request.contextPath}/resources/img/search.svg" width="26" height="30">
				</button>
				<div class="login">
					<c:choose>			        
				        <c:when test="${not empty sessionScope.loggedInUser}">
				            <a href="${pageContext.request.contextPath}/member/logout" class="nav-link px-2"><img  src="${pageContext.request.contextPath}/resources/img/logout.png" width="40" height="40"></a> 
				        </c:when>
				        <c:otherwise> 
				            <a href="${pageContext.request.contextPath}/member/loginform" class="nav-link px-2" ><img  src="${pageContext.request.contextPath}/resources/img/login.png" width="40" height="40"></a> 
				        </c:otherwise> 
			    	</c:choose>
				</div>
		</div>
		<!--상단 메뉴바-->
		<script>
        $(document).ready(function() {
            $(".m a").click(function(e) {
                e.preventDefault();
                $(".m a").removeClass("active");
                $(this).addClass("active");

                var href = $(this).attr('href');
                
                // Load the content from the href attribute into the .main div
                $('.main').load(href);
            });
        });
    	</script>
		<div class="top-2">
			<ul class="menu">
				<li class="m"><a class="active" href="${pageContext.request.contextPath}/mainpage/storehome"><span>스토어홈</span></a></li>
				<li class="m"><a href="${pageContext.request.contextPath}/mainpage/interest"><span>관심추천</span></a></li>
				<li class="m"><a href="${pageContext.request.contextPath}/mainpage/timesale"><span>타임세일</span></a></li>
				<li class="m"><a href="${pageContext.request.contextPath}/mainpage/newarticle"><span>신상품</span></a></li>
		
		        <!-- Check if writePermission is true -->
		        <c:if test="${sessionScope.writePermission}">
		            <li class="m"><a href="${pageContext.request.contextPath}/admin/adminform"><span>관리자</span></a></li>
		        </c:if>
		    </ul>    
		</div>
	</header>
	
	<div class="top-screen"></div>
	<!-- 메인 화면 -->
	<div class="main">
		 <jsp:include page="/WEB-INF/views/mainpage/storehome.jsp" flush="false" />
	</div>
	
	<!-- 위로 가기 -->
	<a class="back-to-top"></a>
	<script type="text/javascript">
		/*위로 가기*/
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