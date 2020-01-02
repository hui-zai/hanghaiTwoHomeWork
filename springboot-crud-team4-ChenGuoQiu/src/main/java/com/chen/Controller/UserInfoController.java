package com.chen.Controller;

import com.chen.common.Result;
import com.chen.pojo.UserInfo;
import com.chen.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/study1")
public class UserInfoController {
    @Autowired
    private UserInfoService service;

    @GetMapping("/all")
    public Result findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Result getUserById(@PathVariable(value="id") Integer id){
        return  service.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public Result DeleteUser(@PathVariable(value="id") Integer id){
        return service.deleteUser(id);
    }

    @PutMapping
    public Result addUser(@RequestBody UserInfo userinfo){
        return service.addUser(userinfo);
    }

    @PostMapping
    public Result updateUser(@RequestBody UserInfo userinfo){
        return service.updateUser(userinfo);
    }


}
