package com.paymybuddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.paymybuddy.model.BankAccount;
import com.paymybuddy.model.Connection;
import com.paymybuddy.model.CustomUserDetails;
import com.paymybuddy.model.User;
import com.paymybuddy.repository.UserRepository;
import com.paymybuddy.service.BankAccountService;
import com.paymybuddy.service.ConnectionService;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ConnectionService connectionService;

	@Autowired
	private BankAccountService bankAccountService;

	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);

		return "users_form";
	}

	@GetMapping("/profile")
	public String showProfile(Model model) {
		CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		User user = userRepo.findByEmail(principal.getUsername());
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		model.addAttribute("user", user);

		BankAccount bankAccount = bankAccountService.findByUser(user);
		model.addAttribute("bankAccount", bankAccount);
		return "profile_form";
		
	}

	@GetMapping("/connections")
	public String showConnection(Model model) {
		model.addAttribute("user", new User());

		CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		User user = userRepo.findByEmail(principal.getUsername());
		List<Connection> listConnections = connectionService.findConnections(user);
		model.addAttribute("listConnections", listConnections);

		return "connection_form";
	}

	@PostMapping("/process_add_connection")
	public String addConnection(User user) {
		User userToConnect = userRepo.findByEmail(user.getEmail());
		if (userToConnect != null)
			connectionService.createConnection(userToConnect);

		return "connection_form";

	}

}
