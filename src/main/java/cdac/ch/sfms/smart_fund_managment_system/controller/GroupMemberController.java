package cdac.ch.sfms.smart_fund_managment_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cdac.ch.sfms.smart_fund_managment_system.service.GroupMemberService;

@Controller
public class GroupMemberController {

	@Autowired
    private GroupMemberService groupMemberService;

    @GetMapping("/group/{userId}/{groupId}")
    public String getGroupName(@PathVariable Long userId, @PathVariable Long groupId) {
        String groupName = groupMemberService.getGroupName(userId, groupId);
        return groupName != null ? groupName : "No group found for user " + userId + " and group " + groupId;
    }
    
    @GetMapping("/group/{userId}")
    public String getGroupNamesByUserId(@PathVariable Long userId,Model model) {
       
    	List<String> groupNames=groupMemberService.getGroupNamesByUserId(userId);
    	 model.addAttribute("groupNames", groupNames);
    	
    	 return "user/home";
    	 
//    	 return groupMemberService.getGroupNamesByUserId(userId);
        
    }
    
    
}
