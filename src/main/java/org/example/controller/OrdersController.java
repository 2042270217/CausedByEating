package org.example.controller;

import org.example.pojo.Orders;
import org.example.pojo.OrdersBean;
import org.example.pojo.Result;
import org.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/add")
    public Result<OrdersBean> add(int businessId, int daId) {
        OrdersBean output = ordersService.add(businessId, daId);
        return Result.success(output);
    }

    @GetMapping("/list")
    public Result<List<Orders>> list() {
        List<Orders> list = ordersService.list();
        return Result.success(list);
    }
}
