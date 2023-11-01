package com.qeema.shopping.model;

import com.qeema.shopping.model.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "order_product")
public class OrderProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "order_product-sequence",
            sequenceName = "order_product-sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "order-sequence")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Min(value = 1, message = "quantity should greater than 0")
    private int quantity;


}
