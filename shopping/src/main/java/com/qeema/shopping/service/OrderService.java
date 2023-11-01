package com.qeema.shopping.service;

import com.qeema.shopping.exception.BusinessException;
import com.qeema.shopping.model.order.Order;
import com.qeema.shopping.model.order.OrderData;
import com.qeema.shopping.model.OrderProduct;
import com.qeema.shopping.model.Product;
import com.qeema.shopping.repository.OrderDataRepository;
import com.qeema.shopping.repository.OrderRepository;
import com.qeema.shopping.repository.ProductRepository;
import com.qeema.shopping.request.OrderProductRequest;
import com.qeema.shopping.request.OrderRequest;
import com.qeema.shopping.response.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDataRepository orderDataRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MessageSource messageSource;

    public void createOrder(final OrderRequest request) {
        validateDuplicateProductInOrder(request.getOrderProducts());

        final Order order = Order.builder()
                .number(request.getOrderNumber()).build();
        log.info("Adding a list of Products into single order {}", request);
        final List<OrderProduct> orderProducts = constructOrderProducts(request.getOrderProducts(), order);

        order.setOrderProducts(orderProducts);

        orderRepository.save(order);
    }


    public OrderResponse getAllOrder() {
        final List<OrderData> orders = orderDataRepository.findAll();
        return OrderResponse.builder().orders(orders).build();
    }

    private List<OrderProduct> constructOrderProducts(final List<OrderProductRequest> orderProductsRequest, final Order order) {
        final List<OrderProduct> orderProducts = new ArrayList<>();

        for (OrderProductRequest orderProductRequest : orderProductsRequest) {
            final Product product = productRepository.findById(orderProductRequest.getProductId())
                    .orElseThrow(() -> new BusinessException(messageSource.getMessage("PRODUCT.NOT_FOUND", null, Locale.US)));

            final OrderProduct orderProduct = OrderProduct.builder()
                    .product(product)
                    .order(order)
                    .quantity(orderProductRequest.getQuantity())
                    .build();
            orderProducts.add(orderProduct);
        }

        return orderProducts;
    }


    private void validateDuplicateProductInOrder(final List<OrderProductRequest> orderProducts) {
        final Set<Long> orderProductIdSet = orderProducts
                .stream()
                .map(OrderProductRequest::getProductId).collect(Collectors.toSet());
        if (orderProducts.size() != orderProductIdSet.size()) {
            throw new BusinessException(messageSource.getMessage("Order.PRODUCT_UNIQUENESS", null, Locale.US));
        }
    }
}
