package com.chen;

import com.chen.dao.UserInfoRepository;
import com.chen.pojo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.reflect.generics.tree.VoidDescriptor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserInfoRepository dao;

    @Test
    public  void test1(){
        UserInfo user =  new UserInfo();
        user.setUsername("user");
        user.setSex("男");
        user.setProvince("广东");
        user.setEmail("123@163.com");
        user.setHobby("弹琴");
        dao.save(user);
        System.out.println("添加成功");
    }

    @Test
    public void test2(){
        UserInfo user =  new UserInfo();
        user.setId(2);
        user.setUsername("user");
        user.setSex("男");
        user.setProvince("广东");
        user.setEmail("123@163.com");
        user.setHobby("弹琴");
        dao.save(user);
        System.out.println("修改用户成功");
    }

    @Test
    public void test3(){
        dao.deleteById(2);
        System.out.println("删除用户成功");
    }
}
