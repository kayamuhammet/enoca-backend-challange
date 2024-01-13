package com.example.enocaChallange.controller;

import com.example.enocaChallange.model.Cart;
import com.example.enocaChallange.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    private CartService cartService;


    @GetMapping("/customer/{customerId}")
    public Cart getCartByCustomerId(@PathVariable Long customerId) {
        return cartService.getCartByCustomerId(customerId);
    }

    @PutMapping("/{cartId}")
    public Cart updateCart(@PathVariable Long cartId, @RequestBody Cart updatedCart) {
        return cartService.updateCart(cartId, updatedCart);
    }

    @DeleteMapping("/{cartId}/empty")
    public ResponseEntity<Void> emptyCart(@PathVariable Long cartId, Long productId, int quantity) {
        cartService.emptyCart(cartId, productId, quantity);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{cartId}/add-product/{productId}")
    public ResponseEntity<Void> addProductToCart(
            @PathVariable Long cartId, @PathVariable Long productId, @RequestParam int quantity) {
        cartService.addProductToCart(cartId, productId, quantity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cartId}/remove-product/{cartItemId}")
    public ResponseEntity<Void> removeProductFromCart(@PathVariable Long cartId, @PathVariable Long cartItemId) {
        cartService.removeProductFromCart(cartId, cartItemId);
        return ResponseEntity.ok().build();
    }
}
