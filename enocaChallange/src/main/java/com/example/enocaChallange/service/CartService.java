package com.example.enocaChallange.service;

import com.example.enocaChallange.model.Cart;



public interface CartService {
    Cart getCartByCustomerId(Long customerId);
    Cart updateCart(Long cartId, Cart updatedCart);


    void emptyCart(Long cartId, Long productId, int quantity);

    void addProductToCart(Long cartId, Long productId, int quantity);
    void removeProductFromCart(Long cartId, Long cartItemId);
}
