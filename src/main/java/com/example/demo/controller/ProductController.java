package com.example.demo.controller;

import com.example.demo.repository.ProductRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnBean(ProductRepository.class) // Only load if ES repo exists
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products/count")
    public String countProducts() {
        return "Product count: " + productRepository.count();
    }
}
