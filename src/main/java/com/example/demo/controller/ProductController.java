package com.example.demo.controller;

import com.example.demo.repository.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnBean(ProductRepository.class) // Only load if ES repo exists
@Tag(name = "Product API", description = "APIs for Products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products/count")
    @Operation(summary = "Get total number of products")
    public String countProducts() {
        return "Product count: " + productRepository.count();
    }
}
