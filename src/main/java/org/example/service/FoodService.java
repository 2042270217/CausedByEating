package org.example.service;

import org.example.pojo.Food;

import java.util.List;

public interface FoodService {
    List<Food> list(int businessId);
}
