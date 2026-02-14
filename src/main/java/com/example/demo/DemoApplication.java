package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Only run this if Elasticsearch is enabled
    @Bean
    @ConditionalOnProperty(name = "elasticsearch.enabled", havingValue = "true")
    public CommandLineRunner run(ProductRepository productRepository) {
        return args -> {
            Product product = new Product("1", "Test Product", 9.99);
            productRepository.save(product);
            productRepository.findAll().forEach(System.out::println);
        };
    }
}
