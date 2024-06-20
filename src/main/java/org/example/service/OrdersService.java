package org.example.service;

import org.example.pojo.OrdersBean;
import org.example.pojo.Result;

public interface OrdersService {
    OrdersBean add(int businessId, int daId);
}
