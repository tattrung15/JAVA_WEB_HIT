package com.hithaui.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dao.CategoryDAO;
import com.hithaui.dao.ProductDAO;
import com.hithaui.dto.CategoryDTO;
import com.hithaui.repositories.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE })
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping
	public ResponseEntity<?> getAllCategories() {
		List<CategoryDAO> list = categoryRepository.findAll();
		return ResponseEntity.status(200).body(list);
	}

	@PostMapping
	public ResponseEntity<?> createNewCategory(@RequestBody CategoryDTO categoryDTO) {
		CategoryDAO categoryDAO = new CategoryDAO();
		categoryDAO.setName(categoryDTO.getName());

		CategoryDAO newCategory = categoryRepository.save(categoryDAO);
		return ResponseEntity.status(201).body(newCategory);
	}

	@GetMapping("/{categoryId}/products")
	public ResponseEntity<?> getProductsByCategory(@PathVariable("categoryId") Integer categoryId) {
		Optional<CategoryDAO> optional = categoryRepository.findById(categoryId);
		CategoryDAO categoryDAO = optional.get();
		List<ProductDAO> listProducts = categoryDAO.getProducts();
		return ResponseEntity.status(200).body(listProducts);
	}
}
