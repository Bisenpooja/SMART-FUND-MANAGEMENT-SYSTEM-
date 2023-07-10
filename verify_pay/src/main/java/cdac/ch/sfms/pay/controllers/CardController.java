package cdac.ch.sfms.pay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cdac.ch.sfms.pay.dto.CardTransactionDTO;
import cdac.ch.sfms.pay.dto.TransactionCompletedDTO;
import cdac.ch.sfms.pay.services.TransactionService;

@Controller
@RequestMapping("/pay")
public class CardController 
{
	@Autowired
	TransactionService transactionService;
	

	
//	 http://localhost:8080/pay/
		 
	@GetMapping("/gatway")
    public String showTransactionForm(Model model) {
        model.addAttribute("transactionDTO", new CardTransactionDTO());
        return "transaction";
    }
	

	 @GetMapping("/transactionResult")
	    public String getTransactionResult(Model model) {
	        // create a new TransactionCompletedDTO object and add it to the model
	        TransactionCompletedDTO response = new TransactionCompletedDTO();
	        model.addAttribute("response", response);
	        // return the name of the view to render
	        return "result";
	 }
	 
	@GetMapping("/transactionDetails/{txId}")
	public TransactionCompletedDTO getTransaction(@PathVariable("txId") int txId)
	{
		return transactionService.getTransactionDetails(txId);
	}

	
	 @PostMapping("/transact")
	    public String transact(@ModelAttribute("transaction") CardTransactionDTO dto, Model model) {
	        TransactionCompletedDTO response = transactionService.transact(dto);
	        model.addAttribute("response", response);
	        return "result";
	    }
}
