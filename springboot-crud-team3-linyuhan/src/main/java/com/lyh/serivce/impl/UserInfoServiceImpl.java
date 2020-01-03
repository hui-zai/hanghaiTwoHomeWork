package com.lyh.serivce.impl;


import com.lyh.dao.UserInfoRepository;
import com.lyh.pojo.UserInfo;
import com.lyh.serivce.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService {
    //注入dao
    @Autowired
    private UserInfoRepository dao;

    /**
     * date(UserInfo userInfo);
     *     //
     * @param id
     */
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
