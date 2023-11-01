package com.qeema.shopping.repository;

import com.qeema.shopping.model.order.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDataRepository extends JpaRepository<OrderData, Long> {
}
