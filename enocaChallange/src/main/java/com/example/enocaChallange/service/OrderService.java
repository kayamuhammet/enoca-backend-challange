package com.example.enocaChallange.service;

import com.example.enocaChallange.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {
    Order placeOrder(Long customerId, Long cartId);
    Order getOrderForCode(String orderCode);
    List<Order> getAllOrdersForCustomer(Long customerId);
}
