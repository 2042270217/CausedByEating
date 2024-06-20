package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Food;

import java.util.List;

@Mapper
public interface FoodMapper {
    @Select("select * from food where businessId =#{businessId}")
    List<Food> list(int businessId);
    @Select("select * from food where foodId =#{foodId}")
    Food getFood(int foodId);
}
