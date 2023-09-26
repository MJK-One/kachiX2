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
	
	 private static final String CLIENT_ID = "mp5bUy7BFPU5qVPt5OgE";
	 private static final String CLIENT_SECRET = "rrpmQIm5cT"; 

	 
	@Override	
	public String getAccessToken(String code, String state) throws Exception {
		
		 String redirectURI = URLEncoder.encode("http://localhost:8080/five/member/naver_callback", "UTF-8");

	       
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

	        if (responseCodeAccessTokenRequest == 200) { // ���� ȣ��
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
	              throw new Exception("토큰을 받아오지 못했습니다.");
	          }

	      return accessTokenForProfileAPIUsage; 
	}

	@Override 
	public UserBean getUserProfile(String accessToken) throws Exception {
	
        
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
	               userBean.setAccessToken(accessToken);
	               
	               if(response.has("id")) { userBean.setUserID(response.getString("id"));
	               String userID = response.getString("id");
	               // DB에서 writePermission 값 조회 및 UserBean에 저장
	               int writePermission = userdao.getWritePermission(userID);
	               userBean.setWritePermission(writePermission);
	               }
	               if(response.has("name")) userBean.setName(URLDecoder.decode(response.getString("name"), "UTF-8"));
	               if(response.has("nickname")) userBean.setNickname(URLDecoder.decode(response.getString("nickname"), "UTF-8"));
	               if(response.has("email")) userBean.setEmail(response.getString("email"));
	               if (response.has("gender")) userBean.setGender(response.getString("gender")); 
	               if (response.has("birthyear")) userBean.setBirthYear(response.getString("birthyear"));
	               if (response.has("mobile")) userBean.setPhoneNumber(response.getString("mobile"));
	              
	           } else { 
	              throw new Exception ("데이터를 받아오지 못했습니다..");
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
	        	else { System.out.println("데이터 베이스에 이미 정보가 있습니다."); }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Error inserting user: " + e.getMessage());
	        }
	    }

}
