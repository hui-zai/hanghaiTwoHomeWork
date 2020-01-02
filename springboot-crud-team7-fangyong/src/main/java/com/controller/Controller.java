package com.controller;

import com.domain.ResponseObject;
import com.domain.User;
import com.serivce.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userinfo")
public class Controller {
    @Autowired
    private UserInfoService service;

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Integer id){
        service.deleteById(id);
        return new ResponseObject("删除成功","200",null);
    }

    @PutMapping
    public ResponseObject update(@RequestBody User user){
        service.save(user);
        return new ResponseObject("更新成功","200",null);
    }

    @PostMapping
    public ResponseObject save(@RequestBody User user){
        service.save(user);
        return new ResponseObject("新增成功","200",null);
    }


    @GetMapping
    public List<User> query(){
        return service.findAll();
    }
}
