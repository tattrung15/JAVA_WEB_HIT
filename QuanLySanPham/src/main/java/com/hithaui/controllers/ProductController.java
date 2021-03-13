package com.hithaui.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dao.CategoryDAO;
import com.hithaui.dao.ProductDAO;
import com.hithaui.dto.ProductDTO;
import com.hithaui.repositories.CategoryRepository;
import com.hithaui.repositories.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoRyRepository;

	@GetMapping
	public ResponseEntity<?> getAllProduct() {
		List<ProductDAO> list = productRepository.findAll();
		return ResponseEntity.status(200).body(list);
	}

//	private String title;
//	private String imageLink;
//	private String description;
//	private String author;
//	private Integer categoryId;
//	private Integer price;
//	private Integer numberOfPage;

	@PostMapping
	public ResponseEntity<?> createNewProduct(@RequestBody ProductDTO productDTO) {

		Optional<CategoryDAO> categoryDAO = categoRyRepository.findById(productDTO.getCategoryId());

//		if(!categoryDAO.isPresent()) {
//			throw new NotFoundException
//		}

		ProductDAO productDAO = new ProductDAO();
		productDAO.setTitle(productDTO.getTitle());
		productDAO.setImageLink(productDTO.getImageLink());
		productDAO.setDescription(productDTO.getDescription());
		productDAO.setAuthor(productDTO.getAuthor());
		productDAO.setPrice(productDTO.getPrice());
		productDAO.setNumberOfPage(productDTO.getNumberOfPage());
		productDAO.setCategoryDAO(categoryDAO.get());

		ProductDAO newProduct = productRepository.save(productDAO);
		return ResponseEntity.status(201).body(newProduct);
	}

}
