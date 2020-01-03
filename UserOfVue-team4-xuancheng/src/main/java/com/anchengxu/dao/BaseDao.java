package com.anchengxu.dao;
import com.anchengxu.entity.User;
import java.util.List;

public interface BaseDao {
    User queryById(long id);
    List<User> queryAll();
    List<User> queryByUsername(String username);
    int addUser(User user);
    int updateUser(User user);
    int deleteUserById(long id);
}
