package com.zzs.crud.controller;

import com.zzs.crud.entity.User;
import com.zzs.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZZS
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/users/del")
    public String del(@RequestParam Integer id) {
        userService.del(id);
        return "success";
    }


    @PostMapping("/modify")
    public String save(@RequestBody User user){
        userService.save(user);
        return "success";
    }

    @PutMapping("/modify")
    public String update(@RequestBody User user){
        userService.update(user);
        return "success";
    }
}
