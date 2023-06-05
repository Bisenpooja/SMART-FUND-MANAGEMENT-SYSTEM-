package cdac.ch.sfms.smart_fund_managment_system.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cdac.ch.sfms.smart_fund_managment_system.entity.User;
import cdac.ch.sfms.smart_fund_managment_system.repository.UserRepository;
import cdac.ch.sfms.smart_fund_managment_system.service.UserService;



@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder encoder;

//	@GetMapping("/")
//	public String index() {
//		return "index";
//	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/createUser")
	public String createuser(@ModelAttribute User user, HttpSession session) {

		// System.out.println(user);

		boolean f = userService.checkEmail(user.getEmail());

		if (f) {
			session.setAttribute("msg", "Email Id alreday exists");
		}

		else {
			User userDtls = userService.createUser(user);
			if (userDtls != null) {
				session.setAttribute("msg", "Register Sucessfully");
			} else {
				session.setAttribute("msg", "Something wrong on server");
			}
		}

		return "redirect:/register";
	}
	
	@GetMapping("/about")
	public String aboutUs() {
		return "about_us";
	}

	@GetMapping("/contactus")
	public String contactUs() {
		return "contact_us";
	}


	@GetMapping("/details")
	public String goToDetails() {
		return "buttons_page";
	}

	@GetMapping("/loadForgotPassword")
	public String loadForgotPassword() {
		return "forgot_password";
	}
	
	@GetMapping("/loadResetPassword/{id}")
	public String loadResetPassword(@PathVariable Long id, Model m) {
		m.addAttribute("id",id);
		return "reset_password";
	}
	
	@PostMapping("/forgotPassword")
	public String forgotPassword(@RequestParam String email, String phonenumber, HttpSession session) {
		 User user=userRepo.findByEmail(email);
		 if(user!=null) {
			 
			 return "redirect:/loadResetPassword/"+user.getId();
		 }
		 else {
			 session.setAttribute("msg","Invalid email or mobile number");
			 return "forgot_password";
		 }
		
	}
	
	@PostMapping("/changePassword")
	public String resetPassword(@RequestParam String psw,@RequestParam Long id, HttpSession session) {
		
		User user=userRepo.findById(id).get();
		String encryptpsw=encoder.encode(psw);
		user.setPassword(encryptpsw);
		
		User updateUser=userRepo.save(user);
		
		if(updateUser!=null) {
			session.setAttribute("msg", "Password Sucessfully Changed");
		}
	
		
		return "redirect:/signin";
	}


}
