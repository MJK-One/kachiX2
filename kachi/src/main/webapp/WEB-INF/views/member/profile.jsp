<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head><title>네이버로그인</title></head>

  <body>

  <% 
  String token = (String) session.getAttribute("accessToken"); // 세션에서 액세스 토큰 가져오기
    String header = "Bearer " + token; // Bearer 타입의 Authorization 헤더
    String token1 = (String) session.getAttribute("accessToken");
    try {
      String apiURL = "https://openapi.naver.com/v1/nid/me";
      URL url = new URL(apiURL);
      HttpURLConnection con = (HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      con.setRequestProperty("Authorization", header);
      
      int responseCode = con.getResponseCode();
      BufferedReader br;
      
      if(responseCode == 200) { // 정상 호출
        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        
        StringBuilder sb = new StringBuilder();
        String line;
        
        while((line = br.readLine()) != null) {
          sb.append(line);
        }
        
        br.close();

        out.println(sb.toString()); // 응답 출력 (사용자 정보)
        
      } else {  // 에러 발생
        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        
        StringBuilder sbErrorResult= new StringBuilder();
        String line;
        
        while((line=br.readLine())!=null){
          sbErrorResult.append(line);
         }
         
         out.println(sbErrorResult.toString()); // 에러 메시지 출력
         
         br.close();   
       }
       
       con.disconnect();

    } catch (Exception e) {
       out.println(e); // 예외 처리
    }
    
  %> 
   <a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>

 </body>
</html> 