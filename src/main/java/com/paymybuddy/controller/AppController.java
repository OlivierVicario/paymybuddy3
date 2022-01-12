package com.paymybuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.paymybuddy.model.CustomUserDetails;
import com.paymybuddy.model.User;
import com.paymybuddy.repository.UserRepository;
import com.paymybuddy.service.UserService;

@Controller
public class AppController {
	CustomUserDetails principal;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserService userService;

	@GetMapping("")
	public String viewFirstPage() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "index";
		}

		principal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return "redirect:/transactions";
	}

	@GetMapping("/home")
	public String viewHomePage() {
		
		return "index";
	}
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());

		return "signup_form";
	}

	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userRepo.save(user);

		userService.initialize(user);

		return "register_success";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}

		principal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return "redirect:/transactions";
	}

}
