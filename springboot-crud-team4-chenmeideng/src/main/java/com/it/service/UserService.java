package com.it.service;

import com.it.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    //查询所有用户信息
    public List<User> findAll();

    //新增用户
    public void save(User user);

    //修改用户
    public void update(User user);

    //删除用户
    public void deleteById(Integer id);
}
