<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<%@ include file="/WEB-INF/views/layout/community.jsp" %>

<div class="post-list">
	<c:forEach var="vo" items="${post }">
		<div class="post">
			<div class="bomo">
				<c:choose>
					<c:when test="${vo.check == 1 }">
						<div class="scrap"><a href="javascript:scrap(${vo.idx },${vo.check })"><i id="${vo.idx }"class="bi bi-bookmark-fill skyblue"></i></a></div>
					</c:when>
					<c:otherwise>
						<div class="scrap"><a href="javascript:scrap(${vo.idx},${vo.check } )"><i id="${vo.idx }"class="bi bi-bookmark white"></i></a></div>
					</c:otherwise>
				</c:choose>	
				<a href="${pageContext.request.contextPath}/community/detail?idx=${vo.idx }">
				<img class="main-picture" src="${pageContext.request.contextPath}/resources/post/${vo.idx }/${vo.picture}"></a>
			</div>
			<div class="post-title">${vo.title }</div>
			
			
			<div class="post-nickname">
				<img class="profile" src="${pageContext.request.contextPath}/resources/profile/${vo.m_picture}">
				${vo.nickname }
			</div>
			<div class="post-cnt"><span>스크랩 ${vo.scrapPCnt} · 조회 ${vo.hit }</span></div>
		</div>
	</c:forEach>
</div>

<script type="text/javascript">

	function scrap(post_idx, ck) {
		var url;
		
		if(ck == 0){
			url = "${pageContext.request.contextPath}/ajax/scrap";
		}else{
			url = "${pageContext.request.contextPath}/ajax/scrapdelete";
		}
		
		var i = document.getElementById(post_idx);
		
		if(i.className == 'bi bi-bookmark-fill skyblue'){
			url = "${pageContext.request.contextPath}/ajax/scrapdelete";
    	}else{
    		url = "${pageContext.request.contextPath}/ajax/scrap";
    	}
	
		var param = "member_idx=" + encodeURIComponent(${login.idx}) + "&post_idx=" + encodeURIComponent(post_idx);
		sendRequest(url, param, scrapResult, "GET");
	}
	
	function scrapResult() {
		if(xhr.readyState==4 && xhr.status==200) {
			var data = xhr.response;
			var data2 = JSON.parse(data);
			var i = document.getElementById(data2);
			console.log(data2);
			console.log(i);
	    	 
	    	if(i.className == 'bi bi-bookmark-fill skyblue'){
	    		i.className = 'bi bi-bookmark white';
	    	}else{
	    		i.className = 'bi bi-bookmark-fill skyblue';
	    	}
	    	  
	      }
	}
	
</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>