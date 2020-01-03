package com.huangxiaoyan.hservice.impl;

import com.huangxiaoyan.hdao.IDao;
import com.huangxiaoyan.hentity.User;
import com.huangxiaoyan.hservice.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IServiceImpl implements IService {
    @Autowired
    private IDao iDao;
    public User getById(long userId){
        return iDao.queryById(userId);
    }
    public List<User> getList(){
        List<User> list =  iDao.queryAll( );
        return list;
    }

    public List<User> getByUsername(String username){
        List<User> list =  iDao.queryByUsername(username);
        return list;
    }
    public int addUser(User user){
        return iDao.addUser(user);
    }
    public int updateUser(User user){
        return iDao.updateUser(user);
    }
    public int deleteUserById(long id){
        return iDao.deleteUserById(id);
    }
    public List<User> deleteUserByIdReturnList(long id){
        //删除元素后，进行又一次检索
        iDao.deleteUserById(id);
        return getList();
    }
}
