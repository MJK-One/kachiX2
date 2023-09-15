<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<%@ include file="/WEB-INF/views/layout/community.jsp" %>
<div class="detail-main">
	<div class="detail-content-2">
		${post.content }
	</div>	
</div>
<script>
	var pi = document.querySelectorAll(".detail-content-2 img");
	
	arr = Array.from(pi);
	
	for(let i = 0; arr.length; i++){
		arr[i].style.width = '600px';
	}
	
</script>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>