package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Test API", description = "Dummy API for Swagger testing")
public class TestController {

    @GetMapping("/test")
    @Operation(summary = "Test endpoint")
    public String test() {
        return "Swagger is working!";
    }
}
