package controller.shopping;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
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
import service.member.BrandService;
import service.member.MemberService;
import service.shopping.CategoryService;
import service.shopping.ShoppingService;
import vo.brand.BrandVO;
import vo.majorcategory.MajorCategoryVO;
import vo.member.MemberVO;
import vo.middlecategory.MiddleCategoryVO;
import vo.product.ProductVO;
import vo.productcategory.ProductcategoryVO;
import vo.smallcategory.SmallCategoryVO;

@Controller
public class ProductUploadController {
	
	private ShoppingService shoppingService;
	private CategoryService categoryService;
	private BrandService brandService;
	
	@Autowired
	private ServletContext application;
	
	public ProductUploadController(
			ShoppingService shoppingService,
			BrandService brandService,
			CategoryService categoryService
			) {
		this.shoppingService = shoppingService;
		this.categoryService = categoryService;
		this.brandService = brandService;
	}
	
	// 상품등록 페이지
	@RequestMapping("/product/upload")
	public String upload(HttpServletRequest request, HttpSession session) {
		MemberVO login = (MemberVO)session.getAttribute("login");
		List<MajorCategoryVO> major = categoryService.selectName("쇼핑");
		BrandVO brand = brandService.brand_selectOne(login.getIdx());
		
		for(MajorCategoryVO vo : major) {
			List<MiddleCategoryVO> middle = categoryService.mi_selectName(vo.getIdx());
			vo.setMivo(middle);
			for(MiddleCategoryVO mivo : middle) {
				List<SmallCategoryVO> small = categoryService.sm_selectName(mivo.getIdx());
				mivo.setSmvo(small);
			}
		}
		
		request.setAttribute("major", major);
		request.setAttribute("brand", brand);
		
		return ViewPath.PRODUCT + "uploadProduct.jsp";
	}
	
	// 상품등록
	@RequestMapping("/product/insert")
	public String productInsert(HttpServletRequest request, HttpSession session, ProductVO vo, Model model, int brand_idx, int major_idx, int middle_idx, int small_idx) {
		
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		if(login == null) {
			return "redirect:/member/loginform";
		}
		
		int idx = shoppingService.product_getIdx();
		
		vo.setIdx(idx);
		vo.setBrand_idx(brand_idx);
		vo.setStatus(0);
		
		String savePath = application.getRealPath("/resources/product/" + vo.getIdx());

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
		
		int su = shoppingService.insert(vo);
		System.out.println(idx);
		
		ProductVO vovo = shoppingService.product_selectOne(idx);
		
		ProductcategoryVO pc = new ProductcategoryVO();
		
		pc.setProduct_idx(idx);
		
		int su2 = 0;
		

		pc.setSmall_idx(small_idx);
		pc.setMiddle_idx(middle_idx);
		pc.setMajor_idx(major_idx);
		su2 = shoppingService.insert(pc);
			

		String url = null;
		String msg = null;
		
		if(su != 0 && su2 != 0){
			msg = "상품등록 성공했습니다";
			url = "/project/community/mainpage";		
		}else{
			msg = "상품등록 실패했습니다";
			url = "projectproduct/upload";		
		}
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		return ViewPath.PRODUCT + "uploadResult.jsp";
	}
	
	
}
