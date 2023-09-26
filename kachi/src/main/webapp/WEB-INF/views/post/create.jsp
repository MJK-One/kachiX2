<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>공동구매 게시글 작성</title>
    
    <style type="text/css">
        body {
            font-family: Arial, sans-serif;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            font-weight: bold;
        }
		.form-group select,
		.form-group input[type=file],
		.form-group input, 
		.form-group textarea {
			width: 100%;
			padding: 10px;
			font-size: 1em;
			border-radius: 5px;
			border: 1px solid #cccccc;	
	    }
	    form {
	        max-width: 500px;
	        margin:auto; 
	    }
    </style>

   <!-- Include the CKEditor library -->
   <script src = "https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>

</head>

<body>

<h2>공동구매 게시글 작성</h2>

<form action="${pageContext.request.contextPath}/post/create_submit" method="post" enctype = "multipart/form-data">
    
     <!-- 제목 입력 -->
     <div class='form-group'>
       <label for='title'> 제목:</label><br />
       <input type='text' id ='title' name ='title'><br />
     </div>

    <!-- 내용 입력 -->
    <div class='form-group'>
        <label for='content'> 내용:</label><br/>
        <textarea name="content" id="editor1" rows="10" cols="80"></textarea>
        <script>
           
              CKEDITOR.replace( 'editor1', {
			        filebrowserUploadUrl: "/path/to/your/script", // 여기서 "/path/to/your/script" 부분은 실제 파일 업로드를 처리하는 서버 측 스크립트의 URL이어야 합니다.
			        filebrowserUploadMethod: 'form'
			    });
        </script>
    </div>

   <!-- 가격 입력 -->
   <div class='form-group'>
       <label for='price'> 가격:</label><br />
       <input type='number' id ='price' name ='price'><br />
   </div>


   <!-- 할인율 입력 -->  
  　<div class = 'form-group'>
    　<label for = 'discountRate'>할인율(%):</ label > 
    　<input type = 'number' id= 'discountRate' name= 'discountRate' min= "0" max= "100"><br />
  　</div >

   <!-- 판매기간 입력 -->
   <div class='form-group'>
      <label for='salePeriod'> 판매 기간:</label><br />
      <input type='date' id ='salePeriod' name ='salePeriod'><br />
   </div>

   <!-- 카테고리 선택 -->   
    　<div class = 'form-group'>
    　<label for = 'category'>카테고리 :</ label > 
      　<select id="category" name="category">
		   <c:forEach items="${categories}" var="category">
		      <option value="${category.categoryId}">${category.categoryName}</option>
		   </c:forEach>
		</select>
      </div >

   <!-- 이미지 업로드 -->
   <div class='form-group'>
       <label for='image'>이미지 업로드:</label><br />
       <input type='file' id ='image' name ='image'><br />
   </div>

    <!-- 제출 버튼 -->
   	<input type= "submit" value= "Submit">
  
</form>


</body>
</html>