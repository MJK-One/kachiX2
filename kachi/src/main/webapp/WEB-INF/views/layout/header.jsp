<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?after8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/header.css?after15">
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
				<button type="button" class="search" style="cursor:pointer;" onclick="showSearchJSP()">
					<li class="search-title">누가해도 맛있는 닭강정!</li>
					<img class="search-i" src="${pageContext.request.contextPath}/resources/img/search.svg" width="26" height="32">
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
				<a href="${pageContext.request.contextPath}/member/basket">
					<img class="basket" src="${pageContext.request.contextPath}/resources/img/basket.svg" width="45px" height="50px">
				</a>
				<div class="top-right">
					<c:choose>			        
				        <c:when test="${not empty sessionScope.loggedInUser}">
				            <a href="${pageContext.request.contextPath}/member/logout" class="nav-link px-2">
				            	<span class="login-txt">로그아웃</span>
				            </a> 
				        </c:when>
				        <c:otherwise> 
				            <a href="${pageContext.request.contextPath}/member/loginform" class="nav-link px-2" >
				            	<span class="login-txt">로그인</span>
				            </a> 
				        </c:otherwise> 
			    	</c:choose>
				</div>
		</div>
		<!--상단 메뉴바-->
		<script>
 		$(document).ready(function() {
		    $(".m").click(function(e) {
		        $(".m").removeClass("active");
		        $(this).addClass("active");
		    });
		});
 		
 		 // 스토어홈 메뉴 클릭시
        $(document).ready(function() {
        	loadMenu1();
		    $("#menu1").click(function(e) {
		        console.log("스토어홈 메뉴 클릭");
		        loadMenu1();
		    });
        // 베스트 메뉴 클릭시     
		    $("#menu2").click(function(e) {
		        console.log("베스트 메뉴 클릭");
		        $.ajax({
		            url: 'mainpage/best', // 여기에는 실제 요청을 보낼 서버의 엔드포인트를 입력해주세요.
		            type: 'GET',
		            success: function(response) {
		                console.log(response); // 응답을 콘솔에 출력
		                $('#main').html(response); // #main 요소의 내용을 응답으로 변경
		            },
		            error: function(error) {
		                console.log(error); // 에러를 콘솔에 출력
		            }
		        });
		    });		
        // 타임세일 메뉴 클릭시   
		    $("#menu3").click(function(e) {
		        console.log("타임세일 메뉴 클릭");
		
		        $.ajax({
		            url: 'mainpage/timesale', // 여기에는 실제 요청을 보낼 서버의 엔드포인트를 입력해주세요.
		            type: 'GET',
		            success: function(response) {
		                console.log(response); // 응답을 콘솔에 출력
		                $('#main').html(response); // #main 요소의 내용을 응답으로 변경
		            },
		            error: function(error) {
		                console.log(error); // 에러를 콘솔에 출력
		            }
		        });
		    });	
        // 신상품 메뉴 클릭시     
		    $("#menu4").click(function(e) {
		        console.log("신상품 메뉴 클릭");
		
		        $.ajax({
		            url: 'five/mainpage/newarticle', // 여기에는 실제 요청을 보낼 서버의 엔드포인트를 입력해주세요.
		            type: 'GET',
		            success: function(response) {
		                console.log(response); // 응답을 콘솔에 출력
		                $('#main').html(response); // #main 요소의 내용을 응답으로 변경
		            },
		            error: function(error) {
		                console.log(error); // 에러를 콘솔에 출력
		            }
		        });
		    });
        
		    function loadMenu1() {
		        $.ajax({
		            url: 'mainpage/storehome', // 요청을 보낼 서버의 엔드포인트
		            type: 'GET',
		            success: function(response) {
		                console.log(response); // 응답을 콘솔에 출력
		                $('#main').html(response); // #main 요소의 내용을 응답으로 변경
		            },
		            error: function(error) {
		                console.log(error); // 에러를 콘솔에 출력
		            }
		        });
		    }
		});

    	</script>
		<div class="top-2">
				<button class="m active" id="menu1">스토어홈</button>
				<button class="m" id="menu2">베스트</button>
				<button class="m" id="menu3">타임세일</button>
				<button class="m" id="menu4">신상품</button>		       
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