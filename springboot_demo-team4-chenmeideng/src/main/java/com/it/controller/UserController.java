package com.it.controller;

import com.it.dao.ResponseObject;
import com.it.po.User;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    /*@RequestMapping("/quick")
    @ResponseBody
    public String quick(){

        List<User> query = query();

        return "访问成功!";
    }*/
    @GetMapping
    @ResponseBody
    public List<User> query(){
        return service.findAll();
    }

    //修改用户
    @PostMapping
    public ResponseObject save(@RequestBody User user){
        System.out.println("新增用户："+user);
        service.save(user);
        return new ResponseObject("新增成功","200",null);
    }
    //修改用户
    @PutMapping
    public ResponseObject update(@RequestBody User user){
        System.out.println("更新用户："+user);
        service.save(user);
        return new ResponseObject("更新成功","200",null);
    }
    //删除用户
    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Integer id){
        service.deleteById(id);
        return new ResponseObject("删除成功","200",null);
    }


}
