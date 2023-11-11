<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>네이버로그인</title>


    <style type="text/css">
      @import url(//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSans-kr.css);
		@import url(//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSans-jp.css);

      body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: #fff;
      }

     .naver-button {
	width :300px ;
	height :45px;
	background-color:#1ec800; 
	border-radius :25px; 
	display:flex; 
	align-items:center; 
	padding-left :15px;
	padding-right :15px;
	cursor:pointer ;
	text-decoration:none ;
	margin-top :40px;
	margin-bottom :10px;
	margin-left:auto;
	margin-right:auto;
     }

     .naver-button div {
	display:flex ;
	align-items:center ;
	justify-content:center ;
	width :100% ;
	color:#ffffff ;
	font-size :16px ;
	font-family :'Spoqa Han Sans', sans-serif ;
	font-weight:bold ;
     }

     .center-box {
	text-align: center; 
	border-radius : 5px; 
	background-color:#fff; 
	border:1px solid #e1e1e1;
	padding :30px 23px 0px;
	width :378px;
	height :486px;
	box-sizing:border-box; 
	margin:auto;
	position:absolute;

	top:0;left:0;bottom:0;right :0;
     }

     .login-text {
	color:#222222 ;
	font-size :22px ;
	font-family :'Spoqa Han Sans', sans-serif ;
	font-weight: 300; 
	margin-bottom: 0;
     }

     .bold-text {
	color:#222222 ;
	font-size :22px ;
	font-family :'Spoqa Han Sans', sans-serif ;
	font-weight:bold ;
	margin-top: 0; 
     }
     .home-link {
	color:#888888;
	font-size :12px;
	font-family:'Spoqa Han Sans', sans-serif;
	text-decoration:none;
	font-weight:normal;
	font-style:normal;
	
	

	
}

    </style>

</head>

<body>

 <% 
   String clientId = "mp5bUy7BFPU5qVPt5OgE";//애플리케이션 클라이언트 아이디값";
   String redirectURI = URLEncoder.encode("http://localhost:8080/five/member/naver_callback", "UTF-8");
   
   // CSRF 방지를 위한 상태 토큰 생성 코드
   SecureRandom random = new SecureRandom();
   String state = new BigInteger(130, random).toString();
   
   
   String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code"
        + "&client_id=" + clientId
        + "&redirect_uri=" + redirectURI
        + "&state=" + state;
   
   // 상태 토큰으로 사용할 랜덤 문자열 생성
   // 세션 또는 별도의 저장 공간에 상태 토큰을 저장
   session.setAttribute("state", state);
%>

<!-- 로그인 버튼 및 폼  -->
<div class='center-box'>
    <div>
       <h1><img class="icon" src="${pageContext.request.contextPath}/resources/img/name_logo.jpg" width="200" height="70"></h1> 
    </div>
    <div>
       <p class="login-text">간편하게 로그인하고</p>
       <p class="bold-text">다양한 서비스를 이용하세요</p>
    </div>

	<a href="<%=apiURL%>" class="naver-button">
		<div>
			<img src="${pageContext.request.contextPath}/resources/img/naver_icon.png" width="37" height="37">
			<span>네이버로 시작</span>
		</div>
	</a>

	<a href="${pageContext.request.contextPath}/" class='home-link'>홈으로 돌아가기</a>
	<a href="${pageContext.request.contextPath}/member/test" class='home-link'>테스트</a>
</div>
<!-- 로그인 버튼 및 폼 -->

</body>
</html>
