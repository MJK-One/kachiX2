<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<%@ include file="/WEB-INF/views/layout/shopping.jsp" %>
<div class="container">
	<div class="left">
		<div class="accordion">
			<ul class="list-unstyled ps-0">
				<c:forEach var="vo" items="${major }">
					<li class="mb-1">
						<button
							class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
							data-bs-toggle="collapse" data-bs-target="#ma_${vo.idx }"
							aria-expanded="false" onclick="majorclick(${vo.idx}, this)"><span class="major">${vo.name}</span></button>
						<div class="collapse" id="ma_${vo.idx }">
							<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small cate">
								<c:forEach var="mivo" items="${vo.mivo }">
									<c:choose>
										<c:when test="${!empty mivo.smvo }">	
											<li class="lll"><button
												class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
												data-bs-toggle="collapse" data-bs-target="#mi_${mivo.idx }"
												aria-expanded="false" onclick="middleclick(${mivo.idx},this)"><span class="mi">${mivo.name}</span></button>
												<div class="collapse mimi" id="mi_${mivo.idx }">
													<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small cate">
														<c:forEach var="smvo" items="${mivo.smvo }">
															<li class="lll">
																<button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" 
																	onclick="smallclick(${smvo.idx},this)"><span class="sm">${smvo.name }</span></button>
															</li>
														</c:forEach>
													</ul>
												</div>
											</li>
										</c:when>
										<c:otherwise>
											<li class="lll">
												<button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" 
													onclick="middleclick(${mivo.idx},this)"><span class="mi">${mivo.name }</span></button>
											</li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="right">
		<div class="ccccccc">
			<span id="one"></span>
			<span id="two"></span>
			<span id="three"></span>
		</div>
		<div class="product-list2" id="product-list2">
			<c:forEach var="vo" items="${ product}">
				<div class="product" id="${vo.major_idx}/${vo.middle_idx}-${vo.small_idx}">
					
						<a href="${pageContext.request.contextPath}/product/productdetail?idx=${vo.idx }">
							<img class="product-picture"src="${pageContext.request.contextPath}/resources/product/${vo.idx}/${vo.picture}">
						</a>
					<div class="cate-con">
						<div><span class="pr-bn">${vo.brand_name }</span></div>
						<div><span class="cate-title">${vo.name }</span></div>
						<div><span class="blue-1">${vo.h }%</span><span class="cate-price"> ${vo.a }</span></div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

</div>

<script type="text/javascript">

	var one = document.getElementById("one");
	var two = document.getElementById("two");
	var three = document.getElementById("three");
	
	console.log(one);

	function majorclick(idx, btn){ 	
		const produtList = document.querySelectorAll("#product-list2 .product");
		var Arr = Array.from(produtList);
		
		one.innerHTML = btn.querySelector('span').textContent;
		two.innerHTML = "";
		three.innerHTML = "";
		
		for(let i = 0; Arr.length; i++){
			var m = Arr[i].id;
			var index = m.indexOf('/');
			m = m.slice(0,index);
			if(m == idx){
				Arr[i].className="product";		
			}else{
				Arr[i].className="product hidden";
			}
			
		}
	}
	
	function middleclick(idx, btn){
		const produtList = document.querySelectorAll("#product-list2 .product");
		var Arr = Array.from(produtList);
		
		two.innerHTML = " > " + btn.querySelector('span').textContent;
		three.innerHTML = "";
		
		for(let i = 0; Arr.length; i++){
			var middle = Arr[i].id;
			var index1 = middle.indexOf('/');
			var index2 = middle.indexOf('-');
			middle = middle.slice(index1+1,index2);
			if(middle == idx){
				Arr[i].className="product";		
			}else{
				Arr[i].className="product hidden";
			}
			
		}
	}
	
	function smallclick(idx, btn){
		const produtList = document.querySelectorAll("#product-list2 .product");
		var Arr = Array.from(produtList);
		
		three.innerHTML = " > " + btn.querySelector('span').textContent;
		
		for(let i = 0; Arr.length; i++){
			var small = Arr[i].id;
			var index = small.indexOf('-');
			small = small.slice(index+1,small.length);
			if(small == idx){
				Arr[i].className="product";		
			}else{
				Arr[i].className="product hidden";
			}
			
		}
	}
	
</script>
