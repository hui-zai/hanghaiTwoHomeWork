package com.anchengxu.service;

import com.anchengxu.entity.User;

import java.util.List;

public interface BaseService {
    User getById(long userId);
    List<User> getList();
    List<User> getByUsername(String username);
    int addUser(User user);
    int updateUser(User user);
    int deleteUserById(long id);
    List<User> deleteUserByIdReturnList(long id);
}
