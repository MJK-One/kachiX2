package controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	@RequestMapping(value = "/admin/adminform", method = RequestMethod.GET)
	public String adminForm(HttpSession session) {
	    Boolean writePermission = (Boolean) session.getAttribute("writePermission");
	    if (writePermission == null || !writePermission) {
	        return "redirect:/";  // 혹은 "redirect:/error/unauthorized" 등으로 변경 가능
	    }
	    else return "admin/adminform";
	}

	    
	@RequestMapping("/admin/sidebar")
	public String sidebar() {
		return "admin/sidebar";
	}
}
