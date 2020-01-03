package com.hhy.service.Impl;

import com.hhy.dao.UserInfoRepository;
import com.hhy.pojo.UserInfo;
import com.hhy.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository dao;

    //查询所有用户
    @Override
    public List<UserInfo> findAll() {
        return dao.findAll();
    }

    //新增数据
    @Override
    public void save(UserInfo userInfo) {
        dao.save(userInfo);
    }

    //修改数据
    @Override
    public void update(UserInfo userInfo) {
        dao.save(userInfo);
    }

    //删除数据
    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }
}
