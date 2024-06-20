package org.example.controller;

import org.example.pojo.OrdersBean;
import org.example.pojo.Result;
import org.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @PostMapping("/add")
    public Result<OrdersBean> add(int businessId, int daId){
        OrdersBean output = ordersService.add(businessId,daId);
        return Result.success(output);
    }
}
