<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>	
<%@ include file="/WEB-INF/views/layout/my.jsp" %>
<header>
    <div class="update-inputtainer">
        <ul class="mypage2">
          <li><a href="${ pageContext.request.contextPath }/mypage/updatepage" class="nav-link px-2">회원정보수정</a></li>
          <li><a href="#" class="nav-link px-2">알림 설정</a></li>
          <li><a href="${ pageContext.request.contextPath }/mypage/changePw" class="nav-link px-2">비밀번호변경</a></li>
        </ul>
    </div>
</header>
<script>
function checkJoin(event){
	 event.preventDefault(); 
	 
	if(document.changePw.Reuserpw.value != document.changePw.repw.value){
		alert("비밀번호가 일치하지 않습니다.");
	}else{
		document.changePw.submit();
	}
}

</script>

<div class="changePw">	 
	<h2 class="changePw-title">비밀번호 변경</h2>
		<form action="${ pageContext.request.contextPath }/member/updatePW" method="post" name ="changePw">
		<div>
			<div>
				새 비밀번호
			</div>
			<span class="changePW-span">영문, 숫자를 포함한 8자 이상의 비밀번호를 입력해주세요.</span>
			<div class="changePw-input">
				<input class="form-control" type="password" id="Reuserpw" name="Reuserpw" value="" required>
			</div>
		</div>
		<div>
			<div>
			새 비밀번호 확인
			</div>
		<div>
		<div>
			<div class="changePw-input">
				<input class="form-control" type="password" id="repw" value="" required>
			</div>
		</div>
	</div>
</div>
<button class="btn btn-info " type="submit" onclick="checkJoin(event)"><span class="white">비밀번호 변경</span></button>
</form>

</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>	