<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>관리자 페이지</title>

<style type="text/css">
#admin-panel {
    display: flex;
}

#left-menu {
    width: 20%;
}

</style>



<script>
$(document).ready(function(){
	$(".b a").click(function(e) {
        e.preventDefault();
        $(".b a").removeClass("active");
        $(this).addClass("active");

        var href = $(this).attr('href');
         // Load the content from the href attribute into the right-content div.
          $('.right-content').load($(this).attr('href'));
     });
});
</script>

</head>

<div id="admin-panel">
    <div id="left-menu">
        <ul>
            <li class="b"><a class = "active" href="${pageContext.request.contextPath}/post/post_create">게시물 생성</a></li>
            <li class="b"><a href="${pageContext.request.contextPath}/post/post_list">게시물 삭제</a></li>
            <li class="b"><a href="${pageContext.request.contextPath}/memeber/user_list">회원 관리</a></li>
        </ul>        
    </div>
    
	<div class="right-content">
		<jsp:include page="/WEB-INF/views/post/post_create.jsp" flush="false" />
	</div>

</html> 
