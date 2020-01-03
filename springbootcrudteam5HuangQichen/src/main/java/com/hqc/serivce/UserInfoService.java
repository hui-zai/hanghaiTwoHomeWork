package com.hqc.serivce;

import com.hqc.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {
    //查询所有用户信息
    public List<UserInfo> findAll();
    //新增用户信息
    public void save(UserInfo userInfo);
    //修改用户信息
    public void update(UserInfo userInfo);
    //删除用户信息
    public void deleteById(Integer id);
}
