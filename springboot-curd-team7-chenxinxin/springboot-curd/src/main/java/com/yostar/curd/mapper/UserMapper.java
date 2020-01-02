package com.yostar.curd.mapper;

import com.yostar.curd.pojo.User;
import com.yostar.curd.provider.SQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User findUserById(Integer id);

    @Select("select * from user")
    List<User> findUsers();

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user(username, email, sex, province, hobby) values(#{username}, #{email}, #{sex}, #{province}, #{hobby})")
    int addUser(User user);

    @UpdateProvider(type = SQLProvider.class, method = "updateUser")
    int editUserById(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUserById(Integer id);
}
