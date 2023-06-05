package cdac.ch.sfms.smart_fund_managment_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cdac.ch.sfms.smart_fund_managment_system.entity.WinnerHistory;
import cdac.ch.sfms.smart_fund_managment_system.repository.WinnerHistoryRepository;

@Controller
public class DashboardController {

	 @Autowired
	  private WinnerHistoryRepository winnerHistoryRepository;
	  
	 @GetMapping("/allWinnerHistory")
	 public String getAllWinnerHistory(Model model) {
	   List<WinnerHistory> winnerHistoryList = winnerHistoryRepository.findAll();
	   model.addAttribute("winnerHistoryList", winnerHistoryList);
	   return "winnerHistory";
	 }

}
