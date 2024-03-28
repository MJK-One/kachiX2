package com.kachi.five.service;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import org.json.JSONObject;

import com.kachi.five.bean.UserBean;

public class LogoutServiceImpl implements LogoutService {

    private static final String CLIENT_ID = "";
    private static final String CLIENT_SECRET = "";
	
	@Override
	 public void logout(UserBean user) {
        if (user != null) {
            String accessToken = user.getAccessToken();

            try {
                URL url=new URL("https://nid.naver.com/oauth2.0/token?grant_type=delete&client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&access_token=" + accessToken + "&service_provider=NAVER");
                HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                conn.setRequestMethod("GET");

                int responseCode=conn.getResponseCode();

                if(responseCode==200){
                    BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer buffer=new StringBuffer();
                    while(true){
                        String string=reader.readLine();
                        if(string==null) break;
                        buffer.append(string);
                    }
                    
                    JSONObject json=new JSONObject(buffer.toString());

                    // 응답 코드가 "success"인 경우, 토큰 폐기 성공
                    if (json.getString("result").equals("success")) {
                        System.out.println("토큰 폐기 성공");
                    } else {
                        System.out.println("토큰 폐기 실패");
                    }
                } else { 
                   System.out.println("토큰 폐기 요청 실패");
               }
           } catch(Exception e){
               e.printStackTrace();
           }
       }
   }

}
