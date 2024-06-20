package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.Cart;

@Mapper
public interface CartMapper {
    @Insert("insert into cart(foodId, businessId, userId, quantity) " +
            "values(#{foodId},#{businessId},#{userId},#{quantity})")
    public void add(Cart cart);

    @Update("update cart set foodId=#{foodId},businessId=#{businessId},userId=#{userId},quantity=#{quantity} where cartId=#{cartId}")
    void update(Cart cart);
    @Delete("delete from cart where cartId=#{cartId}")
    void delete(int cartId);
}
