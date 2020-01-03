package com.peijiani.dao;
import com.peijiani.domain.User;
import java.util.List;

public interface IUserDao {
    User queryById(long id);
    List<User> queryAll();
    List<User> queryByUsername(String username);
    int addUser(User user);
    int updateUser(User user);
    int deleteUserById(long id);
}
