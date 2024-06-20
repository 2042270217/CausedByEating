package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Business;

import java.util.List;

@Mapper
public interface BusinessMapper {
    @Select("select * from business")
    List<Business> list();

    @Select("select * from business where orderTypeId=#{orderTypeId}")
    List<Business> listByType(int orderTypeId);
}
