package com.hithaui.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dto.ProductDTO;
import com.hithaui.dto.ProductDetail;
import com.hithaui.dto.ProductImageDTO;

@RestController
public class AppController {

	@GetMapping("/")
	public ResponseEntity<?> getAllProducts() {
		ProductImageDTO productImageDTO1 = new ProductImageDTO("https://google1.com");
		ProductImageDTO productImageDTO2 = new ProductImageDTO("https://google2.com");
		ProductImageDTO productImageDTO3 = new ProductImageDTO("https://google3.com");

		ProductDTO productDTO1 = new ProductDTO("a", 1);
		ProductDTO productDTO2 = new ProductDTO("b", 2);
		ProductDTO productDTO3 = new ProductDTO("c", 3);

		ProductDetail productDetail1 = new ProductDetail(productDTO1, productImageDTO1);
		ProductDetail productDetail2 = new ProductDetail(productDTO2, productImageDTO2);
		ProductDetail productDetail3 = new ProductDetail(productDTO3, productImageDTO3);

		List<ProductDetail> productDetails = Arrays.asList(productDetail1, productDetail2, productDetail3);
		return ResponseEntity.status(200).body(productDetails);
	}
}
