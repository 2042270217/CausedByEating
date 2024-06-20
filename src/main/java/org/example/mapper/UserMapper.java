package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;

@Mapper
public interface UserMapper {
    @Select("select * from user where userId=#{userId}")
    User findByUserId(String userId);

    @Insert("insert into user(userId, password,userSex, delTag)" +
            " values (#{userId},#{password},#{1},#{1})")
    void add(String userId, String password);
}
