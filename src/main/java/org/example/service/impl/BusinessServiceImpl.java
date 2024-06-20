package org.example.service.impl;

import org.example.mapper.BusinessMapper;
import org.example.pojo.Business;
import org.example.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private BusinessMapper businessMapper;
    @Override
    public List<Business> list() {
        return businessMapper.list();
    }

    @Override
    public List<Business> listByType(int orderTypeId) {
        return businessMapper.listByType(orderTypeId);
    }
}
