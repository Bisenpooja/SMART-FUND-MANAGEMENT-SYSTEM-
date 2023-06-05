package cdac.ch.sfms.smart_fund_managment_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cdac.ch.sfms.smart_fund_managment_system.entity.Group;
import cdac.ch.sfms.smart_fund_managment_system.service.GroupService;


@Controller
public class GroupController {
	 
    @Autowired
    private GroupService groupService;
    
//    http://localhost/
    @GetMapping("/")
    public String showGroups(Model model) {
        List<Group> groups = groupService.getAllGroups();
        model.addAttribute("groups", groups);
        return "index";
    }
    
    @GetMapping("/create-group")
    public String showCreateGroupForm(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);
        return "create-group";
    }
    
    @PostMapping("/create-group")
    public String createGroup(@ModelAttribute("group") Group group) {
        groupService.saveGroup(group);
        return "redirect:/";
    }
}
