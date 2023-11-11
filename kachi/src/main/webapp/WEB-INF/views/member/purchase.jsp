<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/style.css?after">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/CSS/purchase.css?after7">
<!-- 제이쿼리 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous" type="text/javascript"></script>
<!-- 아임포트 -->
<script src ="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" type="text/javascript"></script>
<title>구매</title>
</head>
<body>
	<div class="aaa">
		<header class="purchase-top">
			<div class="middle">
				<div class="left">
					<button type="button"  onclick="location.href = '${pageContext.request.contextPath}/'" class="back"><img src="${pageContext.request.contextPath}/resources/img/back.svg" width="30" height="30"></button>
					<img class="left-icon" src="${pageContext.request.contextPath}/resources/img/icon.jpg" width="50" height="50">
				</div>
				<div class="title">주문 결제</div>	
			</div>
		</header>
		<div class="screen"></div>
		<div class="purchase-main">
		<!--배송지, 주문자명 입력  -->
			<section class="address-area">
			<!--등록된 배송지 불러오기-->
			<div class="adress-load" id="adress-load"> 
				<header>
					<h2>배송지 목록</h2>
					<button id="x-load"><img src="${pageContext.request.contextPath}/resources/img/x2.svg" width="30" height="30"></button>
				</header>	
				<div class="ad-load-list">
				</div>
			</div>	
				<form action="${pageContext.request.contextPath}/member/updateAdress" method="post" id='updatenewAdress'>
					<header class="area-title">
						<h2>배송지</h2>
					</header>
					<div class="address-item">
						<label for="same">주문자 정보와 동일</label>
					</div>
					<div class="address-item">
						<label class="address-label">수령자명</label>
						<input class="address-input" id="infonm" name="infonm" placeholder="수령자명" value="">
					</div>
					<div class="address-item">
						<label class="address-label">이메일</label>
						<input class="address-input" id="infonm" name="infonm" placeholder="이메일" value="">
					</div>
					<div class="address-item">
						<label class="address-label">전화번호</label>
						<input class="address-input" id="infonm" name="infonm" placeholder="전화번호" value="">
					</div>
					<div class="address-item">
						<button type="button" class="adress-find2" id="address-find">등록된 배송지 불러오기</button>
					</div>	
					<script>
					document.getElementById('x-load').addEventListener('click', function() {
					    document.getElementById('adress-load').style.display = 'none';
					});
					document.getElementById('address-find').addEventListener('click', function() {
					    document.getElementById('adress-load').style.display = 'block';
					});
					</script>			
					<div class="address-item">
						<label class="address-label">우편번호</label>
						<input class="address-input" id="sample6_postcode" name="infonm" placeholder="우편번호 입력" value="">
						<input class="adress-find" type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
					</div>
					<div class="address-item">
						<label class="address-label">주소</label>
						<input class="address-input" id="sample6_address" name="infonm" placeholder="주소 입력" value="">
					</div>
					<div class="address-item">
						<label class="address-label">상세 주소</label>
						<input class="address-input" id="sample6_detailAddress" name="infonm" placeholder="상세 주소" value="">
					</div>
					<div class="address-item">
						<label class="address-label">참고 항목</label>
						<input class="address-input" id="sample6_extraAddress" name="infonm" placeholder="참고 항목" value="">
					</div>
					<div class="address-item">
						<button type="submit" class="adress-find2" id="refund-account-btn">배송지 설정</button>
					</div>
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
			</section>
			<section class="product-area">
				<header class="area-title">
					<h2>주문 상품</h2>
				</header>
				<div class="del-item">
					<strong>무료배송</strong> 
					<strong class="del-day">11/13(월)</strong>
					<strong>도착</strong>
					<button class="ask"><img src="${pageContext.request.contextPath}/resources/img/ask.svg" width="16" height="16"></button>	
				</div>
				<div class="product-item">			
				    <div class="product-img"><img src="${post.mainImageUrl}" alt="Post image"></div>
				    <div class="product-details">
				        <div class="product-title">${post.title}</div>
				        <div class="product-price">
				        	<li class="pro-price"><fmt:formatNumber value="${totalPrice}" pattern="#,###"/></li> 원
				        	<span class="bar"></span>
				        	<li class="quan">${quantity}개</li>
				        </div>
				        <span class="group-purchase">2인 공동구매</span>
				    </div>
				</div>
			</section>
			<section class="credit-area">
				<header class="area-title">
					<h2>결제 금액</h2>
				</header>
				<div class="group-credit">
					<table class="credit-total">
						<tbody>
							<tr><th scope="row">상품금액</th><td><li><fmt:formatNumber value="${totalPrice}" pattern="#,###"/></li> 원</td></tr>
							<tr><th scope="row">배송비</th><td><li>0</li> 원<!-- --> </td></tr>
						</tbody>
							<tfoot><tr><th scope="row">총 결제금액</th><td><li><fmt:formatNumber value="${totalPrice}" pattern="#,###"/></li> 원</td></tr>
						</tfoot>
				</table>
				</div>
			</section>
			<section class="credit-area">
				<header class="area-title">
					<h2>결제 수단</h2>
				</header>
				<button id="payment-button">결제하기</button>
			</section>
		</div>
	</div>
</body>
<script type="text/javascript">
    var IMP = window.IMP; // 생략가능
    IMP.init('imp71850440'); // 가맹점 식별코드를 교체해주세요.
    
    function requestPay() { // 결제창 호출 함수
        IMP.request_pay({
            pg : 'html5_inicis', // 결제방식
            pay_method : 'card', // 결제 수단
            merchant_uid : 'merchant_' + new Date().getTime(), // 주문번호
            name : '주문명:결제테스트', // 주문명
            amount : 1000, // 결제금액
            buyer_email : 'iamport@siot.do', // 구매자 이메일
            buyer_name : '구매자이름', // 구매자 이름
            buyer_tel : '010-1234-5678', // 구매자 전화번호
            buyer_addr : '서울특별시 강남구 삼성동', // 구매자 주소
            buyer_postcode : '123-456' // 구매자 우편번호
        }, function(rsp) {
            if ( rsp.success ) {
                var msg = '결제가 완료되었습니다.';
                msg += '고유ID : ' + rsp.imp_uid;
                msg += '상점 거래ID : ' + rsp.merchant_uid;
                msg += '결제 금액 : ' + rsp.paid_amount;
                msg += '카드 승인번호 : ' + rsp.apply_num;
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
            }
            alert(msg);
        });
    }
    
    // 결제창 호출 버튼 클릭 이벤트
    document.getElementById('payment-button').addEventListener('click', function() {
        requestPay();
    });
</script>
</html> 
