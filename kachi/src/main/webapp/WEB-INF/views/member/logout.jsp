<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head><title>네이버로그인</title></head>

  <body>

  <% 
    String clientId = "mp5bUy7BFPU5qVPt5OgE"; // 클라이언트 ID
    String clientSecret = "rrpmQIm5cT"; // 클라이언트 시크릿
    String token = (String) session.getAttribute("accessToken"); // 세션에서 액세스 토큰 가져오기

    try {
      String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=delete"
        + "&client_id=" + clientId
        + "&client_secret=" + clientSecret
        + "&access_token=" + token
        + "&service_provider=NAVER";
      
      URL url = new URL(apiURL);
      HttpURLConnection con = (HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      
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

        out.println(sb.toString()); // 응답 출력 (토큰 삭제 결과)
        
      } else {  // 에러 발생
         br=new BufferedReader(new InputStreamReader(con.getErrorStream()));
         
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

 </body>
</html> 
