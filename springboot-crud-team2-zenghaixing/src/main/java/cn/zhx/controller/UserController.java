package cn.zhx.controller;

import cn.zhx.hhxx.ResponseObject;
import cn.zhx.hhxx.User;
import cn.zhx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    //删除用户
    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Integer id){
        service.deleteById(id);
        return new ResponseObject("删除成功","200",null);
    }

    //修改用户
    @PutMapping
    public ResponseObject update(@RequestBody User user){
        System.out.println("更新用户："+user);
        service.save(user);
        return new ResponseObject("更新成功","200",null);
    }

    //新增用户
    @PostMapping
    public ResponseObject save(@RequestBody User user){
        System.out.println("新增用户："+user);
        service.save(user);
        return new ResponseObject("新增成功","200",null);
    }

    //查询所有用户
    @GetMapping
    public List<User> query(){
        return service.findAll();
    }
}
