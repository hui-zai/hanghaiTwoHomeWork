package cn.zhx.service;


import cn.zhx.hhxx.User;

import java.util.List;

public interface UserService {
    //查询所有用户信息
    public List<User> findAll();
    //新增用户信息
    public void save(User user);
    //修改用户信息
    public void update(User user);
    //删除用户信息
    public void deleteById(Integer id);
}
