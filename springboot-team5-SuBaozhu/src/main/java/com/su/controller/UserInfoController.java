package com.su.controller;

import com.su.pojo.ResponseObject;
import com.su.pojo.UserInfo;
import com.su.serivce.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService service;

    //新增用户
    @PostMapping
    public ResponseObject save(@RequestBody UserInfo userInfo){
        service.save(userInfo);
        return new ResponseObject("新增成功","200",null);
    }

//查询用户
    @GetMapping
    public List<UserInfo> query(){
        return service.findAll();
    }
    //删除用户
    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Integer id){
        service.deleteById(id);
        return new ResponseObject("删除成功","200",null);
    }
}