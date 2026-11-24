package com.growmighty.lectures.firstday.tangledmonolith.order.presentation;

import com.growmighty.lectures.firstday.tangledmonolith.order.application.dto.OrderConsistencyView;
import com.growmighty.lectures.firstday.tangledmonolith.order.application.dto.OrderResult;
import com.growmighty.lectures.firstday.tangledmonolith.order.application.OrderService;
import com.growmighty.lectures.firstday.tangledmonolith.order.application.dto.OrderLine;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderResult> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    public OrderResult placeOrder(@RequestBody OrderCreationRequest request) {
        // HTTP요청 - 컨트롤 - 컨트롤dto - 서비스dto 작업
        List<OrderLine> lines = new ArrayList<>();

        for (OrderItemRequest item : request.requests()) {
            OrderLine line = new OrderLine(item.productId(), item.quantity());
            lines.add(line);
        }
        return orderService.placeOrder(request.userId(), lines);
    }

    @GetMapping("/{orderId}/inspect")
    public OrderConsistencyView inspectOrder(@PathVariable Long orderId) {
        return orderService.inspectOrder(orderId);
    }

    @PatchMapping("/{orderId}/orderItems/{orderItemId}/price")
    public void changeOrderItemPrice(@PathVariable Long orderId, @PathVariable Long orderItemId, @RequestParam BigDecimal price) {
        orderService.changeItemPrice(orderId, orderItemId, price);
    }

    @PatchMapping("/{orderId}/orderItems/{orderItemId}/quantity")
    public void changeOrderItemQuantity(@PathVariable Long orderId, @PathVariable Long orderItemId, @RequestParam int quantity) {
        orderService.changeItemQuantity(orderId, orderItemId, quantity);
    }

    public record OrderCreationRequest(@NonNull Long userId, @NonNull List<OrderItemRequest> requests) {

    }

    public record OrderItemRequest(@NonNull Long productId, @NonNull Integer quantity) {

    }
}
