package com.hh.server.impl;

import com.hh.dao.UserInfoRespority;
import com.hh.pojo.ResponseObject;
import com.hh.pojo.UserInfo;
import com.hh.server.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRespority userInfoRespority;

    @Override
    public List<UserInfo> findAll() {
        return userInfoRespority.findAll();
    }

    @Override
    public UserInfo findById(Integer id) {
        return userInfoRespority.findById(id).get();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfoRespority.save(userInfo);
    }

    @Override
    @PostMapping
    public ResponseObject update(@RequestBody UserInfo userInfo) {

        userInfoRespority.save(userInfo);
        return new ResponseObject("更新","200",null);
    }

    //删除用户

    public ResponseObject deleteById(@PathVariable Integer id){
        userInfoRespority.deleteById(id);
        return new ResponseObject("删除成功","200",null);
    }


}
