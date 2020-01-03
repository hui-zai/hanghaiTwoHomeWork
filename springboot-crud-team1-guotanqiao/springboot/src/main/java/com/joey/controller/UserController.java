package com.joey.controller;


import com.joey.dao.UserDao;
import com.joey.pojo.DelUser;
import com.joey.pojo.ResponseEntity;
import com.joey.pojo.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userdao;


    @GetMapping("/hello")
    public String sayHello(){
        System.out.println("welcome...");
        return  "hello...";
    }

    @GetMapping()
    public List<User> queryAll(){

        List<User> users = userdao.findAll();

        return  users;
    }

    /**
     * 单个查询
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public User getInfo(@PathVariable(name = "id",required = true) ObjectId id){

        userdao.findById(id);
        return null;

    }

    /**
     * 创建
     */
    @PostMapping()
    public ResponseEntity createUser(@RequestBody User user){

        System.out.println(user.toString());
        userdao.save(user);
        ResponseEntity responseEntity =  new ResponseEntity("添加成功",200);
        return responseEntity;

    }

    /**
     * 删除
     */
    @PostMapping("/del")
    public ResponseEntity deleteUser(@RequestBody DelUser id){
        //通过自定义接收前端对象 获取ObjectId
        System.out.println(id);
        System.out.println(id.getId());
        Optional<User> byId = userdao.findById(id.getId());
        System.out.println(byId);
        if(byId.isPresent()){
            System.out.println("have...");
            userdao.delete(byId.get());
        }

        ResponseEntity responseEntity =  new ResponseEntity("删除成功",200);
        return responseEntity;

    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public ResponseEntity updateUser(@RequestBody User user){

        System.out.println(user);
        userdao.save(user);
        ResponseEntity responseEntity =  new ResponseEntity("修改",200);
        return responseEntity;

    }

}
