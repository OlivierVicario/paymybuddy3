package com.paymybuddy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.paymybuddy.model.Connection;
import com.paymybuddy.model.CustomUserDetails;
import com.paymybuddy.model.User;
import com.paymybuddy.repository.ConnectionRepository;
import com.paymybuddy.repository.UserRepository;

@Service
public class ConnectionService {
	@Autowired
	ConnectionRepository connectionRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public void createConnection(User recipient) {
		CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		User principalUser = userRepo.findByEmail(principal.getUsername());
		
		Connection connection = new Connection();
		connection.setUserFromId(principalUser.getUserId());
		connection.setUserToId(recipient.getUserId());
		connection.setName(recipient.getFirstName()+" "+recipient.getLastName());
		connectionRepo.save(connection);		
	}
	
	public ArrayList<Connection> findConnections(User user) {
		ArrayList<Connection> connections = connectionRepo.findByUserFromId(user.getUserId());
		return connections;
		
	}
}
