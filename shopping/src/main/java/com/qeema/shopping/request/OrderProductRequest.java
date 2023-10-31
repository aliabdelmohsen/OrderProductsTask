package com.qeema.shopping.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderProductRequest {
    @NotNull(message = "productId is required")
    private Long productId;
    @Min(value = 1, message = "quantity should greater than 0")
    private int quantity;
}

