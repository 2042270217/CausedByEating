package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Orders;

import java.util.List;

@Mapper
public interface OrdersMapper {
    @Insert("insert into orders(userId, businessId, orderDate,orderTotal, daId,orderState) " +
            "values (#{userId},#{businessId},#{orderDate},#{orderTotal},#{daId},#{orderState} )")
    @Options(useGeneratedKeys = true, keyProperty = "orderId")
    int add(Orders orders);

    @Select("select * from orders where userId=#{userId}")
    List<Orders> list(String userId);

    @Update("update orders set userId=#{userId},businessId=#{businessId},orderDate=#{orderDate},orderTotal=#{orderTotal},daId=#{daId}, orderState=#{orderState} where orderId=#{orderId}")
    void update(Orders orders);

}
