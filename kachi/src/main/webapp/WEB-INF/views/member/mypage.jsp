<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?after2">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/mypage.css?after12">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.min.js"></script>
<title>같이의 가치-공동구매</title>
</head>
<body>
	<div class="aaa">
		<header class="mypage-top">
			<div class="middle">
				<div class="left">
					<button type="button"  onclick="location.href = '${pageContext.request.contextPath}/'" class="back"><img src="${pageContext.request.contextPath}/resources/img/back.svg" width="30" height="30"></button>
					<img class="left-icon" src="${pageContext.request.contextPath}/resources/img/icon.jpg" width="50" height="50">
				</div>
				<div class="title">MY 공구</div>	
			</div>
		</header>
		<div class="screen"></div>
		<div class="login">
			<c:choose>		        
				<c:when test="${not empty sessionScope.loggedInUser}">
			    	<li>회원이름 : </li>
			    	<li><strong>${sessionScope.loggedInUser.name}</strong></li>
			    </c:when>	        
			    <c:otherwise> 
			    	<li>로그인해 주세요</li>
			    	<button type="button" onclick="location.href='${pageContext.request.contextPath}/member/loginform';">로그인</button>
			    </c:otherwise> 
			</c:choose>
		</div>
		<div class="mypage-cate">
			<a href="">
				<div class="bot-my">
					<img src="${pageContext.request.contextPath}/resources/img/mypage/coupon.svg" width="60px" height="60px">
					<p>내 쿠폰</p>
				</div>
			</a>
			<a href="">
				<div class="bot-my">
					<img src="${pageContext.request.contextPath}/resources/img/mypage/box.svg" width="60px" height="60px">
					<p>주문/배송</p>
				</div>
			</a>
			<a href="">
				<div class="bot-my">
					<img src="${pageContext.request.contextPath}/resources/img/mypage/cart.svg" width="60px" height="60px">
					<p>장바구니</p>
				</div>
			</a>
			<a href="">
				<div class="bot-my">
					<img src="${pageContext.request.contextPath}/resources/img/mypage/pen.svg" width="60px" height="60px">
					<p>상품후기</p>
				</div>
			</a>
		</div>
		<div class="save"> <!--찜목록-->
			<li class="save-title">나의 찜 목록</li>
			<li class="save-info">최근 10개의 찜</li>
			<button type="button" onclick="location.href = '${pageContext.request.contextPath}/member/mychecklist'">전체보기</button>
			<c:choose>		        
				<c:when test="${not empty sessionScope.loggedInUser}">
			    	<c:choose>
    <c:when test="${not empty wishlist}">
        <div class="swiper-container save-list" id="save-list">
            <div class="swiper-wrapper">
                <c:forEach items="${wishlist}" var="post" varStatus="status">
                    <c:if test="${status.index < 10}"> <!-- 최근 10개의 찜 게시물만 보여줌 -->
                        <div class="swiper-slide product">
                            <a href="${pageContext.request.contextPath}/post/view/${post.postId}">
                                <div class="pro-img"><img src="${post.mainImageUrl}" alt="이미지"></div>
                                <div class="pro-name">${post.title}</div>
                                <div class="pro-price">
                                    <!--할인률--><li class="price1">${post.discountRate}%</li>
                                    <li class="price2"><fmt:formatNumber value="${post.totalprice}" pattern="#,###"/>원</li>
                                    <!--원가--><li class="price3"><fmt:formatNumber value="${post.price}" pattern="#,###"/>원</li>
                                    <li class="star"><img src="${pageContext.request.contextPath}/resources/img/star.svg" width="17" height="17"> 4.5</li>
                                </div>
                                <div class="pro-star"><li><img src="${pageContext.request.contextPath}/resources/img/star.svg" width="17" height="17"> 4.5</li></div>
                            </a>  
                        </div>          
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </c:when>
    <c:otherwise> 
        <div class="save-list">
            <div class="warning">
                <img class="warning-img" src="${pageContext.request.contextPath}/resources/img/warning.svg" width="80" height="80"><img>
                <p>내가 찜한 상품이 없습니다.</p>
            </div>
        </div>
    </c:otherwise> 
</c:choose>
			    </c:when>	        
			    <c:otherwise> 
			    	<div class="save-list">
			    		<div class="warning">
				    		<img class="warning-img" src="${pageContext.request.contextPath}/resources/img/warning.svg" width="80" height="80"><img>
				    		<p>내가 찜한 상품이 없습니다.</p>
			    		</div>
			    	</div>
			    </c:otherwise> 
			</c:choose>			
		</div>
		<script type="text/javascript">
		/*스와이핑*/
		var swiper = new Swiper('.save-list', {
	            slidesPerView: 'auto',
	            preventClicks: true,
	            preventClicksPropagation: false,
	            observer: true,
	            observeParents: true
	        });
	        var $snbSwiperItem = $('.save-list .swiper-wrapper .swiper-slide product a');
	        $snbSwiperItem.click(function(){
	            var target = $(this).parent();
	            $snbSwiperItem.parent().removeClass('on')
	            target.addClass('on');
	            muCenter(target);
	        })

	        function muCenter(target){
	            var snbwrap = $('.save-list .swiper-wrapper');
	            var targetPos = target.position();
	            var box = $('.save-list');
	            var boxHarf = box.width()/2;
	            var pos;
	            var listWidth=0;
	            
	            snbwrap.find('.swiper-slide').each(function(){ listWidth += $(this).outerWidth(); })
	            
	            var selectTargetPos = targetPos.left + target.outerWidth()/2;
	            if (selectTargetPos <= boxHarf) { // left
	                pos = 0;
	            }else if ((listWidth - selectTargetPos) <= boxHarf) { //right
	                pos = listWidth-box.width();
	            }else {
	                pos = selectTargetPos - boxHarf;
	            }
	            
	            setTimeout(function(){snbwrap.css({
	                "transform": "translate3d("+ (pos*-1) +"px, 0, 0)",
	                "transition-duration": "500ms"
	            })}, 200);
	        }
		</script>
		<div class="customer-btn">
			<li>개인정보 수정</li>
			<c:choose>
				<c:when test="${not empty sessionScope.loggedInUser}">
					<button type="button" class="right" onclick="modify()"><img src="${pageContext.request.contextPath}/resources/img/mypage/right.svg" width="9px" height="14px"></button>
				</c:when>
				<c:otherwise>
					<button type="button" class="right" onclick="ale()"><img src="${pageContext.request.contextPath}/resources/img/mypage/right.svg" width="9px" height="14px"></button>
				</c:otherwise>
			</c:choose>
		</div>
		<script type="text/javascript">
		function modify() {
			var modify = document.querySelector('.customer');
		     if (modify.classList.contains('hidden')) {
		    	 modify.classList.remove('hidden');
		     } else {
		    	 modify.classList.add('hidden');
		     }
		}
		function ale() {
			alert("로그인이 필요합니다.");
		}
		</script>
		<div class="customer hidden">
			<table class="n-table table-row">
                    <colgroup>
                        <col style="width:190px">
                        <col style="width:*">
                        <col style="width:50%">
                    </colgroup>
                    <tbody>
                   	<tr>
					    <th scope="row">닉네임</th>
					    <td><strong>${sessionScope.loggedInUser.nickname}</strong></td>
					    <td>
					        <form action="${pageContext.request.contextPath}/member/updateNickname" method="post" id='updateNicknameForm'>
					       
					            <input type="text" name="newNickname" placeholder="새 닉네임 입력" id='newNickname'>
					            <!-- CSRF 토큰 추가 -->
					            <input type = "hidden" name = "${_csrf.parameterName}" value = "${_csrf.token}"/>
					            <button type="submit" class="n-btn w100 btn-sm btn-default cert-hidden" id="refund-account-btn">수정</button>
					        </form>
					        <script>
					        document.getElementById('updateNicknameForm').addEventListener('submit', function(event) {
					        	var newNickname = document.getElementById('newNickname').value;

					        	if (!newNickname.trim()) {
						        	alert('닉네임을 입력해주세요.');
						        	event.preventDefault();
					        	}
					        	});
					        </script>
					    </td>
					</tr>
					                   
                    
                    <tr>
                        <th scope="row">환불계좌</th>
                        <td><strong id="refund-account" style="color: rgb(255, 83, 0);">환불 받을 계좌를 등록해 주세요.</strong></td>
                        <td>
                            <button type="button" class="n-btn w100 btn-sm btn-default cert-hidden" id="refund-account-btn">환불계좌 관리</button>
                        </td>
                    </tr>
                    <tr id="address-area">
                        <th scope="row">배송지</th>
                        <td><button type="button" id="viewAddressBtn" class="n-btn w100 btn-sm btn-default cert-hidden">배송지 확인</button></td>
                        	<script>
								document.getElementById("viewAddressBtn").addEventListener("click", function() {
								    window.open("${pageContext.request.contextPath}/member/addressList", "배송지 목록", "width=770,height=600");
								});
							</script>
                        <td>
                         <form action="${pageContext.request.contextPath}/member/updateAdress" method="post" id='updatenewAdress'>
                            <input type="text" id="sample6_postcode" placeholder="우편번호" name="postcode">
							<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
							<input type="text" id="sample6_address" placeholder="주소" name="streetAddress"><br>
							<input type="text" id="sample6_detailAddress" placeholder="상세주소" name="detailAddress1">
							<input type="text" id="sample6_extraAddress" placeholder="참고항목" name="detailAddress2">
							<button type="submit" class="n-btn w100 btn-sm btn-default cert-hidden" id="refund-account-btn">배송지 설정</button>
							<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
							<script>
							    function sample6_execDaumPostcode() {
							        new daum.Postcode({
							            oncomplete: function(data) {
							                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
							
							                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
							                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							                var addr = ''; // 주소 변수
							                var extraAddr = ''; // 참고항목 변수
							
							                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
							                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							                    addr = data.roadAddress;
							                } else { // 사용자가 지번 주소를 선택했을 경우(J)
							                    addr = data.jibunAddress;
							                }
							
							                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
							                if(data.userSelectedType === 'R'){
							                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
							                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
							                        extraAddr += data.bname;
							                    }
							                    // 건물명이 있고, 공동주택일 경우 추가한다.
							                    if(data.buildingName !== '' && data.apartment === 'Y'){
							                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
							                    }
							                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							                    if(extraAddr !== ''){
							                        extraAddr = ' (' + extraAddr + ')';
							                    }
							                    // 조합된 참고항목을 해당 필드에 넣는다.
							                    document.getElementById("sample6_extraAddress").value = extraAddr;
							                
							                } else {
							                    document.getElementById("sample6_extraAddress").value = '';
							                }
							
							                // 우편번호와 주소 정보를 해당 필드에 넣는다.
							                document.getElementById('sample6_postcode').value = data.zonecode;
							                document.getElementById("sample6_address").value = addr;
							                // 커서를 상세주소 필드로 이동한다.
							                document.getElementById("sample6_detailAddress").focus();
							            }
							        }).open();
							    }
							    
							    document.getElementById('updatenewAdress').addEventListener('submit', function(event) {
								    var postcode = document.getElementById('sample6_postcode').value;
								    var address = document.getElementById('sample6_address').value;
								    
								    if (!postcode.trim() || !address.trim()) {
								        alert('우편번호와 주소를 입력해주세요.');
								        event.preventDefault();
								    }
								});
							</script>
							</form>
                        </td>
                    </tr>
                    </tbody>
                </table>
		</div>
		<div class="under-ad">
			<img src="${pageContext.request.contextPath}/resources/img/mypage/guide.png" width="100%" height="280px">
		</div>
	</div>
</body>
</html>
