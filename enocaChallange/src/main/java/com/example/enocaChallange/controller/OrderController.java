package com.example.enocaChallange.controller;

import com.example.enocaChallange.model.Order;
import com.example.enocaChallange.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/place-order/{customerId}/{cartId}")
    public Order placeOrder(@PathVariable Long customerId, @PathVariable Long cartId) {
        return orderService.placeOrder(customerId, cartId);
    }

    @GetMapping("/{orderCode}")
    public Order getOrderForCode(@PathVariable String orderCode) {
        return orderService.getOrderForCode(orderCode);
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getAllOrdersForCustomer(@PathVariable Long customerId) {
        return orderService.getAllOrdersForCustomer(customerId);
    }
}
