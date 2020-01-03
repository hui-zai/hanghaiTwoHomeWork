package com.cwz.serivce.impl;


import com.cwz.dao.UserInfoRepository;
import com.cwz.pojo.UserInfo;
import com.cwz.serivce.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @ProjectName: springboot-team7-chengweizhao
 * @Package: com.cwz.serivce.impl
 * @ClassName: UserInfoService
 * @Author: 程伟钊
 * @Description: service实现类
 * @Date: 2020/1/1 22:32
 */

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
