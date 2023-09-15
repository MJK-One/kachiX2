<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/uploadproduct.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/summernote/js/summernote-lite.js"></script>
<script src="${pageContext.request.contextPath}/resources/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/summernote/css/summernote-lite.css">

<meta charset="UTF-8">
<title>오늘의 집</title>
</head>
<body>
<div class="brand">
	<div class="brand-title">
		<a href="${pageContext.request.contextPath }" ><img class="logo" src="${pageContext.request.contextPath}/resources/images/로그인로고.jpg"></a>
		<div id="title">상품등록</div>
	</div>
   
   	<hr>
   	<form action="${pageContext.request.contextPath }/product/insert?brand_idx=${brand.idx}" method="POST" enctype="multipart/form-data">
   		<input type="hidden" name="major_idx" id="major_idx" value="5000">
   		<input type="hidden" name="middle_idx" id="middle_idx" value="5000">
   		<input type="hidden" name="small_idx" id="small_idx" value="5000">
		<div class="brand-info">
			<div><span class="title">상품정보</span></div>
			<table>
				<tr>
					<th>
		 			상품명<span class="red">*</span>
					</th>
					<td class="info-td">
						<input type="text" class="form-control" name="name" required>
		 			<div class="con">
		 				
		 			</div>
					</td>
				</tr>
				<tr>
				<td></td>
				<td><span class="ex">※ 제품명 상품군 상품정보로 구성해주세요.</span></td>
				</tr>
				<tr>
					<th>브랜드<span class="red">*</span></th>
					<td>
						<div class="con">
							<div>
								
								<span>${brand.brand_name }</span>
							
							</div>
						</div>
					</td>
					</tr>
				<tr>
					<th>관리 카테고리</th>
					<td>
						<div class="con">
							<div>
								<span>대분류</span>
								<select class="form-select" id="majorSelect" onchange="Major()">
										<option value="5000" selected>카테고리를 선택하세요(필수)</option>
										<c:forEach var="mavo" items="${major }">
											<option value="${mavo.idx }">${mavo.name }</option>
										</c:forEach>
								</select>
							</div>
							<div id="middle">
								<span>중분류</span>
								<select class="form-select" id="middleSelect" onchange="Middle()">
										<option value="5000"selected>카테고리를 선택하세요(선택)</option>
										<c:forEach var="mavo" items="${major }">
											<c:forEach var="mivo" items="${mavo.mivo }">
												<option class="hidden" value="${mivo.major_idx }/${mivo.idx}">${mivo.name }</option>
											</c:forEach>
										</c:forEach>
								</select>
							</div>
							<div class="bbb">
								<span>소분류</span>
								<select class="form-select" id="smallSelect" onchange="Small()">
										<option value="5000" selected>카테고리를 선택하세요(선택)</option>
										<c:forEach var="mavo" items="${major }">
											<c:forEach var="mivo" items="${mavo.mivo }">
												<c:forEach var="smvo" items="${mivo.smvo }">
													<option class="hidden" value="${smvo.middle_idx }/${smvo.idx}">${smvo.name }</option>
												</c:forEach>
											</c:forEach>
										</c:forEach>
								</select>
							</div>
						</div>
					</td>
				</tr>
			</table>
			<hr>
			<div><span class="title">대표가격</span></div>
			<table>
				<tr>
					<th>
		 				정상가<span class="red">*</span>
					</th>
					<td class="info-td">
			 			<div class="con">
			 				<input type="number" class="form-control" name="price" required>
			 			</div>
					</td>
				</tr>
				<tr>
					<th>판매가(할인가)<span class="red">*</span></th>
					<td>
						<div class="con">
		 					<input type="number" class="form-control" name="sale" required>
		 				</div>
					</td>
				</tr>
				<tr>
					<th>배송비<span class="red">*</span></th>
					<td>
						<div class="con">
		 					<input type="number" class="form-control" name="delivery" required>
		 				</div>
					</td>
				</tr>
			</table>
			<hr>
		
			<div><span class="title">상품정보</span></div>
				<div class="summer">
					<textarea id="summernote" rows="500" cols="500" name="info"></textarea>
				</div>
				<hr>
				<div><span class="title">대표이미지</span></div>
				<div class="ff">
					<div class="input-group mb-3">
			  			<input type="file" class="form-control" id="inputGroupFile02" name="photo">
					</div>
				</div>
			<hr>
		<div class="mama">
			<button class="btn btn-info btn-lg" type="submit" onclick="category(${brand.idx})"><span id="white">상품등록하기</span></button>
		</div>
		</div>
   </form>
</div>

<script type="text/javascript">
	$(document).ready(function() {
 	 	$('#summernote').summernote({
 	 		height: 600,                 // 에디터 높이
			minHeight: null,             // 최소 높이
			maxHeight: null,             // 최대 높이
			focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
			lang: "ko-KR",				// 한글 설정
			placeholder: '가운데 정렬 해주세요'	//placeholder 설정
 	 		
 	 	});
	});
	
	function Major(){
		const majorinput = document.getElementById("major_idx");
		const middle = document.getElementById("middleSelect");
		var majorSelect = document.getElementById("majorSelect").value;
		var middleSelectList = middle.options;

		majorinput.value = majorSelect;
		
		for (var i = 0; i < middleSelectList.length; i++) {
			  var option = middleSelectList[i];
			  var value = option.value;
			  var index = value.indexOf('/');
			  var major_idx = value.slice(0,index);
			  
			  if(major_idx == 2222){
				  middleSelectList[i].className = '';
			  }
			  else if(major_idx == majorSelect){
				  middleSelectList[i].className = '';
			  }else{
				  middleSelectList[i].className = 'hidden';
			  }
		}
		
	}
	
	function Middle(){
		const middleinput = document.getElementById('middle_idx');
		const small = document.getElementById("smallSelect");
		var middleSelect = document.getElementById("middleSelect").value;
		var smallSelectList = small.options;
		
		var index = middleSelect.indexOf('/');
		var mi = middleSelect.slice(index+1,middleSelect.length);
		
		middleinput.value = mi;
		console.log(middleinput);
		for (var i = 0; i < smallSelectList.length; i++) {
			  var option = smallSelectList[i];
			  var value = option.value;
			  var index = value.indexOf('/');
			  value = value.slice(0,index);
			  
			  if(value == 2222){
				  smallSelectList[i].className = '';
			  }
			  else if(value == mi){
				  smallSelectList[i].className = '';
			  }else{
				  smallSelectList[i].className = 'hidden';
			  }
		}
		
	}
	
	function Small(){
		const smallinput = document.getElementById('small_idx');
		var smallSelect = document.getElementById("smallSelect").value;
		var index = smallSelect.indexOf('/');
		smallSelect = smallSelect.slice(index+1,smallSelect.length);
		console.log(smallinput);
		smallinput.value = smallSelect;
		console.log(smallSelect);
	}

	
	
</script>
</body>