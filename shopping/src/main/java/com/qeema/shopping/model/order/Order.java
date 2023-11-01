package com.qeema.shopping.model.order;

import com.qeema.shopping.model.OrderProduct;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "order-sequence",
            sequenceName = "order-sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "order-sequence")
    private Long id;
    @NotNull
    private String number;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
    @Valid
    private List<OrderProduct> orderProducts;
}
