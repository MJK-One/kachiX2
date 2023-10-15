<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>

<style type='text/css'>
  body {
    background-color: #f8f9fa;
    font-family: Arial, sans-serif;
  }

  .container {
    max-width: 960px;
    margin: auto;
    padding: 20px;
  }

  .card {
    width:85%;
    margin-bottom: 10px;
    border-radius: .25rem;
    box-shadow: 0px 2px 10px rgba(0,0,0,.1);
    background-color: white;
    padding: .75rem 1.25rem; 
}

h5 {
   font-size :1.5em; 
}

.btn-danger {
   color:#fff; 
   background-color:#dc3545; 
   border:none; 
   padding:.375rem .75rem; 
   margin-right :5px ;
}
</style>

<script type='text/javascript'>
function confirmDelete() {
	return confirm('정말로 삭제하시겠습니까?');
}
</script>

</head>
<body class='bg-light'>
	<div class='container'>
		<h1 class='my-3'>게시글 목록</h1>

		<c:forEach items="${posts}" var="post">
			<c:if test="${post.postId >=0}">
				<div class='card'>
					<h5>${post.title}</h5>
					<p>ID : ${post.postId} <br> 가격 : ${post.price} <br> 할인율 : ${post.discountRate}</p>

					<form action="${pageContext.request.contextPath}/post/deletePost" method="post" style='display:inline-block;' onsubmit='return confirmDelete();'>
						<input type="hidden" name="postId" value="${post.postId}">
						<button type=submit' class='btn-danger'>삭제</button>
				    </form>	
			    </div>	
		    </c:if>
	    </c:forEach>

     </div>


</body>
</html> 

