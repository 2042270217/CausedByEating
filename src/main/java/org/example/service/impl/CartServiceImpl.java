package org.example.service.impl;

import org.example.mapper.CartMapper;
import org.example.pojo.Cart;
import org.example.service.CartService;
import org.example.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;
    @Override
    public void add(Cart cart) {
        Map<String,Object> map = ThreadLocalUtils.get();
        String userId=(String) map.get("userId");
        cart.setUserId(userId);
        cartMapper.add(cart);
    }

    @Override
    public void update(Cart cart) {
        Map<String,Object> map = ThreadLocalUtils.get();
        String userId=(String) map.get("userId");
        cart.setUserId(userId);
        cartMapper.update(cart);
    }

    @Override
    public void delete(int cartId) {
        cartMapper.delete(cartId);
    }
}
