package com.paymybuddy.service;


import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.model.Account;
import com.paymybuddy.model.BankAccount;
import com.paymybuddy.model.Operation;
import com.paymybuddy.model.Transaction;
import com.paymybuddy.model.User;
import com.paymybuddy.repository.AccountRepository;
import com.paymybuddy.repository.BankAccountRepository;

@Service
public class UserService {
@Autowired
AccountRepository accountRepository;
@Autowired
BankAccountRepository bankAccountRepository;
	public void initialize(User user) {
		
		Account account = new Account();
        account.setBalance(new BigDecimal(0));
        account.setOperations(new ArrayList<Operation>());
        account.setTransactions(new ArrayList<Transaction>());
        account.setUser(user);
        accountRepository.save(account);
        
        BankAccount bankaccount = new BankAccount();
        bankaccount.setAccount(account);
        bankaccount.setBankName("unknow");
        bankaccount.setBic("unknow");
        bankaccount.setIban("unknow");
        bankaccount.setTitle("unknow");
        
        bankAccountRepository.save(bankaccount);
	}
	public AccountRepository getAccountRepository() {
		return accountRepository;
	}
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	public BankAccountRepository getBankAccountRepository() {
		return bankAccountRepository;
	}
	public void setBankAccountRepository(BankAccountRepository bankAccountRepository) {
		this.bankAccountRepository = bankAccountRepository;
	}
	
	
}
