package com.lx.vuecrud.service;

import com.lx.vuecrud.model.User;

import java.util.List;

/**
 * create by @author lixing on 2019/12/24 23:23
 */
public interface UserService {
    List<User> findAll();
    Integer update(User user);
    int addUser(User user);
    int del(Integer id);
}
