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
public class ShoppingController {
	
	private ShoppingService shoppingService;
	private CategoryService categoryService;

	
	public ShoppingController(
			ShoppingService shoppingService,
			CategoryService categoryService
			) {
		this.shoppingService = shoppingService;
		this.categoryService = categoryService;
	}
	@RequestMapping("/shopping/mainpage")
	public String mainPage() {
		
		return ViewPath.SHOPPING + "mainPage.jsp";
	}
	
	@RequestMapping("/shopping/categorypage")
	public String categoryPage(HttpServletRequest request) {
		
		List<MajorCategoryVO> major = categoryService.selectName("쇼핑");
		List<ProductVO> product = shoppingService.selectList();
		
		for(MajorCategoryVO vo : major) {
			List<MiddleCategoryVO> middle = categoryService.mi_selectName(vo.getIdx());
			vo.setMivo(middle);
			for(MiddleCategoryVO mivo : middle) {
				List<SmallCategoryVO> small = categoryService.sm_selectName(mivo.getIdx());
				mivo.setSmvo(small);
			}
		}
		for(ProductVO vo : product) {
			DecimalFormat df = new DecimalFormat("###,###");
			
			String price = df.format(vo.getPrice());
			String sale = df.format(vo.getSale());
			
			vo.setA(sale);
			int h = (vo.getPrice() - vo.getSale()) * 100 / vo.getPrice();
			vo.setH(h);
			
		}
		
		for(ProductVO vo : product) {
			System.out.println(vo.getIdx());
		}
		
		request.setAttribute("major", major);
		request.setAttribute("product", product);
		
		return ViewPath.SHOPPING + "categoryPage.jsp";
	}
	
	@RequestMapping("/product/productdetail")
	public String productDetail(HttpServletRequest request, int idx) {
		
		ProductVO vo = shoppingService.product_selectOne(idx);

		DecimalFormat df = new DecimalFormat("###,###");
		
		String price = df.format(vo.getPrice());
		String sale = df.format(vo.getSale());
		String delivery = df.format(vo.getDelivery());
		int h = (vo.getPrice() - vo.getSale()) * 100 / vo.getPrice();
		
		String content = vo.getInfo();
		
		vo.setInfo(content.replaceAll("<br>", "\r\n"));
		
		request.setAttribute("price", price);
		request.setAttribute("sale", sale);
		request.setAttribute("delivery", delivery);
		request.setAttribute("vo", vo);
		request.setAttribute("h", h);
		
		
		return ViewPath.PRODUCT + "productDetail.jsp";
	}
	
	
}
