package org.example.service.impl;

import org.example.mapper.DeliveryAddressMapper;
import org.example.pojo.DeliveryAddress;
import org.example.service.DeliveryAddressService;
import org.example.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    @Autowired
    DeliveryAddressMapper deliveryAddressMapper;

    @Override
    public void add(DeliveryAddress deliveryAddress) {
        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");
        deliveryAddress.setUserId(userId);
        deliveryAddressMapper.add(deliveryAddress);
    }

    @Override
    public boolean update(DeliveryAddress deliveryAddress) {
        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");
        boolean check = deliveryAddressMapper.check(deliveryAddress.getDaId(), userId);
        if(!check){
            return false;
        }
        deliveryAddressMapper.update(deliveryAddress);
        return true;
    }

    @Override
    public List<DeliveryAddress> list() {
        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");
        return deliveryAddressMapper.list(userId);
    }

    @Override
    public boolean delete(int daId) {
        Map<String, Object> map = ThreadLocalUtils.get();
        String userId = (String) map.get("userId");
        boolean check = deliveryAddressMapper.check(daId, userId);
        if(!check){
            return false;
        }
        deliveryAddressMapper.delete(daId);
        return true;
    }
}
