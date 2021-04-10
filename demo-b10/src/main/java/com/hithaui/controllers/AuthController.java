package com.hithaui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dto.AccountDTO;
import com.hithaui.dto.AuthenticationResponse;
import com.hithaui.services.MyUserDetailsService;
import com.hithaui.utils.JwtUtil;

@RestController
@RequestMapping("/auth/login")
public class AuthController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping
	public ResponseEntity<?> login(@RequestBody AccountDTO accountDTO) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(accountDTO.getUsername(), accountDTO.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password");
		}
		UserDetails userDetails = myUserDetailsService.loadUserByUsername(accountDTO.getUsername());
		String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.status(200).body(new AuthenticationResponse(jwt));
	}
}
