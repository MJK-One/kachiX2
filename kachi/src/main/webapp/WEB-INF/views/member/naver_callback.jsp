<%@ page import="org.springframework.web.util.HtmlUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>네이버로그인</title>
</head>
<body>

<h1>네이버 로그인 콜백 페이지</h1>

<%
    // 스프링 모델에서 저장한 사용자 프로필 정보를 가져옵니다.
    String userProfile = (String) request.getAttribute("userProfile");

    // 사용자 프로필 정보가 있는 경우 출력합니다.
    if (userProfile != null && !userProfile.isEmpty()) {
        out.println("<h2>사용자 프로필 정보</h2>");
        out.println("<pre>" + HtmlUtils.htmlEscape(userProfile) + "</pre>");
    } else {
        out.println("<p>사용자 프로필 정보를 가져오지 못했습니다.</p>");
    }
%>

</body>
</html>