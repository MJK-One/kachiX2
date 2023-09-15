<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<%@ include file="/WEB-INF/views/layout/community.jsp" %>
<div>
	<img class="detail-img" src="${pageContext.request.contextPath}/resources/post/${post.idx }/${post.picture}">
</div>
<div class="detail-main">
	<div class="detail-title">${post.title }</div>
	<div class="detail-content">
		<table class="detail-table" >
			<tr>
				<td rowspan="2">
					<img class="detail-profile"src="${pageContext.request.contextPath}/resources/profile/프로필.png">
				</td>
				<td class="detd">
					<div class="detail-nink">${post.nickname }</div>
				</td>
				<td class="detail-follow" rowspan="2">
				<c:if test="${login.idx != post.member_idx }">
					<c:choose>
						<c:when test="${check == 0 }">
							<button id="follow" class="btn btn-info" type="button" onclick="follow()">
								<span id="span" class="white">팔로우</span>
							</button>
						</c:when>
						<c:otherwise>
							<button id="follow" class="btn btn-secondary" type="button" onclick="follow()">
								<span id="span" class="white">팔로잉</span>
							</button>
						</c:otherwise>
					</c:choose>
				</c:if>

				
				</td>
			</tr>
			<tr>
				<td class="detd">
					<div class="detail-time">${post.time }</div>
				</td>
			</tr>	
		</table>
		
		
	</div>
</div>

	<div class="detail-content-1">
		${post.content }
	</div>	
	
	<script>
		var url;
		var check = ${check};
			
		function follow(){
			
			if(check == 0){
				url = "${pageContext.request.contextPath}/ajax/follow";
				check = 1
				console.log(${check})
			}else{
				url = "${pageContext.request.contextPath}/ajax/follower";
				check = 0
				console.log(${check})
			}
			
		    var param = "member_idx=" + encodeURIComponent(${login.idx}) + "&follow_idx=" + encodeURIComponent(${post.member_idx});	
		
		    sendRequest(url, param, followResult, "GET");
		}
		
		function followResult() {
		      if(xhr.readyState==4 && xhr.status==200) {
		    	  var btn = document.getElementById("follow");
		    	  var span = document.getElementById("span");
		    	  if(btn.className == 'btn btn-secondary'){
		    		  btn.className = 'btn btn-info';
		    		  span.innerHTML = "";
		    		  span.innerHTML = "팔로우"; 
		    		  
		    	  }else{
		    		  btn.className = 'btn btn-secondary';
		    		  span.innerHTML = "";
		    		  span.innerHTML = "팔로잉"; 
		    	  }
		    	 
		    	  
		      }
		}
	</script>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>