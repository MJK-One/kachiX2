<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	
</style>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">


<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/summernote/js/summernote-lite.js"></script>
<script src="${pageContext.request.contextPath}/resources/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/summernote/css/summernote-lite.css">


<title>오늘의 집</title>
</head>
<body>
<script type="text/javascript">
	function checkWrite() {
		
		if(document.write.title.value == ""){
			alert("제목을 입력하십시오!");
		}else if(document.write.content.value == ""){
			alert("내용을 입력하십시오!")
		}else{
			document.write.submit();
		}
	}
</script>
<div align="center">

	<form action="${pageContext.request.contextPath }/post/write?kind=${kind}" name="write" method="POST" enctype="multipart/form-data">
		<div class="container">
			<a href="${pageContext.request.contextPath}" ><img  class="uplogo" src="${pageContext.request.contextPath}/resources/images/로고.png"></a>
		</div>
		<hr>
		<div>
		<c:choose>
			<c:when test="${kind == '사진' }">
			</c:when>
			<c:otherwise>
			<div id="title">
				<span id="bbbb">제목</span>
				<input class="form-control itit" type="text" name="title" size="80">
			</div>
			</c:otherwise>
		</c:choose>
		</div>
		<div class="summer">
			<textarea id="summernote" rows="500" cols="500" name="content"></textarea>
		</div>
		<div class="ff">
			<div class="input-group mb-3">
	  			<input type="file" class="form-control" id="inputGroupFile02" name="photo">
			</div>
		</div>
		<div class="upup">
			<input type="button"  class="btn btn-outline-secondary" value="올리기" onclick="javascript:checkWrite()">
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
	
	
</script>
</body>
</html>


