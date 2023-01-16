package com.algodomain.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algodomain.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
