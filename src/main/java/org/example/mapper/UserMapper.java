package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.User;

@Mapper
public interface UserMapper {
    @Select("select * from user where userId=#{userId}")
    User findByUserId(String userId);

    @Insert("insert into user(userId, password,userName, userImg)" +
            " values (#{userId},#{password},#{userName},null)")
    void add(String userId, String password, String userName);

    @Update("update user set userName=#{userName},userSex=#{userSex} where userId=#{userId}")
    void update(String userName, int userSex, String userId);

    @Update("update user set userImg=#{userImg} where userId=#{userId}")
    void updateImg(String userImg, String userId);

    @Update("update user set password=#{password} where userId=#{userId}")
    void updatePassword(String password, String userId);

    @Select(("select password from user where userId=#{userId}"))
    String findPasswordByUserId(String userId);
}
