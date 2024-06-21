package org.example.service.impl;

import org.example.mapper.CartMapper;
import org.example.mapper.OrdersMapper;
import org.example.pojo.Cart;
import org.example.pojo.Orders;
import org.example.pojo.OrdersBean;
import org.example.service.FoodService;
import org.example.service.OrdersService;
import org.example.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    CartMapper cartMapper;
    @Autowired
    FoodService foodService;

    @Override
    public OrdersBean add(int businessId, int daId) {
        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");

        List<Cart> cartList = cartMapper.list(businessId, userId);
        int total = 0;
        for (Cart cart : cartList) {
            int foodPrice = foodService.getFood(cart.getFoodId()).getFoodPrice();
            total += cart.getQuantity();
        }
        OrdersBean output = new OrdersBean();
        output.setOrderTotal(total);

        Orders orders = new Orders();
        orders.setOrderTotal(total);
        orders.setBusinessId(businessId);
        orders.setDaId(daId);
        orders.setUserId(userId);
        orders.setOrderState(0);
        orders.setOrderDate(String.valueOf(LocalDateTime.now()));

        ordersMapper.add(orders);

        output.setOrderId(orders.getOrderId());
        return output;
    }

    @Override
    public List<Orders> list() {
        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");
        return ordersMapper.list(userId);
    }
}
