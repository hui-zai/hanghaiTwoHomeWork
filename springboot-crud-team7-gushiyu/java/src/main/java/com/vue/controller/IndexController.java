package com.vue.controller;

import com.vue.model.Vue;
import com.vue.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    IndexService indexService;


    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/list")
    @ResponseBody
    public  List<Vue> list(){
        List<Vue> vues = indexService.list();
        return vues;
    }
//JSON传入数据
    @PostMapping("/insert")
    @ResponseBody
    public String insert(@RequestBody Vue vueInsert){
        System.out.println("INSERT:"+vueInsert.toString());
        indexService.insert(vueInsert);
        return "index";
    }

    @PostMapping("/update")
    @ResponseBody
    public void update(@RequestBody Vue vueUpdate){
        System.out.println("UPDATE:"+vueUpdate.toString());
        indexService.update(vueUpdate);
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable(name="id") Integer id){
        System.out.println(id);
        indexService.delete(id);
    }
}
