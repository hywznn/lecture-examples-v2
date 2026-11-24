package com.growmighty.lectures.firstday.tangledmonolith.order.application.dto;

// 어떤 상품(id)를 몇개(quantity) 주문할지 서비스에 전달
public record OrderLine(Long productId, int quantity) {
}
