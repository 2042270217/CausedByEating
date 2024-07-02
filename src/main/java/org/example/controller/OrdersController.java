package org.example.controller;

import org.example.pojo.Orders;
import org.example.pojo.OrdersBean;
import org.example.pojo.Result;
import org.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/add")
    public Result add(int businessId, int daId) {
        var output = ordersService.add(businessId, daId);
        if (output.getCode() == 3) {
            return Result.error("购物车不存在");
        } else if (output.getCode() == 2) {
            return Result.error("送货地址不存在");
        }
        return Result.success(output.getData());
    }

    @GetMapping("/list")
    public Result<List<Orders>> list() {
        List<Orders> list = ordersService.list();
        return Result.success(list);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated Orders order) {
        var output = ordersService.update(order);
        if (output.getCode() == 2) {
            return Result.error("送货地址不存在");
        } else if (output.getCode() == 3) {
            return Result.error("购物车不存在");
        } else if (output.getCode() == 4) {
            return Result.error("商家异常变更");
        }
        return Result.success(output.getData());
    }
}
