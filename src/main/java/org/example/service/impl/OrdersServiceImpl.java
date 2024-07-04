package org.example.service.impl;

import org.example.mapper.CartMapper;
import org.example.mapper.DeliveryAddressMapper;
import org.example.mapper.OrdersMapper;
import org.example.pojo.Cart;
import org.example.pojo.Orders;
import org.example.pojo.OrdersBean;
import org.example.pojo.Result;
import org.example.service.FoodService;
import org.example.service.OrdersService;
import org.example.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    CartMapper cartMapper;
    @Autowired
    FoodService foodService;
    @Autowired
    DeliveryAddressMapper deliveryAddressMapper;

    @Override
    public Result add(int businessId, int daId) {
        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");
        boolean check = deliveryAddressMapper.checkByUserId(daId,userId);
        if(!check){
            return Result.error(2);
        }
        List<Cart> cartList = cartMapper.list(businessId, userId);
        if(cartList == null || cartList.isEmpty()){
            return Result.error(3);
        }
        int total = 0;
        for (Cart cart : cartList) {
            int foodPrice = foodService.getFood(cart.getFoodId()).getFoodPrice();
            total += cart.getQuantity() * foodPrice;
        }
        OrdersBean output = new OrdersBean();
        output.setOrderTotal(total);

        Orders orders = new Orders();
        orders.setOrderTotal(total);
        orders.setBusinessId(businessId);
        orders.setDaId(daId);
        orders.setUserId(userId);
        orders.setOrderState(0);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orders.setOrderDate(formatter.format(date));
        ordersMapper.add(orders);

        output.setOrderId(orders.getOrderId());
        return Result.success(output);
    }

    @Override
    public List<Orders> list() {
        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");
        return ordersMapper.list(userId);
    }

    @Override
    public Result update(Orders order) {
        int businessId=ordersMapper.getBusinessIdByOrderId(order.getOrderId());
        int daId=ordersMapper.getDaIdByOrderId(order.getOrderId());
        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");

        OrdersBean output = new OrdersBean();

        List<Cart> cartList = cartMapper.list(businessId, userId);
        if(cartList == null || cartList.isEmpty()){
            //购物车不存在
            return Result.error(3);
        }
        int total = 0;
        for (Cart cart : cartList) {
            int foodPrice = foodService.getFood(cart.getFoodId()).getFoodPrice();
            total += cart.getQuantity()*foodPrice;
        }
        output.setOrderTotal(total);
        output.setOrderId(order.getOrderId());

        order.setOrderTotal(total);
        order.setUserId(userId);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setOrderDate(formatter.format(date));

        ordersMapper.update(order);

        return Result.success(output);
    }
}
