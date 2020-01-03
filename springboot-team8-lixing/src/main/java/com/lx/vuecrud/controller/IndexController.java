package com.lx.vuecrud.controller;

import com.lx.vuecrud.model.User;
import com.lx.vuecrud.model.UserJson;
import com.lx.vuecrud.service.UserService;
import com.lx.vuecrud.util.UserUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * create by @author lixing on 2019/12/24 20:59
 */
@RestController
public class IndexController {

    @Autowired
    private UserService userService;
    @GetMapping("/find")
    public List findAll() {
        return userService.findAll();
    }

    @PostMapping("/update")
    public String update(@RequestBody UserJson user) {
        /*String[] hobby = user.getHobby();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < hobby.length ; i++) {
            builder.append(hobby[i]);
            if (i != hobby.length-1) {
                builder.append("|");
            }
        }
        User user1 = new User();
        BeanUtils.copyProperties(user, user1);
        user1.setHobby(builder.toString());*/
        User user1 = UserUtil.change(user);
        Integer mark = userService.update(user1);
        if (mark == 0) {
            return "更新失败";
        }else{
             return "更新成功";
        }
    }

    @PostMapping("/add")
    public String add(@RequestBody UserJson user) {
        User change = UserUtil.change(user);
        int mark = userService.addUser(change);
        if (mark == 1) {
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    @GetMapping("/del")
    public String del(Integer index) {
        int mark = userService.del(index);
        if(mark == 1) {
            return "删除成功";
        }else {
            return "删除失败";
        }
    }
}
