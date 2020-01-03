package com.example.springbootcrudteam6luzhijian.controller;

import com.example.springbootcrudteam6luzhijian.pojo.ResponseResult;
import com.example.springbootcrudteam6luzhijian.pojo.User;
import com.example.springbootcrudteam6luzhijian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    //删除用户
    @GetMapping("del")
    public ResponseResult delete( Integer id){
        service.deleteById(id);
        return new ResponseResult("删除成功","200",null);
    }

    //修改用户
    @PostMapping("/update")
    public ResponseResult update(@RequestBody User User){
        System.out.println("更新用户："+User);
        service.save(User);
        return new ResponseResult("更新成功","200",null);
    }

    //新增用户
    @PostMapping("/save")
    public ResponseResult save(@RequestBody User User){
        System.out.println("新增用户："+User);
        service.save(User);
        return new ResponseResult("新增成功","200",null);
    }

    //查询所有用户
    @GetMapping("/query")
    public List<User> query(){
        return service.findAll();
    }

    @GetMapping("/findByUsername")
    public List<User> findByUsername(String username){
        return service.findByUsername(username);
    }

    @GetMapping("/findOne")
    public User findOne(Integer id){
        return service.findOne(id);
    }
}
