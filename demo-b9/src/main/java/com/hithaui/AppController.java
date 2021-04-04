package com.hithaui;

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
@RequestMapping("/api/demo")
public class AppController {
	

	@GetMapping
	public ResponseEntity<?> getAllAccounts(){
		return ResponseEntity.status(200).body("Hello");
	}
	
}