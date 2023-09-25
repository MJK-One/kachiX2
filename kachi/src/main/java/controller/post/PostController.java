package controller.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {
	@RequestMapping("/postform")
	public String postform() {
			return "postform";
	}
	@RequestMapping("/post/create")
	public String postcreate() {
			return "post/create";
	}
	
}
