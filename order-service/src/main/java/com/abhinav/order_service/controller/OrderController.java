package com.abhinav.order_service.controller;

import com.abhinav.base_domains.dto.Order;
import com.abhinav.base_domains.dto.OrderEvent;
import com.abhinav.order_service.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public  String placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent("Order Is pending", "PENDING", order);
        orderProducer.sendMessage(orderEvent);
        return "Order placed successfully";

    }
}
