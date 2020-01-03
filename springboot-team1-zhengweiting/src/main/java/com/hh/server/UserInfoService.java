package com.hh.server;


import com.hh.pojo.ResponseObject;
import com.hh.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {


    List<UserInfo> findAll();

    UserInfo findById(Integer id);

    void save(UserInfo userInfo);
    ResponseObject update(UserInfo userInfo);
    ResponseObject deleteById(Integer id);

}
