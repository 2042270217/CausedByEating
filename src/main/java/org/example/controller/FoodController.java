package org.example.controller;

import org.example.pojo.Food;
import org.example.pojo.Result;
import org.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
@Validated
public class FoodController {
    @Autowired
    FoodService foodService;
    @GetMapping
    public Result<List<Food>> list(int businessId) {
        var list = foodService.list(businessId);
        return Result.success(list);
    }
}
