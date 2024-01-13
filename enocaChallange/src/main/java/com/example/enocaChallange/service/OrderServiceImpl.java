package com.example.enocaChallange.service;

import com.example.enocaChallange.model.Customer;
import com.example.enocaChallange.model.Order;
import com.example.enocaChallange.repository.CustomerRepository;
import com.example.enocaChallange.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
@Autowired
private CustomerRepository customerRepository;
    @Override
    public Order placeOrder(Long customerId, Long cartId) {
        return null;
    }

    @Override
    public Order getOrderForCode(String orderCode) {
        return orderRepository.findByOrderCode(orderCode).orElseThrow();
    }


    @Override
    public List<Order> getAllOrdersForCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        return orderRepository.findAllByCustomer(customer);
    }
}
