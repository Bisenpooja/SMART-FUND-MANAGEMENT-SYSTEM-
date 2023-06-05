package cdac.ch.sfms.smart_fund_managment_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cdac.ch.sfms.smart_fund_managment_system.entity.Transaction;
import cdac.ch.sfms.smart_fund_managment_system.repository.TransactionRepository;


@Controller
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/GoToTransaction")
    public String showForm(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "GoToTransaction";
    }

    @PostMapping("/saveTransaction")
    public String saveTransaction(@ModelAttribute("transaction") Transaction transaction, Model model) {
        try {
            transactionRepository.save(transaction);
           
            model.addAttribute("transaction", new Transaction()); // clear the form
            model.addAttribute("message", "card details added successfully.");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error: Could not register your card details.");
        }
        return "redirect:http://localhost:8002/pay/gatway";
    }

}