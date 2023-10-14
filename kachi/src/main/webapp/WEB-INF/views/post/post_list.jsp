<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>

<!-- Add Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<style type='text/css'>
  .card {
    margin-bottom: 10px;
    box-shadow: 0px 2px 10px rgba(0,0,0,.1);
  }
  
 .btn {
   margin-right:5px; 
 }
</style>

</head>
<body class='bg-light'>
	<div class='container'>
		<h1 class='my-3'>게시글 목록</h1>

		<c:forEach items="${posts}" var="post">
		<c:if test="${post.postId >= 0}">
			<div class='card'>
				<div class='card-body'>
					<h5 class='card-title'>${post.title}</h5>
					<p class='card-text'>ID : ${post.postId} <br> 가격 : ${post.price} <br> 할인율 : ${post.discountRate}</p>

					<form action="${pageContext.request.contextPath}/post/deletePost" method="post" style='display:inline;'>
						<input type="hidden" name="postId" value="${post.postId}">
						<button type=submit' class='btn btn-danger'>삭제</button>
				    </form>	
			    </div>	
		    </div>	
	    </c:if>
	    </c:forEach>

     </div>


     <!-- Add Bootstrap JS and its dependencies jQuery and Popper.js-->
     <script src=https://code.jquery.com/jquery-3.5.1.slim.min.js></script>
     <script src=https://cdn.jsdelivr.net/npm/@popperjs/core@2/dist/umd/popper.min.js></script>
     <script src=https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js></script>


</body>
</html> 
