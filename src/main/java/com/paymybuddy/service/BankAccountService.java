package com.paymybuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.model.Account;
import com.paymybuddy.model.BankAccount;
import com.paymybuddy.model.User;
import com.paymybuddy.repository.AccountRepository;
import com.paymybuddy.repository.BankAccountRepository;

@Service
public class BankAccountService {
@Autowired
BankAccountRepository bankAccountRepo;

@Autowired
AccountRepository accountRepo;

public BankAccount findByUser(User user) {
	Account account = accountRepo.findByUser(user);
	BankAccount bankAccount =bankAccountRepo.findByAccount(account);
	return bankAccount;
	
}
}
