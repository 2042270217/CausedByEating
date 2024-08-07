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

    @Update("update orders set orderDate=#{orderDate},orderTotal=#{orderTotal}, orderState=#{orderState} where orderId=#{orderId}")
    void update(Orders orders);

    @Select("select businessId from orders where orderId=#{orderId}")
    int getBusinessIdByOrderId(int orderId);
    @Select("select daId from orders where orderId=#{orderId}")
    int getDaIdByOrderId(int orderId);
}
