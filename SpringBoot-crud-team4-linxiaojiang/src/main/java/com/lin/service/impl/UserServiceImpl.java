package com.lin.service.impl;

import com.lin.dao.UserDao;
import com.lin.pojo.User;
import com.lin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;


    @Override
    public List<User> getAllUsers() {

        List<User> all = dao.findAll();

        return all;
    }

    @Override
    public User addUser(User user) {


        User save = dao.save(user);

        return user;
    }

    @Override
    public User saveUser(User user) {

        User save = dao.save(user);

        return user;
    }

    @Override
    public void deleteUser(Integer id) {

        dao.deleteById(id);

    }

}
