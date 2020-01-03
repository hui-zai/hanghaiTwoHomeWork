package com.homework.homework.controller;

import com.homework.homework.pojo.Userinfo;
import com.homework.homework.service.UserinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource(name="userinfoServiceImpl")
    public UserinfoService service;

    @RequestMapping("list")
    @ResponseBody
    public List<Userinfo> list(){
        List<Userinfo> list=service.searchall();
        System.out.println(list.size());
        return list;
    }

    @RequestMapping("save")
    @ResponseBody
    public String  save(@RequestBody  Userinfo info){
        System.out.println(info.toString());
        service.save(info);
        return "success";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(String index){
        System.out.println(index);
        service.delete(index);
        return "success";
    }
}
