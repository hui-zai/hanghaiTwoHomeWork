package com.ning.service.impl;

import com.ning.dao.UserInfoRepository;
import com.ning.pojo.UserInfo;
import com.ning.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository dao;

    /***
     * 查询所有用户
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        return dao.findAll();
    }

    /***
     * 新增用户
     *
     * @param userInfo
     */
    @Override
    public void save(UserInfo userInfo) {
        dao.save(userInfo);
    }

    /***
     * 修改用户
     * @param userInfo
     */
    @Override
    public void update(UserInfo userInfo) {
        dao.save(userInfo);
    }

    /***
     * 删除用户
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }
}
