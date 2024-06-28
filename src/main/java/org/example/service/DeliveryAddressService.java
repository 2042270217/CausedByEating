package org.example.service;

import org.example.pojo.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {
    void add(DeliveryAddress deliveryAddress);

    void update(DeliveryAddress deliveryAddress);

    List<DeliveryAddress> list();

    void delete(int daId);
}
