package controller.post;	

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kachi.five.bean.CategoryBean;
import com.kachi.five.bean.PostBean;
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
	public String createPost_Submit(@ModelAttribute PostBean post) {
        postService.createPost(post);
        System.out.println(post.getTitle());
        return "redirect:/"; 
    }
}
