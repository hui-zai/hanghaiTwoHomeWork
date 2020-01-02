package com.lin.service;

import com.lin.pojo.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User addUser(User user);

    User saveUser(User user);

    void deleteUser(Integer id);
}
