package org.example.service.impl;

import org.example.mapper.CartMapper;
import org.example.mapper.FoodMapper;
import org.example.pojo.Cart;
import org.example.service.CartService;
import org.example.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;
    @Autowired
    FoodMapper foodMapper;

    @Override
    public boolean add(Cart cart) {
        //检测foodId与businessId
        int businessId = foodMapper.getBusiness(cart.getFoodId());
        if (businessId != cart.getBusinessId()) {
            return false;
        }

        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");
        cart.setUserId(userId);
        cartMapper.add(cart);
        return true;
    }

    @Override
    public void update(Cart cart) {
        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");
        cart.setUserId(userId);
        cartMapper.update(cart);
    }

    @Override
    public void delete(int cartId) {
        cartMapper.delete(cartId);
    }

    @Override
    public List<Cart> list(int businessId) {
        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");
        return cartMapper.list(businessId, userId);
    }
}
