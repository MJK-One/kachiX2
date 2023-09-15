<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/brand.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">

<meta charset="UTF-8">
<title>오늘의 집</title>
</head>
<body>
<div class="brand">
	<div class="brand-title">
		<a href="${pageContext.request.contextPath}" ><img  class="logo" src="${pageContext.request.contextPath}/resources/images/로그인로고.jpg"></a>
		<div id="title">입점신청</div>
	</div>
   
   	<hr>
   	<form action="${pageContext.request.contextPath }/brand/brandinsert" method="POST">
		<div class="brand-info">
			<div><span class="title">회사정보</span></div>
			<table>
				<tr>
					<th>
		 			회사 이름<span class="red">*</span>
					</th>
					<td class="info-td">
		 			<div class="con">
		 				<input type="text" class="form-control" name="brand_name" placeholder="오늘의 집" required>
		 			</div>
					</td>
				</tr>
				<tr>
				<td></td>
				<td><span class="ex">※ 사업자등록증의 법인명 또는 상호명을 입력하세요.</span></td>
				</tr>
				<tr>
					<th>사업자 등록번호<span class="red">*</span></th>
					<td>
						<div class="con">
			 				<div class="serial_num"><input type="text" id="serial_num" name="serial_num1" placeholder="123" required class="form-control"></div><div class="left">-</div>
				  			<div class="serial_num"><input type="text" id="serial_num" name="serial_num2" placeholder="45" required class="form-control"></div><div class="left">-</div>
				  			<div class="serial_num"><input type="text" id="serial_num" name="serial_num3" placeholder="67890" required class="form-control"></div>
						</div>
					</td>
				</tr>
				<tr>
					<th>홈페이지</th>
					<td>
					<div class="con">
						<input type="text" class="form-control" name="homepage" placeholder="www.ohou.se">
					</div>
					</td>
				</tr>
			</table>
			<hr>
			<div><span class="title">영업담당자 정보</span></div>
			<table>
				<tr>
					<th>
		 			이름<span class="red">*</span>
					</th>
					<td class="info-td">
		 			<div class="con">
		 				<input type="text" class="form-control" name="name" placeholder="집냥이">
		 			</div>
					</td>
				</tr>
				<tr>
					<th>전화번호<span class="red">*</span></th>
					<td>
						<div class="con">
		 				<div class="serial_num"><input type="text" id="punm" name="punm1" placeholder="010" class="form-control"></div><div class="left">-</div>
			  			<div class="serial_num"><input type="text" id="punm" name="punm2" placeholder="1234" class="form-control"></div><div class="left">-</div>
			  			<div class="serial_num"><input type="text" id="punm" name="punm3" placeholder="5678" class="form-control"></div>
						</div>
					</td>
				</tr>
				<tr>
					<th>이메일<span class="red">*</span></th>
					<td>
					<div class="con">
						<input type="text" class="form-control" name="email" placeholder="zipnyang@ohou.se">
					</div>
					</td>
				</tr>
			</table>
			<hr>
			<div><span class="title">상품 정보</span></div>
			<table>
				<tr>
					<th>
		 				대표 브랜드 이름<span class="red">*</span>
					</th>
					<td>
		 			<div class="con bb">
		 				<input type="text" class="form-control" name="bname" placeholder="오늘의 집 가구">
		 			</div>
					</td>
				</tr>
				<tr>
					<th>
						상품소개<span class="red">*</span>
					</th>
					<td>
						<div class="cate">
							<c:forEach var="data" items="${major}">
								<div class="form-check form-check-inline">
								  	<input class="form-check-input" type="checkbox" id="category" value="${data.name}">
								  	<label class="form-check-label" for="inlineCheckbox1">${data.name}</label>
								</div>
	      					</c:forEach>
      					</div>	
					</td>
				</tr>
				<tr>
					<th>상품소개<span class="red">*</span></th>
					<td class="prtd">
					<div class="con">
						<textarea class="form-control" name="introduce" rows="2" placeholder="판매하시는 상품에 대한 설명을 입력해주세요"></textarea>
					</div>
					</td>
				</tr>
				<tr>
					<th>타입점 쇼핑몰<span class="red">*</span></th>
					<td class="prtd">
					<div class="con">
						<input type="text" class="form-control" name="othershop" placeholder="예시) 11번가, 쿠팡 등 현재 입점몰을 입력해주세요." >
					</div>
					</td>
				</tr>
			</table>
			<hr>
			<div id="agree">
				<span class="title">개인정보 수집 및 이용 동의</span>
			</div>
			<div id="margin">
				<p>㈜버킷플레이스는 개인정보보호법, 정보통신망 이용촉진 및 정보보호 등에 관한 법률 등 관련 법령상의 개인정보보호 규정을 준수하며, 판매자님이 입점신청 시 필요한 최소한의 개인 정보를 수집합니다. 개인정보 수집에 동의를 거부할 수 있으나 거부 시 입점 신청이 제한될 수 있습니다.</p>
			</div>
			<div>
				<table class="table">
					<tr>
						<td>목적</td>
						<td>항목</td>
						<td>보유기간</td>
					</tr>
					<tr>
						<td>판매자 식별, 입점 검토, 공지사항의 전달</td>
						<td>영업담당자의 이름/전화번호/이메일</td>
						<td><span id="bold">입점 처리 종료 시까지(입점 심사 탈락 시 결정일로부터 6개월 이내)</span></td>
					</tr>
				</table>
			</div>
		</div>
		
		<div class="agree">
			<input type="checkbox" id="agree" name="agree" 	style="width:25px;height:25px;">
     	 	<label for="agree">입점신청을 위한 개인정보 수집 및 이용에 동의 <span class="blue">(필수)</span></label>
		</div>
		<div class="mama">
			<button class="btn btn-info btn-lg" type="submit"><span id="white">입점신청 완료</span></button>
		</div>
   </form>
</div>
</body>
</html>