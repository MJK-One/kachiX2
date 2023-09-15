<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css">

<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

<title>오늘의 집</title>
</head>
<body>
	<header class="pt-3">
		<div class="container">
			<div class="row">
				
        		<ul class="nav col-5">
        			<li><a href="${pageContext.request.contextPath}" ><img class="logo" src="${pageContext.request.contextPath}/resources/images/로고.png"></a></li>
          			<li class="h-f"><a href="${pageContext.request.contextPath}/community/mainpage" class="nav-link px-4">커뮤니티</a></li>
          			<li class="h-f"><a href="${pageContext.request.contextPath}/shopping/mainpage" class="nav-link px-4">쇼핑</a></li>
          			<li class="h-f"><a href="${pageContext.request.contextPath}/move/mainpage" class="nav-link px-4">이사/시공/생활</a></li>
        		</ul>

		        <form class="col-2">
		          	<input type="search" class="form-control mt-1" placeholder="통합검색" aria-label="Search">
		        </form>
				<ul class="nav col-5">
					<c:choose>
						<c:when test="${!empty login }">
							<li><a href="${pageContext.request.contextPath}/" class="nav-link py-1"><i class="bi bi-bookmark"></i></a></li>
		          			<li><a href="${pageContext.request.contextPath }/" class="nav-link py-1"><i class="bi bi-bell"></i></a></li>
		          			<li><a href="${pageContext.request.contextPath}/member/loginform" class="nav-link py-1"><i class="bi bi-cart"></i></a></li>
		          			<li>
		          			<div class="dropdown dddd">
								<a href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
								  	<span>${login.nickname }님</span>
								</a>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item" href="${pageContext.request.contextPath}/mypage/mypage?idx=${login.idx}">마이페이지</a></li>
									<li><a class="dropdown-item" href="">나의 쇼핑</a></li>
									<li><a class="dropdown-item" href="${pageContext.request.contextPath}/brand/brandupload">판매자 신청</a></li>
									<li><a class="dropdown-item" href="#">고객센터</a></li>
									<li><a class="dropdown-item" href="${pageContext.request.contextPath}/member/logout">로그아웃</a></li>
								</ul>
							</div>
							</li>
		          		</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/member/loginform" class="nav-link py-1"><i class="bi bi-cart"></i></a></li>
		          			<li><a href="${pageContext.request.contextPath}/member/loginform" class="nav-link px-2">로그인</a></li>
		          			<li><a href="${pageContext.request.contextPath }/member/joinform" class="nav-link px-2">회원가입</a></li> 
		          			<li><a href="#" class="nav-link px-2">고객센터</a></li>
		          		</c:otherwise>
					</c:choose>
					<li>
					
						<div class="dropdown">
							<a class="btn btn-info dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
							  	<span class="white">글쓰기</span>
							</a>
							
							<ul class="dropdown-menu">
								<li><a class="dropdown-item " href="${pageContext.request.contextPath}/community/postupload?kind=사진">사진</a></li>
								<li><a class="dropdown-item" href="${pageContext.request.contextPath}/community/postupload?kind=집들이">집들이</a></li>
								<li><a class="dropdown-item" href="${pageContext.request.contextPath}/community/postupload?kind=노하우">노하우</a></li>
								<li><a class="dropdown-item" href="${pageContext.request.contextPath}/community/postupload?kind=이벤트">이벤트</a></li>
								<li><a class="dropdown-item" href="#">상품 리뷰</a></li>
								<c:choose>
									<c:when test="${!empty login && (login.userkind == 1 || login.userkind == 2)}">
										<li><a class="dropdown-item" href="${pageContext.request.contextPath }/product/upload">상품 등록</a></li>
									</c:when>
								</c:choose>
							</ul>
						</div>
					</li>
		        </ul>
      	</div>
    </div>
</header>

