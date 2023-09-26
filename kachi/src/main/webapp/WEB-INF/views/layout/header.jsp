<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?ver=3">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/header.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/side.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>같이의 가치-공동구매</title>
</head>
<body>
<div class="aaa">
	<!--상단바-->
	<header class="top">
		<div class="top-1">
				<img class="icon" src="${pageContext.request.contextPath}/resources/img/icon.jpg" width="60" height="60">
				<div class="search">
					<img class="search-i" src="${pageContext.request.contextPath}/resources/img/search.png" width="30" height="30">
					<input>
				</div>
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
		<div class="top-2">
		<%
        	String pageChange;
    	%>
			<ul class="menu">
				<li><a href="?pageChange=/WEB-INF/views/mainpage/storehome.jsp"><span>스토어홈</span></a></li>
				<li><a href="?pageChange=/WEB-INF/views/mainpage/interest.jsp"><span>관심추천</span></a></li>
				<li><a href="?pageChange=/WEB-INF/views/mainpage/timesale.jsp"><span>타임세일</span></a></li>
				<li><a href="?pageChange=/WEB-INF/views/mainpage/newarticle.jsp"><span>신상품</span></a></li>
				<li><a href="${pageContext.request.contextPath}/postform"><span>포스트시험</span></a></li>
				<c:choose>
			    <c:when test="${sessionScope.loggedInUser != null and sessionScope.writePermission}">
		       		 <a href="${pageContext.request.contextPath}/post/create">글쓰기</a>
		    	</c:when>
			    <c:otherwise>
			    </c:otherwise>
			</c:choose>
			</ul>
		</div>
		<!-- 위로 가기 -->
		<a class="back-to-top"></a>
		<script type="text/javascript">
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
	</header>