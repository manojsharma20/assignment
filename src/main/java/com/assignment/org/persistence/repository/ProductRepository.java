package com.assignment.org.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.org.persistence.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
