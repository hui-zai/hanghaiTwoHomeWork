package cn.hl.controller;

import cn.hl.bean.ResponseEntity;
import cn.hl.bean.User;
import cn.hl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //删除用户
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        userService.deleteById(id);
        return new ResponseEntity("删除成功","200",null);
    }

    //修改用户
    @PutMapping
    public ResponseEntity update(@RequestBody User User){
        System.out.println("更新用户："+User);
        userService.save(User);
        return new ResponseEntity("更新成功","200",null);
    }

    //添加用户
    @PostMapping
    public ResponseEntity save(@RequestBody User User){
        userService.save(User);
        return new ResponseEntity("新增成功","200",null);
    }

    //查询所有用户
    @GetMapping
    public List<User> query(){
        return userService.findAll();
    }

}
