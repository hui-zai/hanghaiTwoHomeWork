package com.jx.controller;

import com.jx.model.User;
import com.jx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yjx on 2019/12/23.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/userAll")
    public List<User> showUser(){
        return userService.showUser();
    }

    @GetMapping(value = "/selectUser")
    public User selectUser(int id){
        return userService.selectUser(id);
    }

    @PostMapping(value="/insertUser")
    public boolean addUser(@RequestBody User user){
        if(userService.insertUser(user)>0){
            return true;
        }
        else {
            return false;
        }
    }

    @PostMapping(value = "/updateUser")
    public boolean updateUser(@RequestBody User user){
        if(userService.updateUser(user)>0){
            return true;
        }
        else {
            return false;
        }
    }

    @GetMapping(value = "/deleteUser")
    public boolean deleteUser(int id){
        if(userService.deleteUser(id)>0){
            return true;
        }
        else {
            return false;
        }
    }
}
