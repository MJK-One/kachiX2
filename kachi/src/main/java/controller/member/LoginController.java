package controller.member;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class LoginController {
	
	
	
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

	                // 예제에서는 사용자 프로필 정보를 모델에 저장하여 뷰로 전달합니다.
	                model.addAttribute("userProfile", res.toString());

	                br.close();
	            } else { // 에러 발생
	                BufferedReader br = new BufferedReader(new InputStreamReader(conUserProfileRequest.getErrorStream()));
	                // 에러 처리 코드 추가
	            }
	        } catch (Exception e) {
	            // 예외 처리 코드 추가
	        }

	        return "member/naver_callback"; 
	    }
	
	

	
	@RequestMapping("/member/logout")
	public String logout() {
		return "member/logout";
	}
}
