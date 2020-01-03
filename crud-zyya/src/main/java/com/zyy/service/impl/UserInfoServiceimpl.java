package com.zyy.service.impl;

import com.zyy.dao.UserInfoRepository;
import com.zyy.pojo.UserInfo;
import com.zyy.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserInfoServiceimpl implements UserInfoService {

    @Autowired
    private UserInfoRepository dao;
    @Override
    public List<UserInfo> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(UserInfo userinfo) {
        dao.save(userinfo);

    }
    @Override
    public void update(UserInfo userinfo) {
        dao.save(userinfo);

    }
    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);

    }
}
