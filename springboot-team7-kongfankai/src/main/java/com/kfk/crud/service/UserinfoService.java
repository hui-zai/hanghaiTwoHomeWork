package com.kfk.crud.service;

import com.kfk.crud.dao.UserinfoDao;
import com.kfk.crud.entity.IdWorker;
import com.kfk.crud.pojo.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserinfoService {
    @Autowired
    private UserinfoDao userinfoDao;
    @Autowired
    private IdWorker idWorker;
    /**
     * 新增用户
     */
    public void addUser(Userinfo userinfo){
        userinfo.setId(idWorker.nextId()+"");
        userinfoDao.save(userinfo);
    }

    /**
     * 修改用户信息
     */
    public void updateUser(Userinfo userinfo,String id){
        userinfo.setId(id);
        userinfoDao.save(userinfo);
    }

    /**
     * 删除用户
     */
    public void deleteUesr(String id){
        userinfoDao.deleteById(id);
    }

    /**
     * 查询用户信息
     */
    public List<Userinfo> findAllUser(){
        return userinfoDao.findAll();
    }
}
