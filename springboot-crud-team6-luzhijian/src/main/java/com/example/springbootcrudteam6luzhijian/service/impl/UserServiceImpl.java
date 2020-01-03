package com.example.springbootcrudteam6luzhijian.service.impl;


import com.example.springbootcrudteam6luzhijian.dao.UserRepository;
import com.example.springbootcrudteam6luzhijian.pojo.User;
import com.example.springbootcrudteam6luzhijian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    //注入dao
    @Autowired
    private UserRepository dao;

    /**
     * date(User User);
     *     //
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<User> findByUsername(String username) {
        //自定义条件查询
        //定义条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.contains()) ;
        //条件值对象
        User user = new User();
        //设置条件值
        if (username!=null&&!"".equals(username)) {
            user.setUsername(username);
        }
        //定义条件对象Example
        Example<User> example = Example.of(user, exampleMatcher);
        return dao.findAll(example);
    }

    @Override
    public User findOne(Integer id) {
        return dao.findById(id).get();
    }

    /**
     * 修改用户信息
     * @param User
     */
    @Override
    public void update(User User) {
        dao.save(User);
    }

    /**
     * 新增用户
     * @param User
     */
    @Override
    public void save(User User) {
        dao.save(User);
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
