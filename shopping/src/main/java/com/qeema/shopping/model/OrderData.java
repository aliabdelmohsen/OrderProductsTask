package com.qeema.shopping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Immutable
@Subselect("SELECT OP.ID,OP.ORDER_ID,OP.PRODUCT_ID,OP.QUANTITY,P.NAME as PRODUCT_NAME,P.PRICE FROM ORDERS O \n" +
        "LEFT JOIN ORDER_PRODUCT OP\n" +
        "ON O.ID=OP.ORDER_ID \n" +
        "LEFT JOIN PRODUCTS P\n" +
        "ON OP.PRODUCT_ID =P.ID")
public class OrderData implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private Long orderId;
    private Long productId;
    private String productName;
    private int quantity;
    private BigDecimal price;


}
