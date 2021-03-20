package com.hithaui.utils;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtils {
	private final String SECRET_KEY = "lfkjqwlkfjqwl";
	
	public String extractUsername(String jwt) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt).getBody().getSubject();
	}
	
	public Date extractExpiration(String jwt) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt).getBody().getExpiration();
	}
	
	public Boolean isTokenExpired(String jwt) {
		return extractExpiration(jwt).before(new Date());
	}
	
	public Boolean validateToken(String jwt, UserDetails userDetails) {
		String username = extractUsername(jwt);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwt));
	}
	
	public String generateToken(UserDetails userDetails) {
		return Jwts.builder()
					.setSubject(userDetails.getUsername())
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 30000))
					.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
					.compact();
	}
}
