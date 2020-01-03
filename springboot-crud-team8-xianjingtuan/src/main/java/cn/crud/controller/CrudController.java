package cn.crud.controller;

import cn.crud.pojo.ResponseObject;
import cn.crud.service.UserInfoService;
import cn.crud.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userinfo")
public class CrudController {

    //注入业务层
    @Autowired
    private UserInfoService service;
    //新增用户
    @PostMapping
    public ResponseObject save(@RequestBody UserInfo userInfo){
        service.save(userInfo);
        return new ResponseObject("新增成功","200",null);
    }

    @GetMapping
    public List<UserInfo> queryAll(){
        return service.findAll();
    }

    @PutMapping
    public ResponseObject updata(@RequestBody UserInfo userInfo){
        service.save(userInfo);
        return new ResponseObject("更新成功","200",null);
    }

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Integer id){
        service.deleteById(id);
        return new ResponseObject("删除成功","200",null);
    }


}
