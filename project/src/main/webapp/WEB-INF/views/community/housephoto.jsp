<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<%@ include file="/WEB-INF/views/layout/community.jsp" %>

<div class="product-list">
	<c:forEach var="vo" items="${post }">
	<div class="photo">
		<table class="photo-table" >
			<tr>
				<td rowspan="2">
					<img class="photo-profile"src="${pageContext.request.contextPath}/resources/profile/${vo.m_picture}">
				</td>
				<td class="phtd">
					<div class="photo-nick"><span class="nick">${vo.nickname } · </span><a href="#"><span class="blue">팔로우</span></a> </div>
				</td>
					
			</tr>
			<tr>
				<td class="phtd">
					<c:if test="${vo.introduce == null}">
						<div class="detail-time">한줄 소개가 없습니다</div>
					</c:if>
					<div class="detail-time">${vo.introduce }</div>
				</td>
			</tr>
		
		</table>
		<a  href="${pageContext.request.contextPath}/community/photodetail?idx=${vo.idx }" >
			<img class="photo_img" src="${pageContext.request.contextPath}/resources/post/${vo.idx }/${vo.picture}">
		</a>
		<div class="photo-mg">
		<div class="photo-icon"> 
			<div class="ic">
			
				<c:choose>
					<c:when test="${vo.lcheck != 0 }">
						<a href="javascript:likes(${vo.idx },${vo.lcheck })"><i id="${vo.idx }h"class="bi bi-heart-fill skyblue"></i></a>
					</c:when>
					<c:otherwise>
						<a href="javascript:likes(${vo.idx},${vo.lcheck } )"><i id="${vo.idx }h"class="bi bi-heart"></i></a>
					</c:otherwise>
				</c:choose>	
			</div>
			<div class="ic">
				<c:choose>
					<c:when test="${vo.check != 0 }">
						<a href="javascript:scrap(${vo.idx },${vo.check })"><i id="${vo.idx }"class="bi bi-bookmark-fill skyblue"></i></a>
					</c:when>
					<c:otherwise>
						<a href="javascript:scrap(${vo.idx},${vo.check } )"><i id="${vo.idx }"class="bi bi-bookmark"></i></a>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="ic">
				<a href="#"><i class="bi bi-chat"></i></a>
			</div>		
		</div>
		</div>
	</div>
	</c:forEach>
	
</div>

<script type="text/javascript">
var url;

	function likes(post_idx, ck){
		var url;
		
		if(ck == 0){
			url = "${pageContext.request.contextPath}/ajax/likes";
		}else{
			url = "${pageContext.request.contextPath}/ajax/likesdelete";
		}
		
		var i = document.getElementById(post_idx+"h");
		
		if(i.className == 'bi bi-heart-fill skyblue'){
			url = "${pageContext.request.contextPath}/ajax/likesdelete";
    	}else{
    		url = "${pageContext.request.contextPath}/ajax/likes";
    	}
	
		var param = "member_idx=" + encodeURIComponent(${login.idx}) + "&post_idx=" + encodeURIComponent(post_idx);
		sendRequest(url, param, likesResult, "GET");
}

	function likesResult() {
      if(xhr.readyState==4 && xhr.status==200) {
    	  	var data = xhr.response;
			var data2 = JSON.parse(data);
			var i = document.getElementById(data2+"h");
			console.log(data2);
			console.log(i);
	    	 
	    	if(i.className == 'bi bi-heart-fill skyblue'){
	    		i.className = 'bi bi-heart';
	    	}else{
	    		i.className = 'bi bi-heart-fill skyblue';
	    	}
	    	  
         
      }
}
	
	function scrap(post_idx, ck) {
		var url;
		
		if(ck == 0){
			url = "${pageContext.request.contextPath}/ajax/scrap";
		}else{
			url = "${pageContext.request.contextPath}/ajax/scrapdelete";
		}
		
		var i = document.getElementById(post_idx);
		
		if(i.className == ''){
			url = "${pageContext.request.contextPath}/ajax/scrapdelete";
    	}else{
    		url = "${pageContext.request.contextPath}/ajax/scrap";
    	}
	
		var param = "member_idx=" + encodeURIComponent(${login.idx}) + "&post_idx=" + encodeURIComponent(post_idx);
		sendRequest(url, param, scrapResult, "GET");
	}
	
	function scrapResult() {
		if(xhr.readyState==4 && xhr.status==200) {
			var d = xhr.response;
			var d2 = JSON.parse(d);
			var i = document.getElementById(d2);

	    	 
	    	if(i.className == 'bi bi-bookmark-fill skyblue'){
	    		i.className = 'bi bi-bookmark';
	    	}else{
	    		i.className = 'bi bi-bookmark-fill skyblue';
	    	}
	    	  
	      }
	}
</script>


<%@ include file="/WEB-INF/views/layout/footer.jsp" %>		