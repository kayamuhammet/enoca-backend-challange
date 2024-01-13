package com.example.enocaChallange.service;

import com.example.enocaChallange.model.Product;
import com.example.enocaChallange.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product updateProduct) {

        Product existingProduct = getProductById(productId);


        existingProduct.setName(updateProduct.getName());
        existingProduct.setPrice(updateProduct.getPrice());
        existingProduct.setStock(updateProduct.getStock());


        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product productToDelete = getProductById(productId);
        productRepository.delete(productToDelete);
    }
}
