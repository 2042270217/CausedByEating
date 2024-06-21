package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Orders;

import java.util.List;

@Mapper
public interface OrdersMapper {
    @Insert("insert into orders(userId, businessId, orderDate,orderTotal, daId,orderState) " +
            "values (#{userId},#{businessId},#{orderDate},#{orderTotal},#{daId},#{orderState} )")
    @Options(useGeneratedKeys = true, keyProperty = "orderId")
    Orders add(Orders orders);

    @Select("select * from orders where userId=#{userId}")
    List<Orders> list(String userId);
}
