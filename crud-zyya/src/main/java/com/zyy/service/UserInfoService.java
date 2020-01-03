package com.zyy.service;

import com.zyy.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {
    //查询all信息
    public List<UserInfo> findAll();
    //增信息
    public void save (UserInfo userinfo);
    //改
    public void update (UserInfo userinfo);
    //删
    public void deleteById (Integer id);
}
