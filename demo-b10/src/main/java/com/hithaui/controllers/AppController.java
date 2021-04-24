package com.hithaui.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Transactional
public class AppController {

	@GetMapping("/admin")
	@PreAuthorize("@authorizeService.checkAdmin(authentication,'ADMIN')")
	public ResponseEntity<?> getAllAccounts(){
		return ResponseEntity.status(200).body("Admin");
	}
	
	@GetMapping("/member")
	@PreAuthorize("@authorizeService.checkMember(authentication,'MEMBER')")
	public ResponseEntity<?> getAllAccounts1(){
		return ResponseEntity.status(200).body("Member");
	}
	
	@GetMapping("/admin/{userId}")
	@PreAuthorize("@authorizeService.checkAuth(authentication,'MEMBER', #userId)")
	public ResponseEntity<?> getAllAccounts2(@PathVariable("userId") Long userId){
		return ResponseEntity.status(200).body("abc");
	}
}