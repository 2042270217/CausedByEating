package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.DeliveryAddress;

import java.util.List;

@Mapper
public interface DeliveryAddressMapper {
    @Insert("insert into deliveryaddress(contactName, contactSex, contactTel, address, userId)  " +
            "values (#{contactName},#{contactSex},#{contactTel},#{address},#{userId})")
    void add(DeliveryAddress deliveryAddress);

    @Update("update deliveryaddress set contactName=#{contactName},contactSex=#{contactSex},contactTel=#{contactTel},address=#{address} where daId=#{daId}")
    void update(DeliveryAddress deliveryAddress);

    @Select("select * from deliveryaddress where userId=#{userId}")
    List<DeliveryAddress> list(String userId);

    @Delete("delete from deliveryaddress where daId=#{daId}")
    void delete(int daId);
}
