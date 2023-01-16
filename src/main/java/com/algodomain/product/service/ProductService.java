package com.algodomain.product.service;

import java.util.List;

import com.algodomain.product.entity.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(int id);

	Product addProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(int id);

	

}
