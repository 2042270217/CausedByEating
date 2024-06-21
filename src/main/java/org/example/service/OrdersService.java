package org.example.service;

import org.example.pojo.Orders;
import org.example.pojo.OrdersBean;

import java.util.List;

public interface OrdersService {
    OrdersBean add(int businessId, int daId);

    List<Orders> list();

    OrdersBean update(Orders order);
}
