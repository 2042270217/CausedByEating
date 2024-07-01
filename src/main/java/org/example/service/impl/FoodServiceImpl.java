package org.example.service.impl;

import org.example.mapper.BusinessMapper;
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
    @Autowired
    BusinessMapper businessMapper;

    @Override
    public List<Food> list(int businessId) {
        boolean check = businessMapper.findBusiness(businessId);
        if (check) {
            return foodMapper.list(businessId);
        } else {
            return null;
        }
    }

    @Override
    public Food getFood(int foodId) {
        return foodMapper.getFood(foodId);
    }

}
