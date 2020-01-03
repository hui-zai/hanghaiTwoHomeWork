package com.jx.service.impl;

import com.jx.dao.UserDao;
import com.jx.model.User;
import com.jx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yjx on 2019/12/23.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> showUser() {
        List<User> users = userDao.showUser();
        for(int i=0;i<users.size();i++){
            String hobby = users.get(i).getHobby();
            String[] arr = hobby.split(","); // 用,分割
            users.get(i).setHobbys(arr);
            users.get(i).setHobby(null);
        }
        return users;
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        String hobby = "";
        for (String str : user.getHobbys()) {
            hobby += str+",";
        }
        hobby = hobby.substring(0,hobby.length()-1);
        user.setHobby(hobby);
        return userDao.updateUser(user);
    }

    @Override
    public int insertUser(User user) {
        String hobby = "";
        for (String str : user.getHobbys()) {
            hobby += str+",";
        }
        hobby = hobby.substring(0,hobby.length()-1);
        user.setHobby(hobby);
        return userDao.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        User user = userDao.selectUser(id);
        String hobby = user.getHobby();
        String[] arr = hobby.split(","); // 用,分割
        user.setHobbys(arr);
        user.setHobby(null);
        return user;
    }


}
