package org.example.service;

import org.example.pojo.Food;

import java.util.List;

public interface FoodService {
    //根据商家获得食物列表
    List<Food> list(int businessId);
    //根据食物Id获得食物
    Food getFood(int foodId);
}
