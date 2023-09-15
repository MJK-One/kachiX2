<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<script>
    // 입력값이 있는 경우 버튼 활성화
    function enableButton() {
        var input = document.getElementById("inputValue");
        var button = document.getElementById("myButton");
        
        if (input.value !== "") {
            button.disabled = false;
            pageContext.setAttribute("inputData", input.value);
        } else {
            button.disabled = true;
        }
    }
</script>
<body>
<div class="container">
	<div class="changePw">
		<form action="${ pageContext.request.contextPath }/member/pwSetting" method="post">
				<span class="pw-title">가입한 이메일 주소를 입력해주세요.</span>

				<div class="Pw-input">
					<input class="form-control" id="inputValue" oninput="enableButton()" type="email" name = "email" placeholder="이메일">
				</div>
				<div>
					<button class="btn btn-info pwbtn" id="myButton" type="submit" disabled><span class="white">확인</span></button>
				</div>
		</form>
	</div>
</div>
</body>
</html>