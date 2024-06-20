package org.example.service;

import org.example.pojo.Cart;

public interface CartService {
    void add(Cart cart);

    void update(Cart cart);

    void delete(int cartId);
}
