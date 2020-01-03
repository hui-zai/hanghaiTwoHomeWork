package com.example.springbootcrudteam6luzhijian.service;

import com.example.springbootcrudteam6luzhijian.pojo.User;

import java.util.List;

public interface UserService {
    //查询所有用户信息
    public List<User> findAll();
    //新增用户信息
    public void save(User userInfo);
    //修改用户信息
    public void update(User userInfo);
    //删除用户信息
    public void deleteById(Integer id);

    public List<User> findByUsername(String username);

    public User findOne(Integer id);
}
