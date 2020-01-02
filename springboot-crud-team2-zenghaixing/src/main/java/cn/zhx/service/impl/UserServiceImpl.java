package cn.zhx.service.impl;

import cn.zhx.dao.UserRepository;
import cn.zhx.hhxx.User;
import cn.zhx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    //注入dao
    @Autowired
    private UserRepository dao;

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public void update(User user) {
        dao.save(user);
    }

    @Override
    public void save(User user) {
        dao.save(user);
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
