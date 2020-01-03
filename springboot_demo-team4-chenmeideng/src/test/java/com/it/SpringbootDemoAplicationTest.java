package com.it;

import com.it.dao.UserDao;
import com.it.po.User;
import com.it.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoAplicationTest {
    @Autowired
    private UserService service;
    @Test
    public void contextLoads() {
    }
    @Test
    public void quick(){
        User user = new User();
        user.setId(4);
        user.setUsername("小李");
        user.setEmail("123@123");
        user.setSex("女");
        user.setProvince("北京");
        user.setHobby("篮球");
        service.save(user);


    }

}
