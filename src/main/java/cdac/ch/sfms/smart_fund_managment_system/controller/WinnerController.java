package cdac.ch.sfms.smart_fund_managment_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cdac.ch.sfms.smart_fund_managment_system.service.WinnerService;

@Controller
@RequestMapping("/winners")
public class WinnerController {

	  @Autowired
	  private WinnerService winnerService;
	 
	   
	    
	  @GetMapping("/form")
	  public String showWinnerForm() {
	      return "winner-form";
	  }

	  @PostMapping("/winners")
	  public String saveWinners(@RequestParam("groupId") long groupId, @RequestParam("installmentNumber") long installmentNumber, Model model) {
	      Long winnerId = winnerService.saveWinners(groupId, installmentNumber);
	      if (winnerId != null) {
	          String message = "Winner is user with ID " + winnerId;
	          model.addAttribute("message", message);
	      } else {
	          String message = "!!";
	          model.addAttribute("message", message);
	      }
	      return "winner-form";
	  }
	    

}
