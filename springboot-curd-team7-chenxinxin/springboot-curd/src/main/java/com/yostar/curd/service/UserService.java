package com.yostar.curd.service;

import com.yostar.curd.mapper.UserMapper;
import com.yostar.curd.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(Integer id) {
        User user = userMapper.findUserById(id);
        return formatSex2Text(user);
    }

    public List<User> findUsers() {
        List<User> users = userMapper.findUsers();
        users = users.stream().map(user -> formatSex2Text(user)
        ).collect(Collectors.toList());
        return users;
    }

    public int addUser(User user) {
        return userMapper.addUser(formatSex2Num(user));
    }

    public int updateUserById(User user) {
        return userMapper.editUserById(formatSex2Num(user));
    }

    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    private User formatSex2Num(User user) {
        if (user.getSex().equals("男")) {
            user.setSex("1");
        } else if (user.getSex().equals("女")) {
            user.setSex("0");
        } else {
            user.setSex("2");
        }
        return user;
    }

    private User formatSex2Text(User user) {
        if (user.getSex().equals("1")) {
            user.setSex("男");
        } else if (user.getSex().equals("0")) {
            user.setSex("女");
        } else {
            user.setSex("未知");
        }
        return user;
    }
}
