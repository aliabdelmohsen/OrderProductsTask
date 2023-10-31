package com.qeema.shopping.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.qeema.shopping.model.Product;
import com.qeema.shopping.repository.ProductRepository;
import com.qeema.shopping.request.ProductRequest;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductService.class})
@ExtendWith(SpringExtension.class)
class ProductServiceTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;


    @Test
    void testAddProducts() {
        ArrayList<Product> productList = new ArrayList<>();
        when(productRepository.saveAll(Mockito.<Iterable<Product>>any())).thenReturn(productList);

        ProductRequest request = new ProductRequest();
        request.setProducts(new ArrayList<>());
        productService.addProducts(request);
        verify(productRepository).saveAll(Mockito.<Iterable<Product>>any());
        assertEquals(productList, request.getProducts());
    }


    @Test
    void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(productService.getAllProducts().getProducts().isEmpty());
        verify(productRepository).findAll();
    }
}

