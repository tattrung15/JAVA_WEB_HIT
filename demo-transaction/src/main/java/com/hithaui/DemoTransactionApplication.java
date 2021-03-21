package com.hithaui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hithaui.dao.Account;
import com.hithaui.repositories.AccountRepository;

@SpringBootApplication
public class DemoTransactionApplication implements CommandLineRunner {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoTransactionApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if(args.length != 0) {
			if(args[0].compareToIgnoreCase("-createdb") == 0) {
				Account account1 = new Account(null, "abc", 10000);
				Account account2 = new Account(null, "xyz", 25000);
				accountRepository.save(account1);
				accountRepository.save(account2);
				System.out.println("created 2 rows");
			}
		}
	}
}
