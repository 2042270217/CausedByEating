package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Orders;

import java.time.LocalDateTime;

@Mapper
public interface OrdersMapper {
    @Insert("insert into orders(userId, businessId, orderDate,orderTotal, daId,orderState) " +
            "values (#{userId},#{businessId},#{orderDate},#{orderTotal},#{daId},#{orderState} )")
    @Options(useGeneratedKeys = true, keyProperty = "pid")
    Orders add(Orders orders);
}
