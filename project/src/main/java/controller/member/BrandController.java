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
import service.member.BrandService;
import service.member.MemberService;
import service.shopping.CategoryService;
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
public class BrandController {

	private BrandService brandService;
	private CategoryService categoryService;
	private MemberService memberService;
	
	public BrandController(
			BrandService brandService,
			CategoryService categoryService,
			MemberService memberService
			) {
		this.brandService = brandService;
		this.categoryService = categoryService;
		this.memberService = memberService;
	}
	
	@RequestMapping("/brand/brandupload")
	public String brandUpload(HttpServletRequest request) {
		
		List<MajorCategoryVO> major = categoryService.selectName("쇼핑");
		
		request.setAttribute("major", major);
		
		return ViewPath.BRAND + "brandUpload.jsp";
	}
	
	@RequestMapping("/brand/brandinsert")
	public String brandInsert(HttpSession session, Model model, BrandProductVO productvo, BrandInfoVO infovo, BrandVO brandvo, HttpServletRequest request) {
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		String serial_num1 = request.getParameter("serial_num1");
		String serial_num2 = request.getParameter("serial_num2");
		String serial_num3 = request.getParameter("serial_num3");
		
		String pnum1 = request.getParameter("punm1");
		String pnum2 = request.getParameter("punm2");
		String pnum3 = request.getParameter("punm3");
		
		String serial_num = serial_num1 + serial_num2 + serial_num3;
		String pnum = pnum1 + pnum2 + pnum3;
		
		int idx = brandService.getIdx();
		
		brandvo.setSerial_num(serial_num);
		brandvo.setIdx(idx);

		int su = brandService.insert(brandvo);
		
		infovo.setPnum(pnum);
		infovo.setBrand_idx(idx);
		infovo.setMember_idx(login.getIdx());
		
		int su1 = brandService.insert(infovo);
		
		productvo.setBrand_idx(idx);
		
		int su2 = brandService.insert(productvo);
		
		String url = null;
		String msg = null;	
		
		if(su != 0){
			if(su1 != 0) {
				if(su2 != 0) {
					MemberVO mvo = memberService.selectOne(login.getIdx());
					
					mvo.setUserkind(1);
					login.setUserkind(1);
					
					memberService.update(mvo);
					
					msg = "판매자 신청 성공했습니다";
					url = "/project/community/mainpage";	
				}
			}
		}else{
			msg = "판매자 신청 실패했습니다";
			url = "/project/brand/brandupload";		
		}
		
		
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		return ViewPath.BRAND + "brandResult.jsp";
	}
	
	
}
