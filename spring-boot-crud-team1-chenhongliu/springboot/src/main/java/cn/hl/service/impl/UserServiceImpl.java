package cn.hl.service.impl;

import cn.hl.bean.User;
import cn.hl.dao.UserRepository;
import cn.hl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository dao;

    //删除
    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    //更改
    @Override
    public void update(User User) {
        dao.save(User);
    }

    //添加保存
    @Override
    public void save(User User) {
        dao.save(User);
    }

    //查询所有
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

}
