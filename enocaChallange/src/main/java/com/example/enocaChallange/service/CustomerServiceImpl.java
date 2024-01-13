package com.example.enocaChallange.service;

import com.example.enocaChallange.model.Customer;
import com.example.enocaChallange.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {

        return customerRepository.save(customer);
    }
}
