package com.qeema.shopping.controller;

import com.qeema.shopping.request.OrderRequest;
import com.qeema.shopping.response.OrderResponse;
import com.qeema.shopping.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody @Valid final OrderRequest request){
        orderService.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Order placed Successfully");
    }

    @GetMapping
    public ResponseEntity<OrderResponse> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrder());
    }
}
