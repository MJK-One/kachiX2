package controller.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.member.MemberService;
import service.shopping.ShoppingService;
import vo.follow.FollowVO;
import vo.likes.LikesVO;
import vo.majorcategory.MajorCategoryVO;
import vo.scrap.ScrapVO;


@RestController
public class AjaxController {
	
	private MemberService memberService;

		
	public AjaxController(
			MemberService memberService
			) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/ajax/follow")
	@ResponseBody
	public String follow(int member_idx, int follow_idx) {
		
		FollowVO vo = new FollowVO();
		
		vo.setFollow_idx(follow_idx);
		vo.setMember_idx(member_idx);

		Object su = memberService.insert(vo);
		
		return su + "";
			
	}
	
	@RequestMapping("/ajax/follower")
	@ResponseBody
	public String follower(int member_idx, int follow_idx) {
		
		FollowVO vo = new FollowVO();
		
		vo.setFollow_idx(follow_idx);
		vo.setMember_idx(member_idx);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("member_idx",member_idx);
		map.put("follow_idx",follow_idx);
		
		Object su = memberService.follow_delete(map);
		
		return su + "";
			
	}
	@RequestMapping("/ajax/likes")
   @ResponseBody
   public String likes(int member_idx, int post_idx) {
      
      LikesVO vo = new LikesVO();
      
      vo.setPost_idx(post_idx);
      vo.setMember_idx(member_idx);
      

      memberService.insert(vo);
      
      return post_idx + "";
         
   }
	
	@RequestMapping("/ajax/likesdelete")
   @ResponseBody
   public String likesDelete(int member_idx, int post_idx) {
      
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("member_idx",member_idx);
		map.put("post_idx",post_idx);
		
		System.out.println(post_idx);
		
		memberService.likes_delete(map);
      
      return post_idx + "";
         
   }
	
	@RequestMapping("/ajax/scrap")
    @ResponseBody
    public String scrap(int member_idx, int post_idx) {
	
		ScrapVO vo = new ScrapVO();
		
		vo.setMember_idx(member_idx);
		vo.setPost_idx(post_idx);
		
		memberService.insert(vo);
	
		return post_idx + "";

   }

	@RequestMapping("ajax/scrapdelete")
	@ResponseBody
	public String scrapDelete(int member_idx, int post_idx) {
	
    	Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("member_idx",member_idx);
		map.put("post_idx",post_idx);
		
		System.out.println(post_idx);
		
		memberService.scrap_delete(map);
	
		return post_idx + "";

  }
    
}
