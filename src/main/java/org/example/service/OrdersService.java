package org.example.service;

import org.example.pojo.Orders;
import org.example.pojo.OrdersBean;
import org.example.pojo.Result;

import java.util.List;

public interface OrdersService {
    Result add(int businessId, int daId);

    List<Orders> list();

    Result update(Orders order);
}
