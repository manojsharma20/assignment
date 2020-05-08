package com.assignment.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.org.persistence.model.Product;
import com.assignment.org.persistence.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/api/getproductdetails")
	@PreAuthorize("hasAuthority('PRIVILEGE_VIEW_PRODUCT')")
	public List<Product> findAllProduct() {
		return productRepository.findAll();
	}
}
