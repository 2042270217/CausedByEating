package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;

@Mapper
public interface UserMapper {
    @Select("select * from user where userId=#{userId}")
    User findByUserId(String userId);

    @Insert("insert into user(userId, password,userName, userImg)" +
            " values (#{userId},#{password},#{userName},null)")
    void add(String userId, String password, String userName);
}
