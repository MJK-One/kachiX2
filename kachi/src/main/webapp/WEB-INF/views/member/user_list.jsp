<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

.btn-danger {
   color:#fff; 
   background-color:#ff6347; 
   border:none; 
   padding:.375rem .75rem; 
   margin-right :5px ;
}
</style>


<script type='text/javascript'>
function confirmUpdate(userName) {
	return confirm(userName + '님의 관리자 권한을 변경하시겠습니까?');
}
</script>

</head>
<body class='bg-light'>
	<div class='container'>
		<h1 class='my-3'>사용자 목록</h1>

	<!-- userList.jsp -->

<c:forEach items="${users}" var="user">
	<div class='card'>
		<h5>사용자 ID : ${user.userID}</h5>
		<p>이름 : ${user.name} <br>
		   닉네임 : ${user.nickname} <br>
		   이메일 : ${user.email} <br>
		   성별 : ${user.gender} <br>
		   핸드폰번호 : ${user.phoneNumber} <br>
		   관리자 권환: ${user.writePermission == 1 ? 'Yes' : 'No'}
		</p>

       <form action="${pageContext.request.contextPath}/member/updatePermission" method="post" onsubmit='return confirmUpdate("${user.name}");'>
		    <input type="hidden" name="userID" value="${user.userID}">
		    
		    <input type="hidden" name="writePermission" value="${user.writePermission == 1 ? '0' : '1'}">
		    <button type='submit' class='btn-danger'>관리자 권한 변경</button>
		</form>

	    	
    </div>	
</c:forEach>


     </div>


</body>
</html> 

