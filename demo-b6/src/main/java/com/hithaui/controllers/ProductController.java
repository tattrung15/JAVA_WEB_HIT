package com.hithaui.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hithaui.dao.Product;
import com.hithaui.repositories.ProductRepository;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE })
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private Cloudinary cloudinary;

	@GetMapping
	public ResponseEntity<?> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return ResponseEntity.status(200).body(products);
	}

	@PostMapping
	public ResponseEntity<?> createNewProduct(@RequestParam("title") String title,
			@RequestParam("image") MultipartFile image, @RequestParam("description") String description)
			throws IOException {
		System.out.println(image.getOriginalFilename());

		Map<?, ?> map = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());

//		Xoa anh
//		cloudinary.uploader().destroy("asdasd", ObjectUtils.emptyMap());
		System.out.println(map.get("secure_url"));
//		Code
		return null;
	}
}
