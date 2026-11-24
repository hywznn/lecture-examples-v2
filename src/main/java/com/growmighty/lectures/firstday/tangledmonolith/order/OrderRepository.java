package com.growmighty.lectures.firstday.tangledmonolith.order;

import com.growmighty.lectures.firstday.tangledmonolith.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
