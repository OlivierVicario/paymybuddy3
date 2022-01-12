package com.paymybuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymybuddy.model.Account;
import com.paymybuddy.model.User;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
    public Account findByUser(User user);
    
}
