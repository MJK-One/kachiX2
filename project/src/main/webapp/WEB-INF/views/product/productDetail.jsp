<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<%@ include file="/WEB-INF/views/layout/shopping.jsp" %>

<div class="container">
	<div class="product-main">
		<table>
			<tr>
				<td class="pr-td1">
					<img class="product-photo"src="${pageContext.request.contextPath}/resources/product/${vo.idx}/${vo.picture}">
				</td>
				<td>
					<div class="product-de">
						<div>
							<span class="pr-bn">${vo.brand_name }</span>
						</div>
						<div>
							<span class="pr-name">${vo.name }</span>
						</div>
						<div>
							<span class="pr-h">${h }% </span><span class="pr-price">${price }</span><span>원</span>
						</div>
						<div>
							<span class="pr-sale">${sale }</span><span class="won"> 원</span>
						</div>
						<div>
							<span class="pr-bn">배송비</span>
							<c:choose>
								<c:when test="${vo.delivery == 0 }">
									<span class="pr-de">무료배송</span>
								</c:when>
								<c:when test="${vo.delivery >= 10000 }">
									<span>${delivery }원 </span><span class="pr-de">업체직접배송(착불)</span>
								</c:when>
								<c:otherwise>
									<span>${delivery }원 </span>
								</c:otherwise>
							</c:choose>
						</div>
						<hr>
						<div>
							
						</div>
						<div>
							<button class="btn btn-info"><span class="white">장바구니</span></button>
							<button class="btn btn-info"><span class="white">바로구매</span></button>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="pr-info">
						상품정보
					</div>
					<div class="detail-content-2">
						${vo.info }
					</div>	
				
				</td>
			</tr>
		</table>
	</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>		