package com.qeema.shopping.request;

import com.qeema.shopping.model.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ProductRequest {
    @Valid
    private List<Product> products;
}
