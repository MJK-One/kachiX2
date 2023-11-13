package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kachi.five.bean.UserBean;
import com.kachi.five.service.UserService;

@Controller
public class UserController {
	 @Autowired
	    private UserService userService;

	    @GetMapping("member/user_list")
	    public String userList(Model model) {
	        try {
	            model.addAttribute("users", userService.getAllUsers());
	        } catch (Exception e) {
	            e.printStackTrace();
	            
	        }
	        
	        return "member/user_list"; 
	    }
	    @PostMapping("/member/updatePermission")
		public String updateWritePermission(@RequestParam("userID") String userID,
											@RequestParam("writePermission") int writePermission) {
			UserBean user = new UserBean();
			user.setUserID(userID);
			user.setWritePermission(writePermission);

	        try {
	            userService.updateUserPermission(user);
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Error updating permission: " + e.getMessage());
	            
	            // 에러 페이지나 메시지 출력 등의 에러 처리 코드 추가
	            
	            throw new RuntimeException(e); 
	        }
			
			return "redirect:/"; // 여기서 "/"는 업데이트 후 리다이렉트 할 경로입니다.
		}
}
