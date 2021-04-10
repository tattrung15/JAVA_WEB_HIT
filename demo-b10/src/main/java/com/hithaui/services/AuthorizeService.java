package com.hithaui.services;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service("authorizeService")
public class AuthorizeService {

	public Boolean checkAdmin(Authentication authentication, String role) {
		if(authentication.getAuthorities().toArray()[0].toString().compareTo(role) == 0) {
			return true;
		}
		return false;
	}
	
	public Boolean checkMember(Authentication authentication, String role) {
		if(authentication.getAuthorities().toArray()[0].toString().compareTo("ADMIN") == 0) {
			return true;
		}
		if(authentication.getAuthorities().toArray()[0].toString().compareTo(role) == 0) {
			return true;
		}
		return false;
	}
}
