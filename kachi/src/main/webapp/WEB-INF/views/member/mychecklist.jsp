<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?ver=3">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/mychecklist.css?after">
<title>같이의 가치-공동구매</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<body>
	<div class="aaa">
		<header class="mychecklist-top">
			<div class="middle">
				<div class="left">
					<button type="button"  onclick="location.href = '${pageContext.request.contextPath}/'" class="back"><img src="${pageContext.request.contextPath}/resources/img/back.svg" width="30" height="30"></button>
					<img class="left-icon" src="${pageContext.request.contextPath}/resources/img/icon.jpg" width="50" height="50">
				</div>
				<div class="title">내가 찜한 상품</div>	
			</div>
		</header>
		<div class="screen"></div>
		<div class="check-num">
			<li class="all">전체</li>
			<li class="all-num">${wishlist.size()}</li>
		</div>
		<div class="check-main">
		    <c:forEach items="${wishlist}" var="post">
		        <a href="${pageContext.request.contextPath}/post/view/${post.postId}">
		            <div class="checklist">
		                <div class="check-img"><img src="${post.mainImageUrl}" alt="이미지"></div>
		                <div class="check-info">
		                    <div class="check-name">${post.title}</div>
		                    <div class="check-price1"><fmt:formatNumber value="${post.price}" pattern="#,###"/>원</div>
		                    <div class="check-price2">${post.discountRate}%</div>
		                    <div class="check-price3"><fmt:formatNumber value="${post.totalprice}" pattern="#,###"/>원</div>
		                    <div class="check-star">★★★★★</div>
		                </div>
		            </div>
		        </a>
		        <button type="button" class="cancel" data-post-id="${post.postId}">
				    <img class="x" src="/five/resources/img/x.svg" width="10" height="10">
				</button>
		    </c:forEach>
		</div>
	</div>
	
	<script>
$(document).ready(function() {
    $(".cancel").click(function() {
        var postId = $(this).data("post-id");

        $.ajax({
            url: "${pageContext.request.contextPath}/post/removeWishlist",
            type: "POST",
            data: {postId: postId},
            success: function() {
                location.reload(); // 페이지 새로고침
            },
            error: function(request, status, error) { // 서버와의 통신 실패
                alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });
    });
});
</script>
</body>
</html>