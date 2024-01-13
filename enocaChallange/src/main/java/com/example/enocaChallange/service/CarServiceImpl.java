package com.example.enocaChallange.service;

import com.example.enocaChallange.model.Cart;
import com.example.enocaChallange.model.CartItem;
import com.example.enocaChallange.model.Product;
import com.example.enocaChallange.repository.CartRepository;
import com.example.enocaChallange.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Cart getCartByCustomerId(Long customerId) {
        return cartRepository.findByCustomerId(customerId);
    }

    @Override
    public Cart updateCart(Long cartId, Cart updatedCart) {
        Cart existingCart = cartRepository.findById(cartId).orElseThrow();
        return cartRepository.save(existingCart);
    }




    @Override
    public void emptyCart(Long cartId, Long productId, int quantity) {
        Cart cartToEmpty = cartRepository.findById(cartId).orElseThrow();
        cartToEmpty.getCartItems().clear();
        cartRepository.save(cartToEmpty);
    }

    @Override
    public void addProductToCart(Long cartId, Long productId, int quantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();


        if (product.getStock() >= quantity) {
            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);



            cart.getCartItems().add(cartItem);
            cartRepository.save(cart);
        }
    }

    @Override
    public void removeProductFromCart(Long cartId, Long cartItemId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        CartItem cartItemToRemove = cart.getCartItems()
                .stream()
                .filter(cartItem -> cartItem.getId().equals(cartItemId))
                .findFirst()
                .orElseThrow();


        cart.getCartItems().remove(cartItemToRemove);



        cartRepository.save(cart);
    }
}
