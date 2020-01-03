package com.it.service;


import com.it.dao.UserDao;
import com.it.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userdao;
    @Override
    public List<User> findAll() {
        return userdao.findAll();
    }
    //新增操作
    @Override
    public void save(User user) {
        userdao.save(user);
    }
    //新增用户
    @Override
    public void update(User user) {
        userdao.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userdao.deleteById(id);
    }
}
