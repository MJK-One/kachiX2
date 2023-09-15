package controller.community;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import common.ViewPath;
import service.community.CommunityService;
import service.member.MemberService;
import vo.follow.FollowVO;
import vo.likes.LikesVO;
import vo.member.MemberVO;
import vo.post.PostVO;
import vo.scrap.ScrapVO;

@Controller
public class CommunityController {
	
	private CommunityService communityService;
	private MemberService memberService;
	
	@Autowired
	private ServletContext application;
	
	public CommunityController(
			CommunityService communityService,
			MemberService memberService
			) {
		
		this.communityService = communityService;
		this.memberService = memberService;
	}
	
	@RequestMapping("/community/mainpage")
	public String mainPage(HttpServletRequest request) {
		
		List<PostVO> post1 = communityService.post_selectList("집들이");
		List<PostVO> post2 = communityService.post_selectList("사진");
		
		request.setAttribute("post1", post1);
		request.setAttribute("post2", post2);
		
		return ViewPath.COMMUNITY + "mainPage.jsp";
	}
	
	@RequestMapping("/community/postupload")
	public String postUpload(HttpServletRequest request, String kind) {
		request.setAttribute("kind", kind);
		return ViewPath.COMMUNITY + "postUpload.jsp";
	}
	
	@RequestMapping("/post/write")
	public String write(Model model, PostVO vo, HttpSession session, String kind) {
		
		
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		if(login == null) {
			return "redirect:/member/loginform";
		}
		
		vo.setMember_idx(login.getIdx());
		
		System.out.println(kind);
		vo.setKind(kind);
		
		int idx = communityService.getIdx();
		
		System.out.println(idx);
		
		vo.setIdx(idx);
		
		System.out.println(vo.getIdx());
		
		String savePath = application.getRealPath("/resources/post/" + vo.getIdx());

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
			
			vo.setPicture(filename);
		}else {
			vo.setPicture("no_file");
		}
		
		int su = communityService.insert(vo);
		
		model.addAttribute("su", su);
		model.addAttribute("url", "/project/community/mainpage");
		
		return ViewPath.COMMUNITY + "postResult.jsp";
	}
	
	@RequestMapping("/community/housephoto")
	public String housePhoto(HttpServletRequest request, HttpSession session) {
		
		MemberVO login = (MemberVO)session.getAttribute("login");
		List<PostVO> post = communityService.post_selectList("사진");
		
		for(PostVO vo : post) {
			List<ScrapVO> svo = memberService.scrap_selectList(vo.getIdx());
			List<LikesVO> lvo = memberService.likes_selectList(vo.getIdx());
			int like = memberService.likesPCnt(vo.getIdx());
			int scrap = memberService.scrapPCnt(vo.getIdx());
			vo.setLikesPCnt(like);
			vo.setScrapPCnt(scrap);
			for(ScrapVO s : svo) {
				if(vo.getIdx() == s.getPost_idx()) {
					if(s.getMember_idx() == login.getIdx()) {
						vo.setCheck(1);	
					}else {
						vo.setCheck(0);	
					}
				}
			}
			for(LikesVO l : lvo) {
				if(vo.getIdx() == l.getPost_idx()) {
					if(l.getMember_idx() == login.getIdx()) {
						vo.setLcheck(1);
					}else {
						vo.setCheck(0);
					}
				}	
			}
		}
		
		request.setAttribute("post", post);
		
		return ViewPath.COMMUNITY + "housephoto.jsp";
	}
	
	@RequestMapping("/community/housewarming")
	public String houseWarming(HttpServletRequest request, HttpSession session) {
		
		List<PostVO> post = communityService.post_selectList("집들이");
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		int check = 0;
		for(PostVO vo : post) {
			List<ScrapVO> svo = memberService.scrap_selectList(vo.getIdx());
			int like = memberService.likesPCnt(vo.getIdx());
			int scrap = memberService.scrapPCnt(vo.getIdx());
			vo.setLikesPCnt(like);
			vo.setScrapPCnt(scrap);
			for(ScrapVO s : svo) {
				if(vo.getIdx() == s.getPost_idx()) {
					if(s.getMember_idx() == login.getIdx()) {
						check = 1;
						vo.setCheck(check);
					}else {
						check = 0;
						vo.setCheck(check);
					}
				}
			}
		}
		
		request.setAttribute("post", post);
		
		return ViewPath.COMMUNITY + "housewarming.jsp";
	}
	
	@RequestMapping("/community/recommendation")
	public String recommendation(HttpServletRequest request) {
		
		List<PostVO> post = communityService.post_selectList("집들이");
		
		request.setAttribute("post", post);
		
		return ViewPath.COMMUNITY + "recommendation.jsp";
	}
	
	@RequestMapping("/community/event")
	public String event(HttpServletRequest request) {
		
		List<PostVO> post = communityService.post_selectList("집들이");
		
		request.setAttribute("post", post);
		
		return ViewPath.COMMUNITY + "event.jsp";
	}
	
	@RequestMapping("/community/hobby")
	public String hobby(HttpServletRequest request) {
		
		List<PostVO> post = communityService.post_selectList("집들이");
		
		request.setAttribute("post", post);
		
		return ViewPath.COMMUNITY + "hobby.jsp";
	}
	
	@RequestMapping("/community/homerestaurant")
	public String homerestaurant(HttpServletRequest request) {
		
		List<PostVO> post = communityService.post_selectList("집들이");
		
		request.setAttribute("post", post);
		
		return ViewPath.COMMUNITY + "homerestaurant.jsp";
	}
	
	@RequestMapping("/community/housekeeping")
	public String housekeeping(HttpServletRequest request) {
		
		List<PostVO> post = communityService.post_selectList("집들이");
		
		request.setAttribute("post", post);
		
		return ViewPath.COMMUNITY + "housekeeping.jsp";
	}
	
	@RequestMapping("/community/detail")
	public String detail(HttpServletRequest request, HttpSession session, int idx) {
		MemberVO login = (MemberVO)session.getAttribute("login");
		PostVO post = communityService.selectOne(idx);
		String content = post.getContent();
		
		post.setHit(post.getHit() + 1);
		communityService.update(post);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("member_idx",login.getIdx());
		map.put("follow_idx",post.getMember_idx());
		
		int check = memberService.check(map);
		
		System.out.println(check);
		
		post.setContent(content.replaceAll("<br>", "\r\n"));
		
		request.setAttribute("post", post);
		request.setAttribute("check", check);
		
		return ViewPath.COMMUNITY + "detail.jsp";
	}
	
	@RequestMapping("/community/photodetail")
	public String photoDetail(HttpServletRequest request, int idx) {
		
		PostVO post = communityService.selectOne(idx);
		
		post.setHit(post.getHit() + 1);
		
		communityService.update(post);
		
		String content = post.getContent();
		
		post.setContent(content.replaceAll("<br>", "\r\n"));
		
		request.setAttribute("post", post);
		
		return ViewPath.COMMUNITY + "photodetail.jsp";
	}


}
