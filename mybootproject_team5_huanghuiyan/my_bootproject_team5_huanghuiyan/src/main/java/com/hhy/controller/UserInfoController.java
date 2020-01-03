package com.hhy.controller;

import com.hhy.pojo.ResponseEntity;
import com.hhy.pojo.UserInfo;
import com.hhy.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService service;

    //查询请求
    @GetMapping
    public List<UserInfo> query(){
        return service.findAll();
    }

    //新增请求
    @PostMapping
    public ResponseEntity add(@RequestBody UserInfo userInfo){
        service.save(userInfo);
        return new ResponseEntity("新增成功","200",null);
    }

    //修改请求
    @PutMapping
    public ResponseEntity update(@RequestBody UserInfo userInfo){
        service.save(userInfo);
        return new ResponseEntity("修改成功","200",null);
    }

    //删除数据
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        service.deleteById(id);
        return new ResponseEntity("删除成功","200",id);
    }
}
