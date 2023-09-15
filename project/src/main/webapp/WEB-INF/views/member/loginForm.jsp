<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/login.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="login">
			<form action="${ pageContext.request.contextPath }/member/login" method="post">
				
				<a href="${pageContext.request.contextPath}" ><img class="logo" src="${pageContext.request.contextPath}/resources/images/로그인로고.jpg"></a>
	
				<div class="ff"> 
					<input type="email" name="email" class="form-control" placeholder="이메일" >
				</div>
				<div class="ff">
					<input type="password" name="userpw" class="form-control" placeholder="비밀번호">
				</div>
					
				<button class="btn btn-info ff" type="submit"><span class="white">로그인</span></button>
				<section class="bb">
					<a href="${pageContext.request.contextPath }/member/pwreset">비밀번호 재설정</a>
					<a href="${pageContext.request.contextPath }/member/joinform">회원가입</a>
				</section>
			</form>
			<hr>
			<a href="#">비회원 주문 조회하기</a>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>