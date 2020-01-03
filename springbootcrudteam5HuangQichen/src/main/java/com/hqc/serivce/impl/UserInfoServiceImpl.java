package com.hqc.serivce.impl;


import com.hqc.dao.UserInfoRepository;
import com.hqc.pojo.UserInfo;
import com.hqc.serivce.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService {
    //注入dao
    @Autowired
    private UserInfoRepository dao;

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    /**
     * 修改用户信息
     * @param userInfo
     */
    @Override
    public void update(UserInfo userInfo) {
        dao.save(userInfo);
    }

    /**
     * 新增用户
     * @param userInfo
     */
    @Override
    public void save(UserInfo userInfo) {
        dao.save(userInfo);
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        return dao.findAll();
    }
}
