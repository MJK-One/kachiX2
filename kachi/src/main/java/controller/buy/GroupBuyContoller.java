package controller.buy;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp; 
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
	
	@PostMapping(value = "/createGroupBuy", produces = "application/json; charset=UTF-8")
	public ResponseEntity<?> createGroupBuy(@RequestBody Map<String, Object> payload, HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    UserBean user = (UserBean) session.getAttribute("loggedInUser");

	    if (user == null) {
	        // 로그인하지 않은 사용자에 대한 처리. 예를 들어, 오류 메시지를 반환하거나 로그인 페이지로 리디렉션.
	        return new ResponseEntity<>("로그인이 필요합니다.", HttpStatus.UNAUTHORIZED);
	    }

	    String creatorID = user.getUserID();
	    String postID = (String) payload.get("postID");
	    int postIDInt = Integer.parseInt(postID);
	    GroupBuyBean groupBuy = new GroupBuyBean();
	    groupBuy.setCreatorID(creatorID);
	    groupBuy.setPostID(postIDInt);
	    groupBuy.setStatus("waiting");

	    // 데이터베이스에 공동구매 방 정보 저장 후, 새로 생성된 id를 반환받습니다.
	    GroupBuyBean createdGroupBuy = groupBuyService.createGroupBuy(groupBuy);
	    

	    return new ResponseEntity<>(createdGroupBuy, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/joinGroupBuy", produces = "text/plain; charset=UTF-8")
	public ResponseEntity<String> joinGroupBuy(@RequestParam("groupBuyId") int groupBuyId ,  HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    UserBean user = (UserBean) session.getAttribute("loggedInUser");

	    GroupBuyBean groupBuy = groupBuyService.getGroupBuy(groupBuyId);
	    
	    if (groupBuy != null && groupBuy.getStatus().equals("waiting") && user !=null) {
	        groupBuy.setStatus("completed");
	        groupBuy.setParticipantID(user.getUserID());
	        groupBuy.setCompletionTime(new Timestamp(System.currentTimeMillis())); // 참여한 시간을 기록합니다.

	        int updatedRows = groupBuyService.updateGroupBuy(groupBuy);
	        
	        if(updatedRows > 0) {
	            return new ResponseEntity<>("공동구매에 참여하였습니다.", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("공동구매방을 찾을 수 없거나 이미 참여가 완료되었습니다.", HttpStatus.BAD_REQUEST);
	        }
	    } else {
	        return new ResponseEntity<>("공동구매방을 찾을 수 없거나 이미 참여가 완료되었습니다.", HttpStatus.BAD_REQUEST);
	    }
	}
	//로그인 상태 확인
	@RequestMapping("/checkLoginStatus")
	public ResponseEntity<String> checkLoginStatus(HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    UserBean user = (UserBean) session.getAttribute("loggedInUser");

	    if (user == null) {
	        return new ResponseEntity<>("notLoggedIn", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("loggedIn", HttpStatus.OK);
	    }
	}
}
