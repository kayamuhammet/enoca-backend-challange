package com.example.enocaChallange.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cart")
public class Cart extends BaseEntity{
    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
