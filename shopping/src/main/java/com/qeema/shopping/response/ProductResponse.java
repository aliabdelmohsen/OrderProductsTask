package com.qeema.shopping.response;

import com.qeema.shopping.model.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductResponse {
    private List<Product> products;
}
