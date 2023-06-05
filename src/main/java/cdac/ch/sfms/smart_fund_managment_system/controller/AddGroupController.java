package cdac.ch.sfms.smart_fund_managment_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cdac.ch.sfms.smart_fund_managment_system.entity.AddGroup;
import cdac.ch.sfms.smart_fund_managment_system.entity.Group;
import cdac.ch.sfms.smart_fund_managment_system.service.AddGroupService;

@Controller
@RequestMapping("/group")
public class AddGroupController {

	@Autowired
    private AddGroupService addgroupService;
	
	 //to finde group names of that user
//	 http://localhost:8080/group
	 
//	 to add member to that group 
//		 http://localhost:8080/group/add
	 
	    @GetMapping("/add")
	    public String showAddGroupForm(Model model) {
	        model.addAttribute("group", new Group());
	        return "add-group";
	    }

	    @PostMapping("/add")
	    public String addGroup(@ModelAttribute("group") AddGroup group) {
	        addgroupService.addGroup(group.getUserId(), group.getGroupId(), group.getGroupName());
	        return "redirect:/group";
	    }

	    @GetMapping
	    public String showFindGroupNameForm(Model model) {
	        model.addAttribute("group", new Group());
	        return "find-group-name";
	    }

	    @PostMapping
	    public String findGroupName(@ModelAttribute("group") AddGroup group, Model model) {
	        String groupName = addgroupService.findGroupNameByUserIdAndGroupId(group.getUserId(), group.getGroupId());
	        model.addAttribute("groupName", groupName);
	        return "find-group-name";
	    }
}
