<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 목록</title>

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
   font-size :1em; 
}

.btn-success {
   color:#fff; 
   background-color:#ff6347; 
   border:none; 
   padding:.375rem .75rem; 
   margin-right :5px ;
}
</style>




</head>
<body class='bg-light'>
	<div class='container'>
		<h1 class='my-3'>주문 목록</h1>



<c:forEach items="${purchases}" var="purchases">
	<div class='card'>
		<h5>주문번호 : ${purchases.purchaseId}</h5>
		<p>
		   사용자ID : ${purchases.userId} <br>
		   이름 : ${purchases.userName} <br>
		   이메일 : ${purchases.userEmail} <br>
		   전화번호 : ${purchases.userPhone} <br>
		   상품명 : ${purchases.productName} <br>
		   결제가격 : <fmt:formatNumber value="${purchases.productPrice}" pattern="#,###"/>원 <br>
		   물건수량: ${purchases.quantity} <br>
		   배송지: ${purchases.deliveryAddress} <br>
		   주문날짜: ${purchases.purchaseDate} <br>
		</p>

        <c:choose>
            <c:when test="${purchases.deliveryStatus}">
                배송 상태: 완료
            </c:when>
            <c:otherwise>
                배송 상태: 준비중
                <form action="${pageContext.request.contextPath}/admin/updateDeliveryStatus" method="post">
                    <input type="hidden" name="purchaseId" value="${purchases.purchaseId}">
                    <button type='submit' class='btn-success' >배송 완료</button>
                </form>
            </c:otherwise>
        </c:choose>
    </div>	
</c:forEach>


     </div>


</body>
</html> 
