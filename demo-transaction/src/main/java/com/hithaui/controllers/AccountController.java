package com.hithaui.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dao.Account;
import com.hithaui.dto.AccountDTO;
import com.hithaui.repositories.AccountRepository;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;

	@GetMapping
	public ResponseEntity<?> getAllAccounts(){
		List<Account> accounts = accountRepository.findAll();
		return ResponseEntity.status(200).body(accounts);
	}
	
	@PostMapping
	public ResponseEntity<?> createNewAccount(@RequestBody AccountDTO accountDTO){
		Account account = new Account(null, accountDTO.getUsername(), accountDTO.getMoney());
		Account newAccount = accountRepository.save(account);
		return ResponseEntity.status(201).body(newAccount);
	}
}
