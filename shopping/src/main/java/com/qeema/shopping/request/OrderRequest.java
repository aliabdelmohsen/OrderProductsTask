package com.qeema.shopping.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    @NotNull(message = "orderNumber is required")
    private final String orderNumber;
    @Valid
    private final List<OrderProductRequest> orderProducts;
}
