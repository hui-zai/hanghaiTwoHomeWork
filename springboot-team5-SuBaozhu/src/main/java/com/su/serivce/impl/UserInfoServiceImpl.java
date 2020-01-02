package com.su.serivce.impl;

import com.su.dao.UserInfoRepository;
import com.su.pojo.UserInfo;
import com.su.serivce.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {
    //注入dao
    @Autowired
    private UserInfoRepository dao;
    @Override
    public List<UserInfo> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        dao.save(userInfo);
    }
    @Override
    public void update(UserInfo userInfo) {
        dao.save(userInfo);
    }
    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);

    }
}
