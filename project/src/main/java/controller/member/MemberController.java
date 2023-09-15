	package controller.member;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;
import service.community.CommunityService;
import service.member.MemberService;
import service.shopping.ShoppingService;
import vo.brand.BrandVO;
import vo.brandinfo.BrandInfoVO;
import vo.brandproduct.BrandProductVO;
import vo.majorcategory.MajorCategoryVO;
import vo.member.MemberVO;
import vo.middlecategory.MiddleCategoryVO;
import vo.post.PostVO;
import vo.smallcategory.SmallCategoryVO;

@Controller
public class MemberController {

	private MemberService memberService;
	private CommunityService communityService;
	
	public MemberController(
			MemberService memberService,
			CommunityService communityService
			) {
		this.memberService = memberService;
		this.communityService = communityService;
	}
	@RequestMapping("/mypage/house")
	public String house(HttpSession session, HttpServletRequest request) {
		
		MemberVO login = (MemberVO)session.getAttribute("login");
		System.out.println(login.getIdx());
		List<PostVO> post = communityService.selectMy(login.getIdx());
		int pcnt = communityService.selectCntP(login.getIdx());
		int hcnt = communityService.selectCntH(login.getIdx());
		MemberVO lo = memberService.selectOne(login.getIdx());
		int like = memberService.likesMCnt(login.getIdx());
		int scrap = memberService.scrapMCnt(login.getIdx());

		request.setAttribute("like", like);
		request.setAttribute("scrap", scrap);
		request.setAttribute("lo", lo);
		request.setAttribute("pcnt", pcnt);
		request.setAttribute("hcnt", hcnt);

		request.setAttribute("post", post);
		
		return ViewPath.MYPAGE + "house.jsp";
	}


	
	
	// 마이페이지
	@RequestMapping("/mypage/mypage")
	public String myPage(HttpSession session, HttpServletRequest request) {
		
		MemberVO login = (MemberVO)session.getAttribute("login");
		MemberVO lo = memberService.selectOne(login.getIdx());
		System.out.println(login.getIdx());
		int follow = memberService.followCnt(login.getIdx());
		int follower = memberService.followerCnt(login.getIdx());
		List<PostVO> post = communityService.selectMy(login.getIdx());
		int pcnt = communityService.selectCntP(login.getIdx());
		int hcnt = communityService.selectCntH(login.getIdx());
		
		int like = memberService.likesMCnt(login.getIdx());
		int scrap = memberService.scrapMCnt(login.getIdx());

		request.setAttribute("like", like);
		request.setAttribute("scrap", scrap);
		
		request.setAttribute("lo", lo);
		request.setAttribute("pcnt", pcnt);
		request.setAttribute("hcnt", hcnt);
		request.setAttribute("follow", follow);
		request.setAttribute("follower", follower);
		request.setAttribute("post", post);
		
		return ViewPath.MYPAGE + "myPage.jsp";
	}
	
	@RequestMapping("/mypage/photo")
	public String photo(HttpSession session, HttpServletRequest request) {
		
		MemberVO login = (MemberVO)session.getAttribute("login");
		System.out.println(login.getIdx());
		List<PostVO> post = communityService.selectMy(login.getIdx());
		int pcnt = communityService.selectCntP(login.getIdx());
		int hcnt = communityService.selectCntH(login.getIdx());
		
		MemberVO lo = memberService.selectOne(login.getIdx());
		int like = memberService.likesMCnt(login.getIdx());
		int scrap = memberService.scrapMCnt(login.getIdx());

		request.setAttribute("like", like);
		request.setAttribute("scrap", scrap);
		request.setAttribute("lo", lo);
		request.setAttribute("pcnt", pcnt);
		request.setAttribute("hcnt", hcnt);

		request.setAttribute("post", post);
		
		return ViewPath.MYPAGE + "photo.jsp";
	}
	

	@RequestMapping("/mypage/knowhow")
	public String knowhow(HttpSession session, HttpServletRequest request) {
		
		MemberVO login = (MemberVO)session.getAttribute("login");
		System.out.println(login.getIdx());
		List<PostVO> post = communityService.selectMy(login.getIdx());
		int pcnt = communityService.selectCntP(login.getIdx());
		int hcnt = communityService.selectCntH(login.getIdx());
		MemberVO lo = memberService.selectOne(login.getIdx());
		int like = memberService.likesMCnt(login.getIdx());
		int scrap = memberService.scrapMCnt(login.getIdx());

		request.setAttribute("like", like);
		request.setAttribute("scrap", scrap);
		request.setAttribute("lo", lo);
		request.setAttribute("pcnt", pcnt);
		request.setAttribute("hcnt", hcnt);

		request.setAttribute("post", post);
		
		return ViewPath.MYPAGE + "knowhow.jsp";
	}



	
	@RequestMapping("/mypage/changePw")
	public String changePw() {
		return ViewPath.MYPAGE + "changePw.jsp";
	}	
	
	@RequestMapping("/member/pwreset")
	public String pwReset() {
		return ViewPath.MEMBER + "pwReset.jsp";
	}
	
	@RequestMapping("/member/rePW")
	public String rePW(HttpServletRequest request, Model model) {
		return ViewPath.MEMBER + "rePW.jsp";
	}
	
	@RequestMapping("/member/pwSetting")
	public String pwreSetting(HttpServletRequest request,String email,MemberVO vo, Model model) {
		// 이메일 체크
		List<String> member_email = memberService.selectEmail();
		request.setAttribute("member_email",member_email);
		
		int idx = 0;
		
		for (String check : memberService.selectEmail()) {
		    if(email.equals(check)) {
		    	idx = memberService.checkEmail(email);
		    	vo = memberService.selectOne(idx);
		    	vo.setEmail(email);
		    }
		}

		String msg = null;
		String url = null;
		
		if(idx != 0) {
			msg = vo.getNickname() + "님의 비밀번호를 재설정합니다.";
			request.getSession().setAttribute("login", vo);
			request.getSession().setAttribute("msg", msg);
			
			model.addAttribute("login", vo);
			return ViewPath.MEMBER + "rePW.jsp";
		}else{
			msg = "로그인가능한 이메일이 존재하지 않습니다.";
			request.getSession().setAttribute("msg", msg);
			
			url = "/project/member/loginform";
			request.getSession().setAttribute("url", url);
			return ViewPath.MEMBER + "loginResult.jsp";
		}
	}
	
	@RequestMapping("/member/updatePW")
	public String updatePW(HttpSession session,Model model, HttpServletRequest request,String Reuserpw) {
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		MemberVO vo = memberService.selectOne(login.getIdx());
		
		vo.setUserpw(Reuserpw);

		int su = memberService.update(vo);
		
		String url = null;
		String msg = null;
		
		if(su != 0) {
			msg = login.getNickname() + "님의 비밀번호가 변경되었습다.";
			url = "/project/member/loginform";
			
			request.getSession().setMaxInactiveInterval(60 * 60);
			request.getSession().setAttribute("login", login);
			
		}else{
			msg = "변경 실패";
			url = "/project";
		}
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		return ViewPath.MEMBER+"loginResult.jsp";
	}
	
	
}
