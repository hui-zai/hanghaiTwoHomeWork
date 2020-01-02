package com.lin.controller;

import com.lin.pojo.ResponseResult;
import com.lin.pojo.User;
import com.lin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @DeleteMapping("/{id:\\d}")
    public ResponseResult update(@PathVariable("id") Integer id){
        ResponseResult result=new ResponseResult();

        userService.deleteUser(id);

        result.setCode(0);
        result.setMsg("success");

        return result;
    }


    @PutMapping
    public ResponseResult update(@RequestBody User user){
        ResponseResult result=new ResponseResult();

        user = userService.saveUser(user);

        result.setCode(0);
        result.setMsg("success");
        result.setData(user);

        return result;
    }



    @PostMapping()
    public ResponseResult  add(@RequestBody User user){

        ResponseResult result=new ResponseResult();

        user = userService.addUser(user);

        result.setCode(0);
        result.setMsg("success");
        result.setData(user);

        return result;
    }

    @GetMapping
    public ResponseResult get(){

        ResponseResult result=new ResponseResult();

        List<User> users=userService.getAllUsers();

        result.setData(users);
        result.setMsg("success");
        result.setCode(0);

        return result;
    }
}
