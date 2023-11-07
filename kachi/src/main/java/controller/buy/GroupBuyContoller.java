package controller.buy;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kachi.five.bean.GroupBuyBean;
import com.kachi.five.bean.UserBean;
import com.kachi.five.service.GroupBuyService;
@Controller 
public class GroupBuyContoller {
	@Autowired
	private GroupBuyService groupBuyService;
	
	@PostMapping("/createGroupBuy")
	public ResponseEntity<String> createGroupBuy(@RequestBody Map<String, Object> payload, HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    UserBean user = (UserBean) session.getAttribute("loggedInUser");

	    if (user == null) {
	        return new ResponseEntity<>("사용자가 로그인하지 않았습니다.", HttpStatus.UNAUTHORIZED);
	    }

	    String creatorID = user.getUserID();
	    int postID = (Integer) payload.get("postID");

	    GroupBuyBean groupBuy = new GroupBuyBean();
	    groupBuy.setCreatorID(creatorID);
	    groupBuy.setPostID(postID);
	    groupBuy.setStatus("waiting");

	    // 데이터베이스에 공동구매 방 정보 저장
	    groupBuyService.createGroupBuy(groupBuy);

	    return new ResponseEntity<>("공동구매 방이 생성되었습니다.", HttpStatus.CREATED);
	}
	
	@PostMapping("/joinGroupBuy")
	public ResponseEntity<String> joinGroupBuy(@RequestParam("groupBuyId") int groupBuyId ,  HttpServletRequest request) {
	    
	    
	    HttpSession session = request.getSession();
	    UserBean user = (UserBean) session.getAttribute("loggedInUser");

	    if (user == null) {
	        return new ResponseEntity<>("사용자가 로그인하지 않았습니다.", HttpStatus.UNAUTHORIZED);
	    }
	    
	    GroupBuyBean groupBuy = groupBuyService.getGroupBuy(groupBuyId);
	    
	    if (groupBuy != null && groupBuy.getStatus().equals("waiting")) {
	        groupBuy.setStatus("completed");
	        groupBuy.setParticipantID(user.getUserID());
	        groupBuyService.updateGroupBuy(groupBuy);
	        
	        return new ResponseEntity<>("공동구매에 참여하였습니다.", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("공동구매방을 찾을 수 없거나 이미 참여가 완료되었습니다.", HttpStatus.BAD_REQUEST);
	    }
	}
}
