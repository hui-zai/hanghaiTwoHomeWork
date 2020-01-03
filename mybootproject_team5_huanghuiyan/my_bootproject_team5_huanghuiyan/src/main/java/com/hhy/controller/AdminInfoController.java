package com.hhy.controller;

import com.hhy.pojo.AdminInfo;
import com.hhy.pojo.ResponseEntity;
import com.hhy.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminInfoController {
    @Autowired
    private AdminInfoService service;

    //查询请求
    @GetMapping
    public List<AdminInfo> query(){
        return service.findAll();
    }

    //新增请求
    @PostMapping
    public ResponseEntity add(@RequestBody AdminInfo adminInfo){
        service.save(adminInfo);
        return new ResponseEntity("新增成功","200",null);
    }
}
