package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;
import service.member.MemberService;
import vo.member.MemberVO;

@Controller
public class LoginController {
	private MemberService memberService;

	
	public LoginController(
			MemberService memberService
			) {
		this.memberService = memberService;
	}

		
	
	@RequestMapping("/member/loginform")
	public String loginForm() {
		return ViewPath.MEMBER + "loginForm.jsp";
	}
	
	@RequestMapping("/member/login")
	public String checkLogin(HttpServletRequest request,HttpServletResponse response, MemberVO vo, Model model) {
		
		// 로그인체크
		int idx = memberService.checkLogin(vo);
		
		MemberVO login = memberService.selectOne(idx);
		
		String url = null;
		String msg = null;
		
		if(idx != 0) {
			msg = login.getNickname() + "님이 로그인하셨습니다.";
			url = "/project/community/mainpage";
			
			request.getSession().setMaxInactiveInterval(60 * 60);
			
			request.getSession().setAttribute("login", login);
			
		}else{
			msg = "아이디 혹은 비밀번호가 잘못되었습니다.";
			url = "/project/";
		}
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		return ViewPath.MEMBER + "loginResult.jsp";
	}
	@RequestMapping("/member/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return ViewPath.MEMBER + "logout.jsp";
	}
}
