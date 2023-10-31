package com.qeema.shopping.service;

import com.qeema.shopping.model.Product;
import com.qeema.shopping.repository.ProductRepository;
import com.qeema.shopping.request.ProductRequest;
import com.qeema.shopping.response.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void addProducts(final ProductRequest request) {
        log.info("Adding a list of Products {}", request);
        productRepository.saveAll(request.getProducts());
    }

    public ProductResponse getAllProducts() {
        final List<Product> products = productRepository.findAll();
        return ProductResponse.builder()
                .products(products)
                .build();
    }
}
