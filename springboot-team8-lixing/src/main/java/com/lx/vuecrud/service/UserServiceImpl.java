package com.lx.vuecrud.service;

import com.lx.vuecrud.mapper.UserMapper;
import com.lx.vuecrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by @author lixing on 2019/12/24 23:25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public Integer update(User user) {
        int mark = userMapper.updateById(user);
        return mark;
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int del(Integer id) {
        return userMapper.deleteById(id);
    }
}
