package org.example.service.impl;

import org.example.mapper.FoodMapper;
import org.example.pojo.Food;
import org.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodMapper foodMapper;

    @Override
    public List<Food> list(int businessId) {
        return foodMapper.list(businessId);
    }
}
