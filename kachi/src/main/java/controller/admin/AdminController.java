package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kachi.five.bean.UserBean;
import com.kachi.five.service.PurchaseService;

@Controller
public class AdminController {
	@Autowired
	private PurchaseService purcjaseService;
	
	@RequestMapping("/admin/adminform")
	public String adminform(HttpServletRequest request) {
		
		  HttpSession session = request.getSession(); UserBean user = (UserBean)
		  session.getAttribute("loggedInUser"); if(user == null) return ""; 
		 
		  return "admin/adminform";
	}

	    
	@RequestMapping("/member/purchase_list")
	public String purchase_list(Model model) {
		  try {
	            model.addAttribute("purchases",purcjaseService.getPurchaseCompletedGroupBuy());
	        } catch (Exception e) {
	            e.printStackTrace();
	            
	        }
		return "member/purchase_list";
	}
	@RequestMapping("/admin/updateDeliveryStatus")
	public String updateDeliveryStatus( @RequestParam("purchaseId") int purchaseId) {
		 System.out.println(purchaseId);
		purcjaseService.updateDeliveryStatus(purchaseId);
		return "redirect:/";
	}
}

