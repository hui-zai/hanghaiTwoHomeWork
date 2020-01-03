package cn.crud.controller;

import cn.crud.pojo.ResponseObject;
import cn.crud.service.UserInfoService;
import cn.crud.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CrudController {

    //注入业务层
    @Autowired
    private UserInfoService service;
    @GetMapping("findall") //或@GetMapping写法也行
    public List<UserInfo> findAll(){
        return service.findAll();
    }

    @PostMapping
    public ResponseObject save(@RequestBody UserInfo userInfo) {
        System.out.println("新增成功"+userInfo);
        service.save(userInfo);
        return  new ResponseObject("新增成功","200",null);
    }
    @PutMapping
    public ResponseObject update(@RequestBody UserInfo userInfo) {
        System.out.println("修改成功"+userInfo);
        service.update(userInfo);
        return  new ResponseObject("修改成功","200",null);
    }
    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Integer id){
        service.deleteById(id);
        return  new ResponseObject("删除成功","200",null);
    }

}
