<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?after5">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/header.css?after9">
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
				<button type="button" class="search" style="cursor:pointer;" onclick="showSearchJSP()">
					<img class="search-i" src="${pageContext.request.contextPath}/resources/img/search.svg" width="26" height="30">
				</button>
				<script>
				  function showSearchJSP() {
				    var searchJSP = document.getElementById('search-jsp');
				    var bodyElement = document.getElementsByTagName('body')[0];
				    
				    // 버튼 클릭 시 search.jsp를 보여주기 위해 bottom 값을 조정합니다.
				    if (searchJSP.style.bottom === '-1000%' || searchJSP.style.bottom === '') {
				      searchJSP.style.bottom = '0';
				      searchJSP.scrollIntoView({ behavior: 'smooth' }); // 스크롤 애니메이션 적용
				      bodyElement.style.overflowY = 'hidden';
				      setTimeout(function() { // setTimeout을 사용하여 지연시킵니다.
				          searchJSP.style.top = '0';	
				        }, 500);				    	      	
				    } else {
				      searchJSP.style.bottom = '-1000%';
				      bodyElement.style.overflowY = 'auto';
				      searchJSP.style.position = '';
				      searchJSP.style.top = '';
				    }
				  }
				</script>
				<div class="m-login">
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
		    // 페이지 로딩 시 첫 번째 메뉴에 해당하는 섹션만 보여줍니다.
		    $('section').eq(0).removeClass('hidden');

		    $(".m").click(function(e) {
		        $(".m").removeClass("active");
		        $(this).addClass("active");

		        var index = $(this).index();

		        // 모든 섹션을 숨깁니다.
		        $('section').addClass('hidden');

		        // 클릭한 메뉴에 해당하는 섹션만 보여줍니다.
		        $('section').eq(index).removeClass('hidden');
		    });
		});
    	</script>
		<div class="top-2">
			<ul class="menu">
				<li class="m active"><span>스토어홈</span></a></li>
				<li class="m"><span>관심추천</span></a></li>
				<li class="m"><span>타임세일</span></a></li>
				<li class="m"><span>신상품</span></a></li>
		        <!-- Check if writePermission is true -->
		        <c:if test="${sessionScope.writePermission}">
		            <li class="m"><a href="${pageContext.request.contextPath}/admin/adminform"><span>관리자</span></a></li>
		        </c:if>
		    </ul>    
		</div>
	</header>
	<div id="search-jsp" class="search-jsp">
		<jsp:include page="/WEB-INF/views/member/search.jsp" flush="false" />
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