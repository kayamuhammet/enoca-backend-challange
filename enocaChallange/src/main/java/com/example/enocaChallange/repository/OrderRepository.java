package com.example.enocaChallange.repository;

import com.example.enocaChallange.model.Customer;
import com.example.enocaChallange.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByOrderCode(String orderCode);

    List<Order> findAllByCustomer(Customer customer);
}
