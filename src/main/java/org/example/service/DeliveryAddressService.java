package org.example.service;

import org.example.pojo.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {
    void add(DeliveryAddress deliveryAddress);

    boolean update(DeliveryAddress deliveryAddress);

    List<DeliveryAddress> list();

    boolean delete(int daId);
}
