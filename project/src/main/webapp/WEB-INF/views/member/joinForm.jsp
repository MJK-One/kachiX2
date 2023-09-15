<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/join.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.2.js"></script>
<style>
	ul, li {
		list-style: none;	
	}
</style>
</head>
<body>
<script>

function checkJoin(){
	if(document.join.email.value == ""){
		alert("이메일을 입력하십시오!");
	}else if(document.join.email2.value == ""){
		alert("이메일을 입력하십시오!");
	}else if(document.join.userpw.value == ""){
		alert("비밀번호를 입력하십시오!");
	}else if(document.join.repw.value == ""){
		alert("비밀번호확인을 입력하십시오!");
	}else if(document.join.nickname.value == ""){
		alert("닉네임을 입력하십시오!");
	}else if(document.join.password.value != document.join.repw.value){
		alert("비밀번호가 일치하지 않습니다.");
	}else{
		document.join.submit();
	}
}

</script>
<div class="join">
	<form class="joinf" action="${ pageContext.request.contextPath }/member/join.me" method="post" name ="join">
		<h5 class="tt">회원가입</h5>
		<hr>
		<table>
			<tr>
				<th>이메일</th>
			</tr>
			<tr>
				<td>
					<input class="form-control" type="email" name = "email" placeholder="이메일">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
			</tr>
			<tr>
				<td class="td">영문, 숫자를 포함한 8자 이상의 비밀번호를 입력해주세요.</td>
			</tr>
			<tr>
				<td><input class="form-control" type="password" name = "userpw" placeholder="비밀번호"></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
			</tr>
			<tr>
				<td><input class="form-control"  type="password" name = "repw" placeholder="비밀번호 확인"></td>
			</tr>
			<tr>
				<th>닉네임</th>
			</tr>
			<tr>
				<td class="td">다른 유저와 겹치지 않도록 입력해주세요 (2~15자)</td>
			</tr>
			<tr>
				<td><input class="form-control"  type="text" name = "nickname"  autocomplete="off" placeholder="별명 (2~15자)"></td>
			</tr>
		
			<tr>
				<td>
					<div class="agree">
						<ul>
							<li>
								<input type="checkbox" class="checkbox ck-all">
								<label>전체동의(선택항목에 대한 동의 포함)</label>
							</li>
							<hr>
							<li class="check">
								<input type="checkbox" id="ck1" class="checkbox ck">
								<label>만 14세 이상입니다(필수)</label>
							</li>
							<li class="check">
								<input type="checkbox" id="ck2" class="checkbox ck">
								<label>이용약관(필수)</label>
							</li>
							<li class="check">
								<input type="checkbox" id="ck3" class="checkbox ck">
								<label>개인정보수집 및 이용동의(필수)</label>
							</li>
							<li class="check">
								<input type="checkbox" name="agree_marketing" id="ck4" class="checkbox ck" value="1">
								<label>개인정보 마케팅 활용 동의(선택)</label>
							</li>
							<li class="check">
								<input type="checkbox" name="agree_email" id="ck5" class="checkbox ck" value="1">
								<label>이벤트, 쿠폰, 특가 알림 메일 및 SMS 등 수신(선택)</label>
							</li>
						</ul>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div">
						<button class="btn btn-info bt" type="submit">회원가입하기</button>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<span>이미 아이디가 있으신가요? </span><a href="${pageContext.request.contextPath}/member/loginform" >로그인</a>
</div>
	<script type="text/javascript">
	
		const ckAll = document.querySelector(".ck-all");
		
		const ckArr = document.querySelectorAll(".check > input");
		
		ckAll.addEventListener("click", () => {
			ckArr.forEach(ck => {
				ck.checked = ckAll.checked;
			})
		})
		
		ckArr.forEach(ck => {
			ck.addEventListener("click", () => {
				
				let cnt = 0;
				
				ckArr.forEach(ck => {
					if(ck.checked) {
						cnt++;
					}
				})
				
				if(cnt == ckArr.length){
					ckAll.checked = true;
				}else {
					ckAll.checked = false;
				}
					
			})
		})
		
	</script>
</body>
</html>