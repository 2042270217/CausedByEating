package org.example.service;

import org.example.pojo.Cart;

import java.util.List;

public interface CartService {
    void add(Cart cart);

    void update(Cart cart);

    void delete(int cartId);

    List<Cart> list(int businessId);
}
