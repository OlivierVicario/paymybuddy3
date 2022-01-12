package com.paymybuddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.paymybuddy.model.Account;
import com.paymybuddy.model.Connection;
import com.paymybuddy.model.CustomUserDetails;
import com.paymybuddy.model.User;
import com.paymybuddy.repository.AccountRepository;
import com.paymybuddy.repository.UserRepository;
import com.paymybuddy.service.ConnectionService;

@Controller
public class AccountController {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private ConnectionService connectionService;
	
	@GetMapping("/transactions")
	public String listTransactions(Model model) {
		
		CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		User user = userRepo.findByEmail(principal.getUsername());
		
		List<Connection> listConnections = connectionService.findConnections(user);
		model.addAttribute("listConnections", listConnections);
		
		Account account = accountRepo.findByUser(user);
		
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);

		return "transaction_form";
	}
	
	@GetMapping("/account")
	public String showAccount(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);

		return "account_form";
	}	
}
