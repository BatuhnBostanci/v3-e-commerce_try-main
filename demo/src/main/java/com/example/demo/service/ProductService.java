package com.example.demo.service;

import com.example.demo.entitiy.Category;
import com.example.demo.entitiy.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.request.ProductRequest;
import com.example.demo.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Kategoriye göre ürünleri getirir.
     */
    public List<Product> getProductsByCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Kategori bilgisi eksik.");
        }
        return productRepository.findByCategory(category);
    }

    /**
     * Yeni bir ürün kaydeder.
     */
    public Product saveProduct(Product product) {
        if (product == null || product.getCategory() == null) {
            throw new IllegalArgumentException("Ürün veya kategori bilgisi eksik.");
        }
        return productRepository.save(product);
    }

    /**
     * Ürünü id ile siler.
     */
    public void deleteProduct(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Geçersiz ürün ID.");
        }
        productRepository.deleteById(id);
    }
}
