package cn.hh.service.impl;

import cn.hh.dao.UserInfoRepository;
import cn.hh.pojo.UserInfo;
import cn.hh.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
 @Service
public class UserInfoServiceImpl  implements UserInfoService {
    //注入dao
    @Autowired
    private UserInfoRepository dao;
    @Override
     public List<UserInfo> findAll() {
            return dao.findAll();
     }
     //新增用户
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