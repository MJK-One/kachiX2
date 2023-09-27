package controller.member;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kachi.five.DAO.UserDAO;
import com.kachi.five.bean.UserBean;
import com.kachi.five.service.NaverLoginService;
import com.kachi.five.service.TestService;


@Controller

public class LoginController {
	@Inject
	
	TestService service;
	@Autowired NaverLoginService naverLoginService;
	
	
	@RequestMapping("/member/loginform")
	public String loginform() {
		
			return "member/loginForm";
	}
	
	
	 @RequestMapping("/member/naver_callback")
	 public String naverCallback(@RequestParam("code") String code,
             @RequestParam("state") String state,
             HttpServletRequest request,
             HttpServletResponse response
              ) {

		if (!state.equals(request.getSession().getAttribute("state"))) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return "error/unauthorized"; 
		}
		
		try {
			String accessTokenForProfileAPIUsage = naverLoginService.getAccessToken(code, state);
			UserBean user = naverLoginService.getUserProfile(accessTokenForProfileAPIUsage);
			
		if (user != null) { naverLoginService.insertUser(user);
		
			// 로그인한 사용자의 정보를 세션에 저장
	       HttpSession session = request.getSession();
	       
	       // DB에서 writePermission 값 조회 및 세션에 저장
	       
	       session.setAttribute("writePermission", user.getWritePermission() == 1);
	       
	       session.setAttribute("loggedInUser", user);
		}
		} catch (Exception e) { 
			e.printStackTrace();
			System.out.println("Error inserting user: " + e.getMessage());}
		
		return "redirect:/";
	}

	

	
	@RequestMapping("/member/logout")
	public String logout(HttpServletRequest request) {
		   HttpSession session = request.getSession();
		   session.invalidate();  // 현재 세션을 무효화하여 모든 데이터 삭제
		   
		   return "redirect:/";
	}
	@RequestMapping("/member/test")
	public String test(Model model) throws Exception {
		List<UserBean> list;		

		list = service.test();	

		model.addAttribute("list",list);
		return "member/test";
	}
}
