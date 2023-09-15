package controller.member;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import common.ViewPath;
import service.community.CommunityService;
import service.member.MemberService;
import service.shopping.ShoppingService;
import vo.member.MemberVO;
import vo.post.PostVO;

@Controller
public class UpdateController {
	
	private MemberService memberService;
	private ShoppingService shoppingService;
	private CommunityService communityService;
	
	@Autowired
	private ServletContext application;
	
	public UpdateController (
			MemberService memberService,
			ShoppingService shoppingService,
			CommunityService communityService
			) {
		this.memberService = memberService;
		this.shoppingService = shoppingService;
		this.communityService = communityService;
	}
	
	// 회원수정페이지
	@RequestMapping("/mypage/updatepage")
	public String updatePage(HttpSession session, HttpServletRequest request, Model model) {
		
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		MemberVO vo = memberService.selectOne(login.getIdx());
		
		model.addAttribute("vo", vo);
		
		return ViewPath.MYPAGE + "update.jsp";
	}
	
	// 회원수정
	
	@RequestMapping("/mypage/update")
	public String update(HttpSession session, HttpServletRequest request, MemberVO vo, Model model) {
		
		MemberVO member = memberService.selectOne(vo.getIdx());

		String savePath = application.getRealPath("/resources/profile");

		String filename = null;
		
		MultipartFile photo = vo.getPhoto();
		
		if(photo != null && !photo.isEmpty()) {
			
			filename = photo.getOriginalFilename(); // 업로드된 파일명
			//File 객체 생성
			File saveFile = new File(savePath,filename);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}else {
				long time = System.currentTimeMillis();
				
				filename = String.format("%s%d%s", filename.substring(0, filename.lastIndexOf(".")),time,filename.substring(filename.lastIndexOf(".")));
			
				saveFile = new File(savePath,filename);
			}
			
			//업로드된 파일은 MultipartResolver라는 클래스가 지정한 임시 저장소에 저장되어 있다...
			//파일이 일정한 시간이 지나면 사라지기 때문에 내가 지정한 경로로 복사해주면 된다...
			
			try {
				photo.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			vo.setM_picture(filename);
		}else {
			vo.setM_picture("프로필.png");
		}
		
		System.out.println(vo);
		
		System.out.println(vo.getAgree_email());
		System.out.println(vo.getAgree_marketing());
		System.out.println(vo.getBirth_date());
		System.out.println(vo.getHomepage());
		System.out.println(vo.getIntroduce());
		System.out.println(vo.getM_picture());
		System.out.println(vo.getNickname());
		System.out.println(vo.getUserkind());
		
		
		int su = memberService.update(vo);
		System.out.println(su);
		
		String url = null;
		String msg = null;
		
		if(su != 0){
			msg = "수정 성공했습니다";
			url = "/project/mypage/mypage";		
		}else{
			msg = "수정 성공했습니다";
			url = "/project/mypage/updatepage";		
		}
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		return ViewPath.MYPAGE + "updateResult.jsp";
	}

}
