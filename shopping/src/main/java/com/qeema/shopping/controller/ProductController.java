package com.qeema.shopping.controller;

import com.qeema.shopping.request.ProductRequest;
import com.qeema.shopping.response.ProductResponse;
import com.qeema.shopping.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody @Valid final ProductRequest request) {
        productService.addProducts(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Products added Successfully");
    }

    @GetMapping
    public ResponseEntity<ProductResponse> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
