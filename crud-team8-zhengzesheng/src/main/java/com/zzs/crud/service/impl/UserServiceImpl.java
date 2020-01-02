package com.zzs.crud.service.impl;

import com.zzs.crud.dao.UserMapper;
import com.zzs.crud.entity.User;
import com.zzs.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZZS
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public void del(Integer id) {
        userMapper.del(id);
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }
}
