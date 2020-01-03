package com.peijiani.web;

import com.peijiani.domain.User;
import com.peijiani.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService baseService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<User> list() {
        List<User> list = baseService.getList();
        for(int x = 0; x < list.size(); x++){
            if(list.get(x).getSex() == 0){
                list.get(x).setSexStr("女");
            }else if(list.get(x).getSex() == 1){
                list.get(x).setSexStr("男");
            }else{
                list.get(x).setSexStr("未知");
            }
        }
        return list;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    private String update(@RequestBody User user) {
        int index;
        if (user.getId() == null) {
            index = baseService.addUser(user);
        }else{
            index = baseService.updateUser(user);

        }
        return index > 0 ? "successful" : "failed";
    }

    @RequestMapping(value = "/findByUsername/{username}", method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByUsername(@PathVariable("username") String username) {
        List<User> list = baseService.getByUsername(String.valueOf("%" + username + "%"));
        return list;
    }

    @RequestMapping(value = "/deleteById/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteById(@PathVariable("userId") Long id) {
        int index = baseService.deleteUserById(id);
        return index > 0 ? "success" : "failed";
    }
}
