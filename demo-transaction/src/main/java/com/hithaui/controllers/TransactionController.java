package com.hithaui.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dao.Account;
import com.hithaui.repositories.AccountRepository;

@RestController
@RequestMapping("/api/transactions")
@Transactional
public class TransactionController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping
	public void createTransaction() {
		Account account1 = accountRepository.findById(1).get();
		Account account2 = accountRepository.findById(2).get();
		
		Integer amount = 11000;
		
		account2.setMoney(account2.getMoney() + amount);
		accountRepository.save(account2);
		account1.setMoney(account1.getMoney() - amount);
		accountRepository.save(account1);
	}
}
