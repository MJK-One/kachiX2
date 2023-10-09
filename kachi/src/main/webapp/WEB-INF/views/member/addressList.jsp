<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송지 목록</title>

<!-- Add Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<style type='text/css'>
  .address-card {
    background-color: rgba(255, 255, 255, 0.7); /* Semi-transparent white */
    margin-bottom: 10px;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0px 2px 10px rgba(0,0,0,.1);
  }
  
 .btn {
   margin-right:5px; 
 }
</style>

</head>
<body class='bg-light'>
	<div class='container'>
		<h1 class='my-3'>배송지 목록</h1>

		<c:forEach items="${addresses}" var="address">
			<div class='address-card'>
				<div class='row align-items-center'>
					<div class='col-md-6'>
					    ${address.postCode} ${address.streetAddress} <br> ${address.detailAddress}
					</div>

					
					<div class='col-md-6 text-right'>
						<!-- 삭제 버튼 -->
						<form action="${pageContext.request.contextPath}/member/deleteAddress" method="post" style='display:inline;'>
							<input type="hidden" name="addressId" value="${address.addressId}">
							<button type=submit' class='btn btn-danger'>삭제</button>
					 </form>	
				 </div>	
			 </div>	
		 </div>	
	    </c:forEach>

     </div>


     <!-- Add Bootstrap JS and its dependencies jQuery and Popper.js-->
     <script src=https://code.jquery.com/jquery-3.5.1.slim.min.js></script>
     <script src=https://cdn.jsdelivr.net/npm/@popperjs/core@2/dist/umd/popper.min.js></script>
     <script src=https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js></script>


</body>
</html> 