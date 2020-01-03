package com.anchengxu.service.impl;

import com.anchengxu.dao.BaseDao;
import com.anchengxu.entity.User;
import com.anchengxu.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private BaseDao baseDao;
    public User getById(long userId){
        return baseDao.queryById(userId);
    }
    public List<User> getList(){
        List<User> list =  baseDao.queryAll( );
        return list;
    }

    public List<User> getByUsername(String username){
        List<User> list =  baseDao.queryByUsername(username);
        return list;
    }
    public int addUser(User user){
        return baseDao.addUser(user);
    }
    public int updateUser(User user){
        return baseDao.updateUser(user);
    }
    public int deleteUserById(long id){
        return baseDao.deleteUserById(id);
    }
    public List<User> deleteUserByIdReturnList(long id){
        //删除元素后，进行又一次检索
        baseDao.deleteUserById(id);
        return getList();
    }
}
