<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/login.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">

<title>로그인</title>
</head>
<body>
<script>

function checkJoin(){
	if(document.rePW.Reuserpw.value == ""){
		alert("비밀번호를 입력하십시오!");
	}else if(document.rePW.repw.value == ""){
		alert("비밀번호확인을 입력하십시오!");
	}else if(document.rePW.Reuserpw.value != document.rePW.repw.value){
		alert("비밀번호가 일치하지 않습니다.");
	}else{
		document.rePW.submit();
	}
}

alert('${msg}');

</script>
	<div class="container">
		<div align="center">
			<form action="${ pageContext.request.contextPath }/member/updatePW" method="post" name="rePW">
				
				<a href="${pageContext.request.contextPath}" ><img class="logo" src="${pageContext.request.contextPath}/resources/images/로그인로고.jpg"></a>
	
				<div class="ff">
					<input type="password" name="Reuserpw" class="form-control" placeholder="비밀번호">
				</div>
				<div class="ff"> 
					<input type="password" name = "repw"  class="form-control" placeholder="비밀번호 확인">
				</div>
				<div>
					<button class="btn btn-info ff" type="submit"><span class="white">비밀번호 변경하기</span></button>
				</div>
			</form>
		</div>
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>