package com.chen.service;

import com.chen.common.Result;
import com.chen.dao.UserInfoRepository;
import com.chen.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository dao;

    public Result findAll(){
        return new Result("查询成功","200",dao.findAll());
    }

    public Result addUser(UserInfo userinfo){
        dao.save(userinfo);
        return new Result("添加成功","200",null);
    }

    public Result deleteUser(Integer id){
        dao.deleteById(id);
        return new Result("删除成功","200",null);
    }

    public Result updateUser(UserInfo userinfo){
        dao.save(userinfo);
        return new Result("修改成功","200",null);
    }

    public Result getUserById(Integer id){
        return new Result("查询成功","200",dao.findById(id).orElse(null));

    }
}
