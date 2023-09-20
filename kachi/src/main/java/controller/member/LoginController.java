package controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class LoginController {
	
	@RequestMapping("/member/loginform")
	public String loginform() {
			return "member/loginForm";
	}
	
	
	@RequestMapping("/member/naver_callback")
	public String naver_callback() {
		return "member/naver_callback";
	}
	
	
	@RequestMapping("/member/profile")
	public String profile() {
		return "member/profile";
	}
	
	@RequestMapping("/member/logout")
	public String logout() {
		return "member/logout";
	}
}
