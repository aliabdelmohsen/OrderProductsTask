package com.qeema.shopping.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "product-sequence",
            sequenceName = "product-sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product-sequence")
    private Long id;
    @NotBlank(message = "name should be notBlank")
    private String name;
    @Min(value = 1, message = "Price should greater than 0")
    private BigDecimal price;

}
