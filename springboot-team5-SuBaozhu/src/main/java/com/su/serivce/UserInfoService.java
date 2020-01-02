package com.su.serivce;

import com.su.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {
    //查询所有用户信息
    public List<UserInfo> findAll();
    public void save(UserInfo userInfo);
    //修改用户信息
    public void update(UserInfo userInfo);

    public void deleteById(Integer id);
}