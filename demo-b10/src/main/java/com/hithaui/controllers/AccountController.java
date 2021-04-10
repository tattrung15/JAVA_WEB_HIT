package com.hithaui.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dto.AccountDTO;
import com.hithaui.models.Account;
import com.hithaui.repositories.AccountRepository;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping
	public ResponseEntity<?> getAllAccounts(){
		List<Account> accounts = accountRepository.findAll();
		return ResponseEntity.status(200).body(accounts);
	}
	
	@PostMapping
	public ResponseEntity<?> createNewAccount(@RequestBody AccountDTO accountDTO){
		Account account = new Account();
		account.setUsername(accountDTO.getUsername());
		account.setPassword(passwordEncoder.encode(accountDTO.getPassword()));
		account.setRole(accountDTO.getRole());
		Account newAccount = accountRepository.save(account);
		return ResponseEntity.status(201).body(newAccount);
	}
}
