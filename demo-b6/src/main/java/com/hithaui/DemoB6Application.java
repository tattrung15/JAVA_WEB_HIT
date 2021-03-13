package com.hithaui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;

@SpringBootApplication
public class DemoB6Application {

	@Value("${cloudinary.url}")
	private String CLOUDINARY_URL;

	public static void main(String[] args) {
		SpringApplication.run(DemoB6Application.class, args);
	}

	@Bean
	public Cloudinary cloudinary() {
		Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
		return cloudinary;
	}
}
