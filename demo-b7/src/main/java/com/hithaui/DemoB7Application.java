package com.hithaui;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@SpringBootApplication
public class DemoB7Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoB7Application.class, args);
		String username = "abcxyz";
		final String SECRET_KEY = "diohidaksjd";
//		String jwt = Jwts.builder()
//							.setSubject(username)
//							.setIssuedAt(new Date(System.currentTimeMillis()))
//							.setExpiration(new Date(System.currentTimeMillis() + 648000))
//							.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//							.compact();
//		System.out.println(jwt);
		
//		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYmN4eXoiLCJpYXQiOjE2MTYyNDI0NTgsImV4cCI6MTYxNjI0MzEwNn0.6CfJbJlmQ44bLlyhvedIztkZ29BNI4xn1jIdZ33lYVk";
//		String decode = Jwts.parser()
//								.setSigningKey(SECRET_KEY)
//								.parseClaimsJws(token)
//								.getBody()
//								.getSubject();
//		System.out.println(decode);
		
//		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String hash = passwordEncoder.encode("trung");
//		String hash1 = passwordEncoder.encode("trung");
//		System.out.println(hash);
//		System.out.println(hash1);
	}

}
