package comzxw.controller;

import comzxw.pojo.ResponseObject;
import comzxw.pojo.UserInfo;
import comzxw.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService service;

    //新增用户的信息
    @PostMapping
    public ResponseObject save(@RequestBody UserInfo userInfo){
        System.out.println("新增用户："+userInfo);
        service.save(userInfo);
        return new ResponseObject("新增成功","200",null);
    }

    //修改用户的信息
    @PutMapping
    public ResponseObject update(@RequestBody UserInfo userInfo){
        System.out.println("更新用户："+userInfo);
        service.save(userInfo);
        return new ResponseObject("更新成功","200",null);
    }

     //查询所有的用户信息
    @GetMapping
    public List<UserInfo> query(){
        return service.findAll();
    }

    //删除用户信息
    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Integer id){
        service.deleteById(id);
        return new ResponseObject("删除成功","200",null);
    }
}

