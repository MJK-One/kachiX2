<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/search.css?ver=3">

<title>같이의 가치-공동구매</title>
</head>
<body>
	<script>
	    $(document).ready(function() {
	      $('.search-btn').on('click', function() {
	        var query = $('.form-input').val();
	        var userId = '${user.userID}';
	        if (query.length > 0) {
	          // 검색어를 searchresult.jsp에 전달합니다.
	          window.location.href = '${pageContext.request.contextPath}/member/searchResult?query=' + encodeURIComponent(query);
	
	          // 검색어를 서버에 기록합니다.
	          $.post('${pageContext.request.contextPath}/search/record', { userId: userId, keyword: query }, function(data) {
	              console.log("Search recorded successfully.");
	          });
	        }
	      });
	    });
	</script>
	<script>
	    // 키워드 검색을 실행하는 함수
	    function searchKeyword(keyword) {
	        var userId = '${user.userID}';
	        // 검색어를 searchresult.jsp에 전달합니다.
	        window.location.href = '${pageContext.request.contextPath}/member/searchResult?query=' + encodeURIComponent(keyword);
	        // 검색어를 서버에 기록합니다.
	        $.post('${pageContext.request.contextPath}/search/record', { userId: userId, keyword: keyword }, function(data) {
	            console.log("Search recorded successfully.");
	        });
	    }
	</script>
	<div class="bbb">
		<div class="search-m">
			<div class="search-line">
				<button type="button"  onclick="showSearchJSP()" class="home"><img src="${pageContext.request.contextPath}/resources/img/back.svg" width="30" height="30"></button>
				<input class="form-input" autocomplete="off" aria-autocomplete="list" type="search" placeholder="상품을 검색해보세요!" value="">
				<button type="button" class="search-btn"><img src="${pageContext.request.contextPath}/resources/img/search2.svg" width="30" height="30"></button>
			</div>		
		</div>
		<div class="search-main">
			<div class="recent">
			    <div class="title">최근 검색어</div>
			    <button type="button" class="setting" onclick="toggleMenu()"><img src="${pageContext.request.contextPath}/resources/img/setting.svg" width="15" height="23">설정</button>
			    <div class="setting-menu hidden">
			        <button type="button" class="choice" onclick="toggleCancelButtons()">선택삭제</button>
			        <button type="button" onclick="deleteAll('${userId}')">전체삭제</button>
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
				<div class="box recent-items">
				    <c:choose>
				        <c:when test="${empty recentSearches}">
				            <div>최근 검색어가 없습니다.</div>
				        </c:when>
				        <c:otherwise>
				            <c:forEach var="recent" items="${recentSearches}">
							    <div class="btn recent1" id="${recent.searchId}">
							        <button type="button" class="search-ti" onclick="searchKeyword('${recent.keyword}')">${recent.keyword}</button>
							        <button type="button" class="cancel hidden" onclick="deleteSelected(${recent.searchId})"><img class="x"src="${pageContext.request.contextPath}/resources/img/x.svg" width="10" height="10"></button>
							    </div>
							</c:forEach>
				        </c:otherwise>
				    </c:choose>
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
				    <c:forEach var="popular" items="${popularSearches}" varStatus="status">
					    <div class="btn">
					        <p>${status.count}.</p>
					        <button type="button" class="pop-ti" onclick="searchKeyword('${popular}')">${popular}</button>            
					    </div>
					</c:forEach>
			    <script>
				    function deleteSelected(searchId) {
				        $.ajax({
				            url: '${pageContext.request.contextPath}/search/history/delete',
				            type: 'POST',
				            data: JSON.stringify([searchId]),
				            contentType: 'application/json',
				            success: function() {
				                // 'searchId'와 일치하는 ID를 가진 요소를 페이지에서 제거합니다.
				                $('#' + searchId).remove();
				            },
				            error: function() {
				                alert('삭제에 실패했습니다.');
				            }
				        });
				    }
						
				    function deleteAll(userId) {
				        if (confirm('최근 검색어를 모두 삭제하시겠습니까?')) {
				            $.ajax({
				                url: '${pageContext.request.contextPath}/search/history/delete/all',
				                type: 'POST',
				                data: { userId: userId },
				                success: function() {
				                    // '.recent-items' 클래스를 가진 요소의 하위 요소만 페이지에서 제거합니다.
				                    $('.recent-items .btn').remove();
				                },
				                error: function() {
				                    alert('삭제에 실패했습니다.');
				                }
				            });
				        }
				    }
				</script>
			</div>
		</div>
	</div>
</body>
</html>
