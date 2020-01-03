package com.hh.controller;

import com.hh.pojo.ResponseObject;
import com.hh.pojo.UserInfo;
import com.hh.server.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 查询所有
      * @return
     */
    @GetMapping
    public List<UserInfo> findAll(){

        return userInfoService.findAll();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public UserInfo findById(@PathVariable Integer id){
        return userInfoService.findById(id);
    }


    //新增用户
    @PostMapping
    public ResponseObject save(@RequestBody UserInfo userInfo){
        System.out.println("新增用户："+userInfo);
        userInfoService.save(userInfo);
       return new ResponseObject("abc", "200", null);
    }


    //删除用户
    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Integer id){
        userInfoService.deleteById(id);
        return new ResponseObject("删除成功","200",null);
    }
}
