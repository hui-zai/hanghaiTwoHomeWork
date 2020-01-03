package com.kfk.crud.controller;

import com.kfk.crud.entity.Result;
import com.kfk.crud.entity.StatusCode;
import com.kfk.crud.pojo.Userinfo;
import com.kfk.crud.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserinfoService userinfoService;


    /**
     * 新增用户
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result addUser(@RequestBody Userinfo userinfo){
        userinfoService.addUser(userinfo);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    /**
     * 修改用户信息
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result updateUser(@RequestBody  Userinfo userinfo,@PathVariable String id){
        userinfoService.updateUser(userinfo,id);
        return new Result(true, StatusCode.OK,"修改成功");
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result deleteUesr(@PathVariable String id){
        userinfoService.deleteUesr(id);
        return new Result(true, StatusCode.OK,"删除成功");
    }

    /**
     * 查询用户信息
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAllUser(){
        return new Result(true, StatusCode.OK,"查询成功",userinfoService.findAllUser());
    }
}
