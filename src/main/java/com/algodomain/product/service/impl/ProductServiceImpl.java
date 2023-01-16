package com.algodomain.product.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.algodomain.product.entity.Product;
import com.algodomain.product.repository.ProductRepository;
import com.algodomain.product.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private Product product;

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}

	public BigDecimal getDiscount(Product product) {
		BigDecimal discount = new BigDecimal(0);
		if (product.getCategory().equals("Electronics")) {
			discount = product.getBasePrice().multiply(new BigDecimal(0.15));
		} else if (product.getCategory().equals("Home Appliances")) {
			discount = product.getBasePrice().multiply(new BigDecimal(0.22));
		} else if (product.getCategory().equals("Clothing")) {
			discount = product.getBasePrice().multiply(new BigDecimal(0.40));
		} else if (product.getCategory().equals("Furniture")) {
			discount = product.getBasePrice().multiply(new BigDecimal(0.10));
		}
		return discount;
	}

	public BigDecimal getGst(Product product) {
		BigDecimal gst = new BigDecimal(0);
		if (product.getCategory().equals("Electronics")) {
			gst = product.getBasePrice().multiply(new BigDecimal(0.18));
		} else if (product.getCategory().equals("Home Appliances")) {
			gst = product.getBasePrice().multiply(new BigDecimal(0.24));
		} else if (product.getCategory().equals("Clothing")) {
			gst = product.getBasePrice().multiply(new BigDecimal(0.12));
		} else if (product.getCategory().equals("Furniture")) {
			gst = product.getBasePrice().multiply(new BigDecimal(0.18));
		}
		return gst;
	}

	public BigDecimal getDeliveryCharge(Product product) {
		BigDecimal deliveryCharge = new BigDecimal(0);
		if (product.getCategory().equals("Electronics")) {
			deliveryCharge = new BigDecimal(350);
		} else if (product.getCategory().equals("Home Appliances")) {
			deliveryCharge = new BigDecimal(800);
		} else if (product.getCategory().equals("Clothing")) {
			deliveryCharge = new BigDecimal(0);
		} else if (product.getCategory().equals("Furniture")) {
			deliveryCharge = new BigDecimal(300);
		}
		return deliveryCharge;
	}

	public BigDecimal getFinalPrice(Product product) {
		return product.getBasePrice().subtract(getDiscount(product)).add(getGst(product)).add(getDeliveryCharge(product));
	}

}