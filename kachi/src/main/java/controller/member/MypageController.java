package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kachi.five.bean.AddressBean;
import com.kachi.five.bean.UserBean;
import com.kachi.five.service.UserService;

@Controller
public class MypageController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/member/mypage")
	public String mypageJsp(Model model) {
			return "/member/mypage";
	}
	
	
	@RequestMapping(value="/member/updateNickname", method=RequestMethod.POST)
	public String updateNickName(@RequestParam("newNickname") String newNickName, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("loggedInUser");
		
		if (user != null) {
			user.setNickname(newNickName);
			userService.updateNickname(user);
	        
		    session.setAttribute("loggedInUser", user);
		    
		    return "redirect:/";
		} else {
		    return "error/unauthorized";
		}
	}
	
	@RequestMapping(value="/member/updateAdress", method=RequestMethod.POST)
	public String updateAddress(@RequestParam("postcode") String postcode,
		    @RequestParam("streetAddress") String streetAddress,
		    @RequestParam("detailAddress1") String detailAddress1,
		    @RequestParam("detailAddress2") String detailAddress2, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("loggedInUser");
		
		 if (user != null) {
		        // AddressBean 객체 생성 및 값 설정
		        AddressBean address = new AddressBean();
		        address.setUserId(user.getUserID());
		        address.setPostCode(postcode);
		        address.setStreetAddress(streetAddress);
		        address.setDetailAddress(detailAddress1 + " " + detailAddress2);

		        // 주소 정보 데이터베이스에 저장
		        userService.insertAddress(address);

		        // 성공적으로 주소가 업데이트되었음을 사용자에게 보여줄 수 있는 로직 추가해야함

			    return "redirect:/";
			} else {
			    return "error/unauthorized";
			}

	}
}