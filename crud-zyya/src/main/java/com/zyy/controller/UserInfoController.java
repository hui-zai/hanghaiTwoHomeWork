package com.zyy.controller;

import com.zyy.pojo.ResponseObject;
import com.zyy.pojo.UserInfo;
import com.zyy.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService service;

    //新增
    @PostMapping
    public ResponseObject save(@RequestBody UserInfo userinfo){
        System.out.println("新增用户"+userinfo);
        service.save(userinfo);
        return new ResponseObject("succes","200",null);
    }



    //查询
    @GetMapping
    public List<UserInfo> query(){
        return service.findAll();
    }

    //改
    @PutMapping
    public ResponseObject updata(@RequestBody UserInfo userinfo){
        System.out.println("修改用户"+userinfo);
        service.save(userinfo);
        return new ResponseObject("succes","200",null);
    }

    //删
    @DeleteMapping("/{id}")
    public  ResponseObject delete(@PathVariable Integer id){
        service.deleteById(id);
        return new ResponseObject("succes","200",null);
    }

}
