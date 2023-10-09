package controller.post;	

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kachi.five.bean.CategoryBean;
import com.kachi.five.bean.PostBean;
import com.kachi.five.bean.UserBean;
import com.kachi.five.service.CategoryService;
import com.kachi.five.service.PostService;

@Controller
public class PostController {
	@Autowired 
	private PostService postService;
	@Autowired  
	  private CategoryService categoryService;
	
	@RequestMapping("/postform")
	public String postform() {
			return "postform";
	}
	@RequestMapping("/post/create")
	public String createPost(Model model) {
		 List<CategoryBean> categories = categoryService.getAllCategories();
		 model.addAttribute("categories", categories);
		 
			return "/post/create";
	}
	
	@RequestMapping(value = "/post/create_submit", method = RequestMethod.POST)
	public String createPost_Submit(@ModelAttribute PostBean post, HttpServletRequest request) {
		HttpSession session = request.getSession();
	    UserBean user = (UserBean) session.getAttribute("loggedInUser");

	    if (user != null) {
	        post.setWriterId(user.getUserID());
	        post.setSaleStatus(true);
	      
	        postService.createPost(post);
	        
	        return "redirect:/";
	    } else {
	        // 사용자가 로그인하지 않은 상태에서 글을 작성하려는 경우 처리
	       
	        return "redirect:/login";  
	    }
	}
}