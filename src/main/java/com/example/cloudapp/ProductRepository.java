package com.example.cloudapp;

import org.springframework.data.jpa.repository.JpaRepository;

// This repository provides the basic database operations for products.
public interface ProductRepository extends JpaRepository<Product, Long> 
{
	
}
