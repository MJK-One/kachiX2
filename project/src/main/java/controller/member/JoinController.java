package controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;
import service.member.MemberService;
import vo.member.MemberVO;

@Controller
public class JoinController {
	
	private MemberService memberService;

	
	public JoinController(
			MemberService memberService
			) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/member/joinform")
	public String joinForm() {
		return ViewPath.MEMBER + "joinForm.jsp";
	}
	
	@RequestMapping("/member/join")
	public String join(Model model, MemberVO vo) {
		
		vo.setM_picture("프로필.png");
		
		int su = memberService.insert(vo);
		
		String url = null;
		String msg = null;
		
		if(su != 0){
			msg = "회원가입 성공했습니다";
			url = "/project/member/loginform";		
		}else{
			msg = "회원가입 실패했습니다";
			url = "/project/member/joinform";
		}
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		return ViewPath.MEMBER + "joinResult.jsp";
	}
	
}
