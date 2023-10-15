package controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	@RequestMapping("/admin/adminform")
	public String adminform() {
		return "admin/adminform";
	}

	    
	@RequestMapping("/admin/sidebar")
	public String sidebar() {
		return "admin/sidebar";
	}
}
