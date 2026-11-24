package com.growmighty.lectures.firstday.tangledmonolith.order.domain;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    // 주문 객체를 저장하고 그걸 반환
    Order save(Order order);
    // ID로 주문 하나 조회하는데 없을 수 없으니 옵셔녈 사용
    Optional<Order> findById(Long id);
    // 주문 목록 반환
    List<Order> findAll();
}
