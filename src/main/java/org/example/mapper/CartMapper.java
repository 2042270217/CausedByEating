package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Cart;

import java.util.List;

@Mapper
public interface CartMapper {
    @Insert("insert into cart(foodId, businessId, userId, quantity) " +
            "values(#{foodId},#{businessId},#{userId},#{quantity})")
    void add(Cart cart);

    @Update("update cart set foodId=#{foodId},businessId=#{businessId},userId=#{userId},quantity=#{quantity} where cartId=#{cartId}")
    void update(Cart cart);

    @Delete("delete from cart where cartId=#{cartId}")
    void delete(int cartId);

    @Select("select * from cart where businessId=#{business} and userId=#{userId}")
    List<Cart> list(int businessId, String userId);

    @Select("select count(*)>0 from cart where businessId=#{businessId} and userId=#{userId} and foodId=#{foodId}")
    boolean shouldUpdate(int businessId, String userId, int foodId);

    @Select("select * from cart where businessId=#{businessId} and userId=#{userId} and foodId=#{foodId}")
    int getCartId(int businessId, String userId, int foodId);
}
