package demo.Contoller;


import demo.pojo.UserInfo;
import demo.service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService service;

    @GetMapping
    public List<UserInfo> query() {
        return service.findAll();
    }


    @PostMapping
    public String save(@RequestBody UserInfo userInfo) {
        service.save(userInfo);
        return "success";
    }

    @PutMapping
    public String update(@RequestBody UserInfo userInfo) {

        service.save(userInfo);

        return "success";

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        service.deleteById(id);
        return "success";
    }
}
