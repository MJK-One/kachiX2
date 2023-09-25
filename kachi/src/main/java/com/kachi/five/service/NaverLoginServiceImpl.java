package com.kachi.five.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kachi.five.DAO.UserDAO;
import com.kachi.five.bean.UserBean;
@Service
public class NaverLoginServiceImpl implements NaverLoginService {
	@Autowired UserDAO userdao;
	
	 private static final String CLIENT_ID = "mp5bUy7BFPU5qVPt5OgE"; // 애플리케이션 클라이언트 아이디값
	 private static final String CLIENT_SECRET = "rrpmQIm5cT"; // 애플리케이션 클라이언트 시크릿값

	 
	@Override	
	public String getAccessToken(String code, String state) throws Exception {
		
		 String redirectURI = URLEncoder.encode("http://localhost:8080/five/member/naver_callback", "UTF-8");

	        // Step 1: 액세스 토큰 요청 및 처리
	        String apiURLTokenRequest = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code"
	                + "&client_id=" + CLIENT_ID
	                + "&client_secret=" + CLIENT_SECRET
	                + "&redirect_uri=" + redirectURI
	                + "&code=" + code
	                + "&state=" + state;

	        URL urlTokenRequest = new URL(apiURLTokenRequest);
	        HttpURLConnection conTokenRequest = (HttpURLConnection) urlTokenRequest.openConnection();
	        conTokenRequest.setRequestMethod("GET");

	        int responseCodeAccessTokenRequest = conTokenRequest.getResponseCode();
	        String accessTokenForProfileAPIUsage = "";

	        if (responseCodeAccessTokenRequest == 200) { // 정상 호출
	            BufferedReader br = new BufferedReader(new InputStreamReader(conTokenRequest.getInputStream()));
	            StringBuilder resAccessTokenRequest = new StringBuilder();
	            String inputLineAccessTokenRequest;

	            while ((inputLineAccessTokenRequest = br.readLine()) != null) {
	                resAccessTokenRequest.append(inputLineAccessTokenRequest);
	            }

	            JSONObject jsonResAccessTokenRequest = new JSONObject(resAccessTokenRequest.toString());
	            accessTokenForProfileAPIUsage = jsonResAccessTokenRequest.getString("access_token");
	            
	            br.close();
	            
	          } else { 
	              throw new Exception("에러 : 토큰에 접근 할 수 없습니다.");
	          }

	      return accessTokenForProfileAPIUsage; 
	}

	@Override
	public UserBean getUserProfile(String accessToken) throws Exception {
		 // Step 2: 사용자 프로필 요청 및 처리
        
	       UserBean userBean = new UserBean();

	       try{
	           URL url=new URL("https://openapi.naver.com/v1/nid/me");
	           HttpURLConnection conn=(HttpURLConnection)url.openConnection();
	           conn.setRequestMethod("GET");
	           conn.setRequestProperty("Authorization", "Bearer "+accessToken);
	           
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
	               JSONObject response=json.getJSONObject("response");

	               if(response.has("id")) userBean.setUserID(response.getString("id"));
	               if(response.has("name")) userBean.setName(URLDecoder.decode(response.getString("name"), "UTF-8"));
	               if(response.has("nickname")) userBean.setNickname(URLDecoder.decode(response.getString("nickname"), "UTF-8"));
	               if(response.has("email")) userBean.setEmail(response.getString("email"));
	               if (response.has("gender")) userBean.setGender(response.getString("gender")); 
	               if (response.has("birthyear")) userBean.setBirthYear(response.getString("birthyear"));
	               if (response.has("mobile")) userBean.setPhoneNumber(response.getString("mobile"));
	           } else { 
	              throw new Exception ("에러 : 유저의 정보를 가져오지 못했습니다.");
	           }
	       } catch(Exception e){
	           e.printStackTrace();
	       }

	       return userBean;
	}
	 @Override
	    public void insertUser(UserBean user) throws Exception {
	        try {
	        	if(userdao.getUser(user.getUserID()) == null) { userdao.insertUser(user); }
	        	else { System.out.println("사용자의 값이 이미 있습니다."); }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Error inserting user: " + e.getMessage());
	        }
	    }

}
