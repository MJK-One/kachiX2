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

<hr>
<div class="update">

	<div><span class="title">회원정보수정</span></div>
		<div class="update-table">
			<form class="update-table" action="${ pageContext.request.contextPath }/mypage/update" method="POST" enctype="multipart/form-data">
				
				<table class="update-table">
					<tr>
						<th>
							<div class="update-input">
			 					이메일<span class="red">*</span>
		 					</div>
						</th>
						<td class="info-td">
			 			<div class="update-input">
			 				<input type="email" class="form-control" name="email" value="${vo.email }">
			 			</div>
						</td>
					</tr>
					<tr>
						<th>
							<div class="update-input">
			 					별명<span class="red">*</span>
			 				</div>
						</th>
						<td class="info-td">
			 			<div class="update-input">
			 				<input type="text" class="form-control" name="nickname" value="${vo.nickname }">
			 			</div>
						</td>
					</tr>
					<tr>
						<th>
							<div class="update-input">
								홈페이지
							</div>
						</th>
						<td>
							<c:choose>
							<c:when test="${vo.homepage == null}"> 
								<div class="update-input">
									<input class="form-control" type="text" name = "homepage" placeholder="http://ohou.se">
								</div>
							</c:when>
							<c:otherwise>
								<div class="update-input">
									<input class="form-control" type="text" name = "homepage" value="${vo.homepage}">
								</div>
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
					<tr>
						<th>
							<div class="update-input">
								생년월일
							</div>
						</th>
						<td>
						<c:choose>
							<c:when test="${vo.birth_date == null}">
								<div class="update-input"> 
									<input class="form-control" type="date" name="birth_date">
								</div>
							</c:when>
							<c:otherwise>	
								<div class="update-input"> 
									<input class="form-control" type="date" name="birth_date" value="${vo.birth_date}">
								</div>
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
					<tr>
						<th>
							<div class="update-input">
								프로필 이미지
							</div>	
						</th>
						<td>
							<div class="update-input"> 
								<input type="file" class="form-control" id="m_picture" name="photo" >
							</div>
						</td>
					</tr>
					<tr>
						<th>
							<div class="update-input">
								한줄소개
							</div>
						</th>
						<td class="info-td">	 			
				 			<c:choose>
								<c:when test="${vo.introduce == null}">
									<div class="update-input"> 
						 				<input type="text" class="form-control" name="introduce" >
						 			</div>
								</c:when>
								<c:otherwise>
									<div class="update-input">
						 				<input type="text" class="form-control" name="introduce"  value="${vo.introduce }">
						 			</div>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
					
						<td></td>
						<td>
							<div class="update-btn">
								<button class="btn btn-info" type="submit"><span class="white">회원 정보 수정</span></button>
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>		
