package com.qeema.shopping.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.qeema.shopping.exception.BusinessException;
import com.qeema.shopping.model.Order;
import com.qeema.shopping.model.Product;
import com.qeema.shopping.repository.OrderDataRepository;
import com.qeema.shopping.repository.OrderRepository;
import com.qeema.shopping.repository.ProductRepository;
import com.qeema.shopping.request.OrderProductRequest;
import com.qeema.shopping.request.OrderRequest;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OrderService.class})
@ExtendWith(SpringExtension.class)
class OrderServiceTest {
    @MockBean
    private MessageSource messageSource;

    @MockBean
    private OrderDataRepository orderDataRepository;

    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @MockBean
    private ProductRepository productRepository;


    @Test
    void testCreateOrder() {
        Order order = new Order();
        order.setId(1L);
        order.setNumber("42");
        order.setOrderProducts(new ArrayList<>());
        when(orderRepository.save(Mockito.<Order>any())).thenReturn(order);
        orderService.createOrder(new OrderRequest("42", new ArrayList<>()));
        verify(orderRepository).save(Mockito.<Order>any());
    }

    @Test
    void testCreateOrder2() {
        Order order = new Order();
        order.setId(1L);
        order.setNumber("42");
        order.setOrderProducts(new ArrayList<>());
        when(orderRepository.save(Mockito.<Order>any())).thenReturn(order);

        Product product = new Product();
        product.setId(1L);
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(1L));
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        OrderProductRequest orderProductRequest = new OrderProductRequest();
        orderProductRequest.setProductId(1L);
        orderProductRequest.setQuantity(1);

        ArrayList<OrderProductRequest> orderProducts = new ArrayList<>();
        orderProducts.add(orderProductRequest);
        orderService.createOrder(new OrderRequest("42", orderProducts));
        verify(orderRepository).save(Mockito.<Order>any());
        verify(productRepository).findById(Mockito.<Long>any());
    }


    @Test
    void testGetAllOrder() {
        when(orderDataRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(orderService.getAllOrder().getOrders().isEmpty());
        verify(orderDataRepository).findAll();
    }


    @Test
    void testGetAllOrder2() {
        when(orderDataRepository.findAll()).thenThrow(new BusinessException("An error occurred"));
        assertThrows(BusinessException.class, () -> orderService.getAllOrder());
        verify(orderDataRepository).findAll();
    }
}

