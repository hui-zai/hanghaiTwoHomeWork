package com.serivce.impl;

import com.dao.Dao;
import com.domain.User;
import com.serivce.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private Dao dao;

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
