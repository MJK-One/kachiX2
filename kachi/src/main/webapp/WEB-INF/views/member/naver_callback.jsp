<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="org.json.JSONObject" %> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>네이버로그인</title>
  </head>
  <body>
  <%
    String clientId = "mp5bUy7BFPU5qVPt5OgE";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "rrpmQIm5cT";//애플리케이션 클라이언트 시크릿값";
    String code = request.getParameter("code");
    String state = request.getParameter("state");
    
    String storedState = (String) session.getAttribute("state");
    
    // 상태 토큰 검증
    if (!state.equals(storedState)) {
       response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized request."); //401 unauthorized
       return;
    }
    
    String redirectURI = URLEncoder.encode("http://localhost:8080/five/member/naver_callback", "UTF-8");
    String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code"
        + "&client_id=" + clientId
        + "&client_secret=" + clientSecret
        + "&redirect_uri=" + redirectURI
        + "&code=" + code
        + "&state=" + state;
    String accessToken = "";
    String refresh_token = "";
    try {
      URL url = new URL(apiURL);
      HttpURLConnection con = (HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      int responseCode = con.getResponseCode();
      BufferedReader br;
      if (responseCode == 200) { // 정상 호출
        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
      } else {  // 에러 발생
        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
      }
      String inputLine;
      StringBuilder res = new StringBuilder();
      while ((inputLine = br.readLine()) != null) {
        res.append(inputLine);
      }
      br.close();
      if (responseCode == 200) {
    	    String resStr = res.toString();
    	    
    	    JSONObject jsonRes = new JSONObject(resStr);
    	    accessToken = jsonRes.getString("access_token"); // 액세스 토큰 추출

    	    session.setAttribute("accessToken", accessToken); // 세션에 액세스 토큰 저장

    	    out.println(resStr);
    	}
    	br.close();
    } catch (Exception e) {
      // Exception 로깅
    }
  %>
  <a href="${pageContext.request.contextPath}/member/profile">정보확인</a>
  
  </body>
</html>