package cdac.ch.sfms.smart_fund_managment_system.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cdac.ch.sfms.smart_fund_managment_system.entity.Installment;
import cdac.ch.sfms.smart_fund_managment_system.entity.InstallmentId;
import cdac.ch.sfms.smart_fund_managment_system.service.InstallmentService;

@Controller
public class ShowInstallmentStatusController {
	@Autowired
    private InstallmentService installmentService;
   
//    http://localhost:8080/installment-users-form
    
    @GetMapping("/installment-users-form")
    public String showInstallmentUsersForm(Model model) {
        model.addAttribute("installmentId", new InstallmentId());
        return "installment_users-form";
    }

    @PostMapping("/installment-users")
    public String getUsersByGroupIdAndInstallmentNumber(
            @ModelAttribute InstallmentId installmentFormData,
            Model model) {
        
        Long groupId = installmentFormData.getGroupId();
        Long installmentNumber = installmentFormData.getInstallmentNumber();
         List<Installment> installments = installmentService.getInstallmentsByGroupIdAndInstallmentNumber(groupId, installmentNumber);
        
        // Extract user IDs and statuses from installments
        List<Long> userIds = new ArrayList<>();
        List<String> statuses = new ArrayList<>();
        for (Installment installment : installments) {
            userIds.add(installment.getUserId());
            statuses.add(installment.getStatus());
        }
        
        model.addAttribute("userIds", userIds);
        model.addAttribute("statuses", statuses);
        
        return "user_ids";
    }

}
