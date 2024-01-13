package com.example.enocaChallange.service;

import com.example.enocaChallange.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long productId);
    Product createProduct(Product product);
    Product updateProduct(Long productId, Product updateProduct);
    void deleteProduct(Long productId);
}
