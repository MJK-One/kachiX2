<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>관리자 메인 페이지</title>
    <style>
        body, html {
            height: 100%;
            margin: 0;
            padding: 0;
            overflow: hidden;
        }
        #sidebar {
            width: 25%;
            height: 100%;
            position: absolute;
            left: 0;
        }
        #content {
            width: 75%;
            height: 100%;
            position:absolute;
            right:0; 
        }
    </style>
</head>

<body>

<iframe src="${pageContext.request.contextPath}/admin/sidebar" id="sidebar"></iframe>

<iframe src="${pageContext.request.contextPath}/post/post_create" id="content" name="contentFrame"></iframe>

</body>
</html>