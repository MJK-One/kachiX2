<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/search.css?after3">

<title>같이의 가치-공동구매</title>
</head>
<body>
	<div class="aaa">
		<header class="search">
			<div class="search-line">
				<button type="button"  onclick = "location.href = '${pageContext.request.contextPath}/'" class="home"><img src="${pageContext.request.contextPath}/resources/img/back.svg" width="30" height="30"></button>
				<input class="form-input" autocomplete="off" aria-autocomplete="list" type="search" placeholder="상품을 검색해보세요!" value="">
				<button type="button" class="search-btn"><img src="${pageContext.request.contextPath}/resources/img/search2.svg" width="30" height="30"></button>
			</div>		
		</header>
		<div class="search-main">
			<div class="recent">
				<div class="title">최근 검색어</div>
				<button type="button" class="setting" onclick="toggleMenu()"><img src="${pageContext.request.contextPath}/resources/img/setting.svg" width="15" height="23">설정</button>
				<div class="setting-menu hidden">
					<button type="button" class="choice" onclick="toggleCancelButtons()">선택삭제</button>
					<button type="button">전체삭제</button>
				</div>
				<script>
				function toggleMenu() {
				     var menu = document.querySelector('.setting-menu');
				     if (menu.classList.contains('hidden')) {
				         menu.classList.remove('hidden');
				     } else {
				         menu.classList.add('hidden');
				     }
				}
				</script>
			</div>
			<div class="box">
				<c:forEach var="i" begin="1" end="2" >
					<div class="btn">
						<button type="button" class="search-ti">${i}</button>
						<button type="button" class="cancel hidden"><img src="${pageContext.request.contextPath}/resources/img/x.svg" width="10" height="10"></button>
					</div>
				</c:forEach>
			</div>	
			<script>
			function toggleCancelButtons() {
			    var buttons = document.querySelectorAll('.cancel');
			    var isHidden = buttons[0].classList.contains('hidden');

			    for (var i = 0; i < buttons.length; i++) {
			        if (isHidden) {
			            buttons[i].classList.remove('hidden');
			        } else {				     
			            buttons[i].classList.add('hidden');
			        }
			    }
			}
			</script>	
			<div class="pop">
				<div class="title">인기 검색어</div>
			</div>
			<div class="box">
				<c:forEach var="i" begin="1" end="2" >
					<div class="btn">
						<p>${i}.</p>
						<button type="button" class="pop-ti">인기검색어</button>			
					</div>
				</c:forEach>
			</div>	
		</div>
	</div>
</body>
</html>
