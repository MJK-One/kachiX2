<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/header.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/side.css">
<title>같이의 가치-공동구매</title>
</head>
<body>
<div class="container">
	<header class="top">
		<div class="top-1">
				<img class="icon" src="${pageContext.request.contextPath}/resources/img/icon.jpg" width="60" height="60">
				<div class="search">
					<img class="search-i" src="${pageContext.request.contextPath}/resources/img/search.png" width="30" height="30">
					<input>
				</div>
				<a href="${pageContext.request.contextPath}/member/loginform" class="nav-link px-2"><img class="login" src="${pageContext.request.contextPath}/resources/img/login.png" width="40" height="40"></a>
		</div>
		<div class="top-2">
			<ul class="menu">
				<li class="item"><a class="active"><span>메인스토어</span></a></li>
				<li class="item"><a><span>타임 세일</span></a></li>
				<li class="item"><a><span>이벤트</span></a></li>
			</ul>
		</div>
	</header>
