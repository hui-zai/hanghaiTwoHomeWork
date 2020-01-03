package com.peijiani.service.impl;

import com.peijiani.dao.IUserDao;
import com.peijiani.domain.User;
import com.peijiani.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    public User getById(long userId){
        return userDao.queryById(userId);
    }
    public List<User> getList(){
        List<User> list =  userDao.queryAll( );
        return list;
    }

    public List<User> getByUsername(String username){
        List<User> list =  userDao.queryByUsername(username);
        return list;
    }
    public int addUser(User user){
        return userDao.addUser(user);
    }
    public int updateUser(User user){
        return userDao.updateUser(user);
    }
    public int deleteUserById(long id){
        return userDao.deleteUserById(id);
    }
}
