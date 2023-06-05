package cdac.ch.sfms.smart_fund_managment_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cdac.ch.sfms.smart_fund_managment_system.entity.Installment;
import cdac.ch.sfms.smart_fund_managment_system.repository.InstallmentRepository;



@Controller
public class InstallmentController {

	@Autowired
	private InstallmentRepository installmentRepository;

	
//	http://localhost:8080/
	@GetMapping("/verify")
	public String showForm(Model model) {
		model.addAttribute("installment", new Installment());
		return "installmentForm";
	}


	@PostMapping("/save")
	public String saveInstallment(@ModelAttribute("installment") Installment installment, Model model) {

	    Installment existingInstallment = installmentRepository.findByGroupIdAndUserIdAndInstallmentNumber(
	            installment.getGroupId(),
	            installment.getUserId(),
	            installment.getInstallmentNumber()
	    );
	    
	    if (existingInstallment != null) {
	        model.addAttribute("errorMessage", "Validation failed: Installment already exists.");
	    } else {
	        try {
	        	 Installment savedInstallment=installmentRepository.save(installment);
	        	 savedInstallment.setStatus("paid");
	        	 installmentRepository.save(savedInstallment); 
	            model.addAttribute("message", "You can now pay.");
	            model.addAttribute("installment", new Installment()); // clear the form
	            model.addAttribute("showNextButton", true);
	        } catch (Exception e) {
	            model.addAttribute("errorMessage", "Error: Could not create installment.");
	        }
	    }

	    return "installmentForm";
	}

	

	
	 @GetMapping("/next")
	    public String showNextPage() {
	        return "GoToTransaction";
	    }
	
//	 @GetMapping("/gateway")
//	    public String showTransactionPage() {
//	        return "transaction";
//	    }
//	 
	 
	 
	 
	 
	 
}
