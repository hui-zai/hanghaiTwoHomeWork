package com.peijiani.service;

import com.peijiani.domain.User;

import java.util.List;

public interface IUserService {
    User getById(long userId);
    List<User> getList();
    List<User> getByUsername(String username);
    int addUser(User user);
    int updateUser(User user);
    int deleteUserById(long id);
}
