package controller.member;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kachi.five.DAO.UserDAO;
import com.kachi.five.bean.UserBean;


@Controller

public class LoginController {
	
	@Autowired UserDAO userdao;
	
	@RequestMapping("/member/loginform")
	public String loginform() {
		
			return "member/loginForm";
	}
	
	
	 @RequestMapping("/member/naver_callback")
	    public String naverCallback(@RequestParam("code") String code, @RequestParam("state") String state,
	                                HttpServletRequest request, HttpServletResponse response, Model model) {
	        String clientId = "mp5bUy7BFPU5qVPt5OgE"; // 애플리케이션 클라이언트 아이디값
	        String clientSecret = "rrpmQIm5cT"; // 애플리케이션 클라이언트 시크릿값

	        // 상태 토큰 검증
	        String storedState = (String) request.getSession().getAttribute("state");
	        if (!state.equals(storedState)) {
	            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	            return "error/unauthorized"; // 401 Unauthorized 페이지로 이동
	        }

	        try {
	            String redirectURI = URLEncoder.encode("http://localhost:8080/five/member/naver_callback", "UTF-8");

	            // Step 1: 액세스 토큰 요청 및 처리
	            String apiURLTokenRequest = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code"
	                    + "&client_id=" + clientId
	                    + "&client_secret=" + clientSecret
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

	                request.getSession().setAttribute("accessToken", accessTokenForProfileAPIUsage);
	                br.close();
	            } else { // 에러 발생
	                BufferedReader br = new BufferedReader(new InputStreamReader(conTokenRequest.getErrorStream()));
	                // 에러 처리 코드 추가
	            }

	            // Step 2: 사용자 프로필 요청 및 처리
	            String apiURLProfileRequest = "https://openapi.naver.com/v1/nid/me";
	            URL urlProfileRequest = new URL(apiURLProfileRequest);
	            HttpURLConnection conUserProfileRequest = (HttpURLConnection) urlProfileRequest.openConnection();
	            conUserProfileRequest.setRequestMethod("GET");
	            conUserProfileRequest.setRequestProperty("Authorization", "Bearer " + accessTokenForProfileAPIUsage);

	            int responseCodeUserProfileRequest = conUserProfileRequest.getResponseCode();

	            if (responseCodeUserProfileRequest == 200) { // 정상 호출
	                BufferedReader br = new BufferedReader(new InputStreamReader(conUserProfileRequest.getInputStream()));
	                StringBuilder res = new StringBuilder();
	                String inputLineUserProfileRequest;

	                while ((inputLineUserProfileRequest = br.readLine()) != null) {
	                    res.append(inputLineUserProfileRequest);
	                }

	                JSONObject jsonRes = new JSONObject(res.toString());
	                
	                // 네이버 API 응답에서 필요한 값 추출하여 User 객체 생성 
	      		    JSONObject responseJson = jsonRes.getJSONObject("response");
	      		    
	                UserBean user = new UserBean();
	               
	                	
	                if (responseJson.has("id")) {
	                    user.setUserID(responseJson.getString("id"));
	                }

	                try{
	                    if (responseJson.has("name")) {
	                        user.setName(URLDecoder.decode(responseJson.getString("name"), "UTF-8"));
	                    }
	                    
	                    if (responseJson.has("nickname")) {
	                        user.setNickname(URLDecoder.decode(responseJson.getString("nickname"), "UTF-8"));
	                    }
	                } catch(UnsupportedEncodingException e){
	                    e.printStackTrace();
	                }

	                if (responseJson.has("email")) {
	                    user.setEmail(responseJson.getString("email"));
	                }

	                if (responseJson.has("gender")) {
	                    user.setGender(responseJson.getString("gender"));
	                }

	                if (responseJson.has("birthyear")) {
	                  	user.setBirthYear(responseJson.getString("birthyear"));
	                }
	                  
	                if (responseJson.has("mobile")) {
	                  	user.setPhoneNumber(responseJson.getString("mobile"));
	                }
	    	  	  
		    	  	  
		    	  	  // DAO 를 통해 DB에 저장 
		    		  userdao.insertUser(user);

		    		  model.addAttribute("userProfile", res.toString());
		    		  
	                br.close();
	            } else { // 에러 발생
	                BufferedReader br = new BufferedReader(new InputStreamReader(conUserProfileRequest.getErrorStream()));
	                // 에러 처리 코드 추가
	            }
	        } catch (Exception e) {
	            // 예외 처리 코드 추가
	        }

	        return "redirect:/"; 
	    }
	
	

	
	@RequestMapping("/member/logout")
	public String logout() {
		return "member/logout";
	}
}
