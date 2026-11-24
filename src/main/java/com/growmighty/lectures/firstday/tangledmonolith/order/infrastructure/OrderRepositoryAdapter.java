package com.growmighty.lectures.firstday.tangledmonolith.order.infrastructure;

import com.growmighty.lectures.firstday.tangledmonolith.order.domain.Order;
import com.growmighty.lectures.firstday.tangledmonolith.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
// final 필드인 jpdRepository를 전달받는 생성자를 만들어서 스프링이 그 생성자로 JPA저장소로 넣게
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository jpaRepository;

    @Override
    public Order save(Order order){
        return jpaRepository.save(order);
    }

    @Override
    public Optional<Order> findById(Long id){
        return jpaRepository.findById(id);
    }
    @Override
    public List<Order> findAll(){
        return jpaRepository.findAll();
    }
}
