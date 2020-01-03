package com.anchengxu.web;

import com.anchengxu.entity.User;
import com.anchengxu.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseService baseService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<User> list(Model model) {
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

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public User findUserById(@PathVariable("userId") Long id) {
        User user = baseService.getById(id);
        if(user.getSex() == 0){
            user.setSexStr("女");
        }else{
            user.setSexStr("男");
        }
        return user;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    private String update(@RequestBody User user) {
        if (user.getId() == null) {
            int index = baseService.addUser(user);
            return "the user has add to table successful";
        }else{
            User isBook = baseService.getById(user.getId());
            int index = baseService.updateUser(user);
            return "the user has already update";
        }

    }

    @RequestMapping(value = "/search/{username}", method = RequestMethod.GET)
    @ResponseBody
    public List<User> search(@PathVariable("username") String username) {
        List<User> list = baseService.getByUsername(String.valueOf("%" + username + "%"));
        return list;
    }

    @RequestMapping(value = "/del/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteUserById(@PathVariable("userId") Long id) {
        //List<User> list = baseService.deleteUserByIdReturnList(id);

        int index = baseService.deleteUserById(id);
        return index > 0 ? "success" : "error";
    }
}
