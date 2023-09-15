<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>	
<%@ include file="/WEB-INF/views/layout/my.jsp" %>	

<header>
    <div class="container">
        <ul class="mypage2">
          <li><a href="${pageContext.request.contextPath}/mypage/mypage" class="nav-link px-2">모두보기</a></li>
          <li><a href="${pageContext.request.contextPath}/mypage/photo" class="nav-link px-2">사진</a></li>
          <li><a href="${pageContext.request.contextPath}/mypage/house" class="nav-link px-2">집들이</a></li>
          <li><a href="${pageContext.request.contextPath}/mypage/knowhow" class="nav-link px-2">노하우</a></li>
          <li><a href="#" class="nav-link px-2">질문과답변</a></li>
          <li><a href="#" class="nav-link px-2">스크랩북</a></li>
          <li><a href="#" class="nav-link px-2">좋아요</a></li>
        </ul>
    </div>
</header>
<hr>
<div class="container">
	<table>
		<tr>
			<td rowspan="2"	>
				<div class="my">
					<div>
						<img class="picture" src="${pageContext.request.contextPath}/resources/profile/${lo.m_picture }">
					</div>
					<div id="nick">${login.nickname }</div>
					<span>팔로워 ${follow } | 팔로잉 ${follower }</span>
					<div id="pbtn"><button type="button" class="btn btn-outline-secondary">설정</button></div>
					<div id="hr">
						<hr>
					</div>
					<table class="ppp">
						<tr>
							<td>
								<div class="pppp"> <a href="#"><i class="bi bi-bookmark pp"></i><br></a></div>
								<span class="pppp">스크랩북</span><br>
								<span class="pppp">${scrap }</span>
							</td>
							<td>
								<div class="pppp"> <a href="#"><i class="bi bi-heart pp"></i><br></a></div>
								<span class="pppp">좋아요</span><br>
								<span class="pppp">${like }</span>
							</td>
							<td>
								<div class="pppp"> <a href="#"><i class="bi bi-collection pp"></i><br></a></div>
								<span class="pppp">내 쿠폰</span><br>
								<span class="pppp">0</span>
							</td>
						</tr>
					</table>
				</div>
			</td>
			<td>
				<div id="d1">노하우 <span class="sky">0</span></div>
				<div class="po">
					
					<c:forEach var="po" items="${post }">
						
						<c:if test="${po.kind == '노하우'}">
						
						<a href="${pageContext.request.contextPath}/community/photodetail?idx=${po.idx }">
							<img class="my_photo_img" src="${pageContext.request.contextPath}/resources/post/${po.idx }/${po.picture}">
						</a>
						</c:if>
					</c:forEach>
					
				</div>
				
			</td>
		</tr>
	</table>
</div>

<script>
	
</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>		
